package io.agilelife.dicom.attribute;

import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class TransferSyntaxUID extends AttributeUI
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0010)");
	
	public TransferSyntaxUID ()
	{
		super (DEFINITION.getTag (), DEFINITION.getVr ()[0]);
	}
}
