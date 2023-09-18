package io.agilelife.dicom.attribute;

import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class PrivateInformation extends AttributeOB
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0102)");
	
	public PrivateInformation ()
	{
		super (DEFINITION.getTag (), DEFINITION.getVr ()[0]);
	}
}
