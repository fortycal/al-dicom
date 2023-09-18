package io.agilelife.dicom.attribute;

import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class SourceApplicationEntityTitle extends AttributeAE
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0016)");
	
	public SourceApplicationEntityTitle ()
	{
		super (DEFINITION.getTag (), DEFINITION.getVr ()[0]);
	}
}
