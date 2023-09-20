package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.ValueRepresentation;
import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class PrivateInformation extends Attribute<byte[]>
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0102)");
	
	public PrivateInformation ()
	{
		super (DEFINITION.getTag (), (ValueRepresentation.OB) DEFINITION.getVr ()[0]);
	}
}
