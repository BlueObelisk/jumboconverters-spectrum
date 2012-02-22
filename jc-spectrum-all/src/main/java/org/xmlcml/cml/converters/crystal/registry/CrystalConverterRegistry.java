package org.xmlcml.cml.converters.crystal.registry;

import org.xmlcml.cml.converters.registry.ConverterRegistry;

/**
 * @author pm286
 */
public class CrystalConverterRegistry extends ConverterRegistry {

    /** create singleton registry
     */
    private static CrystalConverterRegistry CRYSTAL_CONVERTER_REGISTRY = null;
    
    public static synchronized CrystalConverterRegistry getDefaultConverterRegistry() {
    	if (CRYSTAL_CONVERTER_REGISTRY == null) {
    		CRYSTAL_CONVERTER_REGISTRY = new CrystalConverterRegistry(CrystalConverterRegistry.class.getClassLoader());
    		CRYSTAL_CONVERTER_REGISTRY.populateAndRegister();
    	}
    	return CRYSTAL_CONVERTER_REGISTRY;
    }
    
    public CrystalConverterRegistry(ClassLoader classLoader) {
    	super(classLoader);
    }

    public CrystalConverterRegistry(Class clazz) {
    	super(clazz);
    }

    
}
