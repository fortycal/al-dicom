package io.agilelife.dicom.attribute;

import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class FileMetaInformationGroupLength extends AttributeUL
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0000)");
	
	public FileMetaInformationGroupLength ()
	{
		super (DEFINITION.getTag (), DEFINITION.getVr ()[0]);
	}
}
