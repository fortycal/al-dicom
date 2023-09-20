package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.ValueRepresentation;
import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class ImplementationClassUID extends Attribute<String>
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0012)");
	
	public ImplementationClassUID ()
	{
		super (DEFINITION.getTag (), (ValueRepresentation.UI) DEFINITION.getVr ()[0]);
	}
}
