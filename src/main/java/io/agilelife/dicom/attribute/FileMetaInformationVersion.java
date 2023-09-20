package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.ValueRepresentation;
import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class FileMetaInformationVersion extends Attribute<byte[]>
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0001)");
	
	public FileMetaInformationVersion ()
	{
		super (DEFINITION.getTag (), (ValueRepresentation.OB) DEFINITION.getVr ()[0]);
	}
}
