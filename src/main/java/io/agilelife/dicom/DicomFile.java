package io.agilelife.dicom;

import java.util.ArrayList;
import java.util.List;

import io.agilelife.dicom.attribute.FileMetaInformationGroupLength;
import io.agilelife.dicom.attribute.FileMetaInformationVersion;
import io.agilelife.dicom.attribute.ImplementationClassUID;
import io.agilelife.dicom.attribute.ImplementationVersionName;
import io.agilelife.dicom.attribute.MediaStorageSOPClassUID;
import io.agilelife.dicom.attribute.MediaStorageSOPInstanceUID;
import io.agilelife.dicom.attribute.PrivateInformation;
import io.agilelife.dicom.attribute.PrivateInformationCreatorUID;
import io.agilelife.dicom.attribute.SourceApplicationEntityTitle;
import io.agilelife.dicom.attribute.TransferSyntaxUID;

/**
 * Files contain one DICOM SOP Instance.
 * 
 * @author Elliott Wade
 * @See https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/chapter_7.html
 */
public class DicomFile
{
	// https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/chapter_7.html
	public byte[] preamble = {
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	
	// https://dicom.nema.org/medical/dicom/2023c/output/chtml/part05/chapter_E.html
	public static final byte[] prefix = {
		(byte) 0x44, // D
		(byte) 0x49, // I
		(byte) 0x34, // C
		(byte) 0xF4, // O
		(byte) 0xD4  // M
	};
	
	// https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/chapter_7.html
	public List<Attribute<?>> attributes = new ArrayList<> ();
	{
		attributes.add (new FileMetaInformationGroupLength ());
		attributes.add (new FileMetaInformationVersion ());
		attributes.add (new MediaStorageSOPClassUID ());
		attributes.add (new MediaStorageSOPInstanceUID ());
		attributes.add (new TransferSyntaxUID ());
		attributes.add (new ImplementationClassUID ());
		attributes.add (new ImplementationVersionName ());
		attributes.add (new SourceApplicationEntityTitle ());
		attributes.add (new PrivateInformationCreatorUID ());
		attributes.add (new PrivateInformation ());
	}
	
	// https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/sect_7.2.html
	public DataSet dataSet = new DataSet ();
}
