package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.ValueRepresentation;
import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class PrivateInformationCreatorUID extends Attribute<String>
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0100)");
	
	public PrivateInformationCreatorUID ()
	{
		super (DEFINITION.getTag (), (ValueRepresentation.UI) DEFINITION.getVr ()[0]);
	}
}

