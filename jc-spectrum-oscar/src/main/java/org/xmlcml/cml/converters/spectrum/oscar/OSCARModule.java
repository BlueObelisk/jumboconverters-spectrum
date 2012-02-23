package org.xmlcml.cml.converters.spectrum.oscar;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.cml.converters.AbstractConverterModule;
import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.MimeType.ObjectType;

/**
 * @author pm286
 */
public class OSCARModule extends AbstractConverterModule {

	public static final MimeType OSCAR_XML_TYPE = new MimeType("chemical/x-oscar", ObjectType.XML, "oscar.xml");
	public static final String OSCAR_DIR = "jdx"; // TODO
	public static final String OSCAR_CML2OSCAR_DIR = null; // TODO
	public static final String OSCAR_OSCAR2CML_DIR = null; // TODO
	
    public OSCARModule() {
    	super();
    }

    public String getPrefix() {
    	return "jdx";
    }
    
	public List<Converter> getConverterList() {
		if (converterList == null) {
			converterList = new ArrayList<Converter>();
	        converterList.add(new OSCAR2CMLSpectConverter());
		}
		return converterList;
	}

	public List<MimeType> getMimeTypeList() {
		if (mimeTypeList == null) {
			mimeTypeList = new ArrayList<MimeType>();
			mimeTypeList.add(OSCAR_XML_TYPE);
		}
		return mimeTypeList;
	}
	
}
