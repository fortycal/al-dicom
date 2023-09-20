package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.ValueRepresentation;
import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class ImplementationVersionName extends Attribute<String>
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0013)");
	
	public ImplementationVersionName ()
	{
		super (DEFINITION.getTag (), (ValueRepresentation.SH) DEFINITION.getVr ()[0]);
	}
}
