package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.ElementDictionary;
import io.agilelife.dicom.ElementDictionaryEntry;
import io.agilelife.dicom.Usage;

public class DataSetTrailingPadding extends Attribute<byte[]>
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(FFFC,FFFC)");
	
	public DataSetTrailingPadding (Usage usage)
	{
		super (DEFINITION, usage);
	}
}
