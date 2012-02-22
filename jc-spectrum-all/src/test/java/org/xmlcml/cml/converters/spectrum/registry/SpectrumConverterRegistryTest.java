package org.xmlcml.cml.converters.spectrum.registry;

import static org.junit.Assert.assertNull;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.cml.CML2CMLLiteConverter;
import org.xmlcml.cml.converters.cml.CMLCommon;
import org.xmlcml.cml.converters.crystal.registry.CrystalConverterRegistry;
import org.xmlcml.cml.converters.registry.ConverterRegistry;
import org.xmlcml.cml.converters.registry.TypePair;
import org.xmlcml.cml.converters.spectrum.jdx.JDXModule;

public class SpectrumConverterRegistryTest {

	String CML = "chemical/x-cml";
	String JDX = "chemical/x-jcamp-dx";
	String FOO = "chemical/x-foo";
	TypePair PAIR_OK  = new TypePair(JDX, CML);
	TypePair PAIR_MISSING  = new TypePair(FOO, JDX);
	private static int SIZE = 7;

    @Test
    public void testMap() {
    	Map<TypePair, List<Converter>> map = CrystalConverterRegistry.getDefaultConverterRegistry().getMap();
    	Assert.assertNotNull(map);
    	// size will change as more are added
    	Assert.assertEquals(SIZE, map.size());
    }

    @Test
    public void testList() {
    	List<Converter> converterList = CrystalConverterRegistry.getDefaultConverterRegistry().getConverterList();
    	Assert.assertNotNull(converterList);
    	Assert.assertEquals(SIZE, converterList.size());
    }

    @Test
    public void testList1() {
    	List<Converter> converterList = CrystalConverterRegistry.getDefaultConverterRegistry().getConverterList();
    	boolean found = false;
    	for (Converter converter : converterList) {
    		if (CML2CMLLiteConverter.class.equals(converter.getClass())) {
    			found = true;
    			break;
    		}
    	}
    	Assert.assertTrue("converter", found);
    }

    @Test
    @Ignore
    public void testMap1() {
    	Map<TypePair, List<Converter>> map = CrystalConverterRegistry.getDefaultConverterRegistry().getMap();
    	Assert.assertTrue(map.containsKey(PAIR_OK));
    	Assert.assertFalse(map.containsKey(PAIR_MISSING));
    	for (TypePair typePair1 : map.keySet()) {
    		System.out.println(typePair1);
    	}
    }

    @Test
    @Ignore
    public void testFindConverter() {
    	List<Converter> converters = CrystalConverterRegistry.getDefaultConverterRegistry().findConverters(
    			JDXModule.JDX_TYPE.getMimeType(), CMLCommon.CML_TYPE.getMimeType());
    	Assert.assertNotNull("jdx", converters);
    	for (Converter converter : converters) {
    		System.out.println("Converter: "+converter);
    	}
    	Assert.assertEquals("jdx", 2, converters.size());
    	Assert.assertEquals("jdx", "org.xmlcml.cml.converters.spectrum.jdx.JDX2CMLSpectConverter", converters.get(0).getClass().getName());
    }

    @Test
    public void testFindConverter1() {
    	List<Converter> converters = CrystalConverterRegistry.getDefaultConverterRegistry().findConverters(CML, CML);
    	Assert.assertNotNull("cml", converters);
//    	for (Converter converter : converters) {
//    		System.out.println(converter);
//    	}
    	Assert.assertEquals("cml", 2, converters.size());
    }

	@Test
	public void testRegistryLoadsConverterList() {
		List<Converter> list = CrystalConverterRegistry.getDefaultConverterRegistry().getConverterList();
		assertTrue(list.size()>0);
	}

	@Test
	public void testFindFoo2BarConverter() {
		List<Converter> converterList = CrystalConverterRegistry.getDefaultConverterRegistry().findConverters("foo", "bar");
		assertNull(converterList);
	}

	@Test
	public void testFindTypesFromSuffix() {
		Set<MimeType> types = CrystalConverterRegistry.getDefaultConverterRegistry().getTypes("cml");
		Assert.assertNotNull("get types", types);
		Assert.assertEquals("get types", 1, types.size());
		Assert.assertEquals("get types", "chemical/x-cml", ((MimeType)types.toArray()[0]).getMimeType());
	}

	@Test
	public void testFindTypesFromSuffix1() {
		Set<MimeType> types = CrystalConverterRegistry.getDefaultConverterRegistry().getTypes("foo");
		Assert.assertNotNull("get types", types);
		Assert.assertEquals("types count", 1, types.size());
		Assert.assertEquals("type", "chemical/x-foo", ((MimeType)types.toArray()[0]).getMimeType());
	}

	@Test
	public void testFindSingleTypeFromSuffix() {
		MimeType type = CrystalConverterRegistry.getDefaultConverterRegistry().getSingleTypeFromSuffix("cml");
		Assert.assertNotNull("get type", type);
		Assert.assertEquals("get type", "chemical/x-cml", type.getMimeType());
	}

	@Test
	public void testSingletonConverterRegistry() {
		Assert.assertNotNull(CrystalConverterRegistry.getDefaultConverterRegistry());
	}

	@Test
	public void testCreateRegistryList0() {
		ConverterRegistry converterRegistry = new ConverterRegistry(ConverterRegistry.class.getClassLoader());
		List<Converter> converterList = converterRegistry.getConverterList();
		Assert.assertNotNull(converterList);
		converterRegistry.createConvertersList();
		converterList = converterRegistry.getConverterList();
		Assert.assertNotNull(converterList);
	}

	@Test
	public void testCreateRegistryList() {
		ConverterRegistry converterRegistry = new CrystalConverterRegistry(CrystalConverterRegistry.class.getClassLoader());
		converterRegistry.populateAndRegister();
		List<Converter> converterList = converterRegistry.getConverterList();
		converterRegistry.createConvertersList();
		converterList = converterRegistry.getConverterList();
		// should at least contain org.xmlcml.cml.converters.cml.CML2CMLLiteConverter@76f2d004
		Assert.assertTrue(converterList.size()>0);
		boolean hasCmllite = false;
		for (Converter converter : converterList) {
			if (converter instanceof org.xmlcml.cml.converters.cml.CML2CMLLiteConverter) {
				hasCmllite = true;
				break;
			}
		}
		Assert.assertTrue("has cmllite", hasCmllite);
	}

	@Test
	public void testSingletonConverterRegistryList0() {
		ConverterRegistry converterRegistry = CrystalConverterRegistry.getDefaultConverterRegistry();
		List<Converter> converterList = converterRegistry.getConverterList();
		Assert.assertNotNull(converterList);
		Assert.assertEquals("converterList", SIZE, converterList.size());
	}

	@Test
	public void testSingletonConverterRegistryList() {
		List<Converter> converterList = CrystalConverterRegistry.getDefaultConverterRegistry().getConverterList();
		Assert.assertNotNull(converterList);
		Assert.assertEquals("converterList", SIZE, converterList.size());
	}

}
