package io.agilelife.dicom.attribute;

import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class FileMetaInformationVersion extends AttributeOB
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0001)");
	
	public FileMetaInformationVersion ()
	{
		super (DEFINITION.getTag (), DEFINITION.getVr ()[0]);
	}
}
