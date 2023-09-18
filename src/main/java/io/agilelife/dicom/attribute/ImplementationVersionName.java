package io.agilelife.dicom.attribute;

import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class ImplementationVersionName extends AttributeSH
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0013)");
	
	public ImplementationVersionName ()
	{
		super (DEFINITION.getTag (), DEFINITION.getVr ()[0]);
	}
}
