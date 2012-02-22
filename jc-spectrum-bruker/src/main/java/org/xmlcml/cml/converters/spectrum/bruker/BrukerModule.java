package org.xmlcml.cml.converters.spectrum.bruker;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.MimeType.ObjectType;
import org.xmlcml.cml.converters.registry.AbstractConverterModule;

/**
 * @author pm286
 */
public class BrukerModule extends AbstractConverterModule {

	public static final MimeType BRUKER_TYPE = new MimeType("chemical/x-bruker-jdx", ObjectType.TEXT, "bruker.jdx");
	public static final String BRUKER_DIR = "bruker"; // TODO
	
    public BrukerModule() {
    	super();
    }

    public String getPrefix() {
    	return "bruker";
    }
    
	public List<Converter> getConverterList() {
		if (converterList == null) {
			converterList = new ArrayList<Converter>();
	        converterList.add(new Bruker2XMLConverter());
		}
		return converterList;
	}

	public List<MimeType> getMimeTypeList() {
		if (mimeTypeList == null) {
			mimeTypeList = new ArrayList<MimeType>();
			mimeTypeList.add(BRUKER_TYPE);
		}
		return mimeTypeList;
	}
	
}
