package io.agilelife.dicom.attribute;

import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class DataSetTrailingPadding extends AttributeOB
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(FFFC,FFFC)");
	
	public DataSetTrailingPadding ()
	{
		super (DEFINITION.getTag (), DEFINITION.getVr ()[0]);
	}
}
