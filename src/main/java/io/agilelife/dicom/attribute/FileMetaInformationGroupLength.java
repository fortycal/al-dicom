package io.agilelife.dicom.attribute;

import java.math.BigInteger;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.ValueRepresentation;
import io.agilelife.dicom.dict.ElementDictionary;
import io.agilelife.dicom.dict.ElementDictionaryEntry;

public class FileMetaInformationGroupLength extends Attribute<BigInteger>
{
	public static final ElementDictionaryEntry DEFINITION = ElementDictionary.getStandard ().get ("(0002,0000)");
	
	public FileMetaInformationGroupLength ()
	{
		super (DEFINITION.getTag (), (ValueRepresentation.UL) DEFINITION.getVr ()[0]);
	}
}
