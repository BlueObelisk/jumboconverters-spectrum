package org.xmlcml.cml.converters.spectrum.agilent;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.MimeType.ObjectType;
import org.xmlcml.cml.converters.registry.AbstractConverterModule;

/**
 * @author pm286
 */
public class AgilentModule extends AbstractConverterModule {

	public static final MimeType AGILENT_TYPE = new MimeType("chemical/x-agilent-msgc", ObjectType.TEXT, "agi");
	public static final String AGILENT_DIR = "agilent"; // TODO
	
    public AgilentModule() {
    	super();
    }

    public String getPrefix() {
    	return "agilent";
    }
    
	public List<Converter> getConverterList() {
		if (converterList == null) {
			converterList = new ArrayList<Converter>();
	        converterList.add(new AgilentLCMS2CMLConverter());
		}
		return converterList;
	}

	public List<MimeType> getMimeTypeList() {
		if (mimeTypeList == null) {
			mimeTypeList = new ArrayList<MimeType>();
			mimeTypeList.add(AGILENT_TYPE);
		}
		return mimeTypeList;
	}
	
}
