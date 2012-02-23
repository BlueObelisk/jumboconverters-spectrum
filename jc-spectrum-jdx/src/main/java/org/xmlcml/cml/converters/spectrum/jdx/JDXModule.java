package org.xmlcml.cml.converters.spectrum.jdx;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.cml.converters.AbstractConverterModule;
import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.MimeType.ObjectType;
import org.xmlcml.cml.converters.spectrum.jdx.cml2jdx.CMLSpect2JDXConverter;
import org.xmlcml.cml.converters.spectrum.jdx.jdx2cml.JDX2CMLConverter;

/**
 * @author pm286
 */
public class JDXModule extends AbstractConverterModule {

	public static final MimeType JDX_TYPE = new MimeType("chemical/x-jcamp-dx", ObjectType.TEXT, "jdx");
	public static final String JDX_DIR = "jdx"; // TODO
	public static final String JDX_CML2JDX_DIR = "org/xmlcml/cml/converters/spectrum/jdx/cml2jdx"; // TODO
	public static final String JDX_JDX2CML_DIR = "org/xmlcml/cml/converters/spectrum/jdx/jdx2cml"; // TODO
	
    public JDXModule() {
    	super();
    }

    public String getPrefix() {
    	return "jdx";
    }
    
	public List<Converter> getConverterList() {
		if (converterList == null) {
			converterList = new ArrayList<Converter>();
	        converterList.add(new CMLSpect2JDXConverter());
	        converterList.add(new JDX2CMLConverter());
		}
		return converterList;
	}

	public List<MimeType> getMimeTypeList() {
		if (mimeTypeList == null) {
			mimeTypeList = new ArrayList<MimeType>();
			mimeTypeList.add(JDX_TYPE);
		}
		return mimeTypeList;
	}
	
}
