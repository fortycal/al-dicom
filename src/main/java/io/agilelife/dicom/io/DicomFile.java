package io.agilelife.dicom.io;

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
		(byte) 0xD4  // M
	};
	
	
	
	// https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/sect_7.2.html
	public DataSet dataSet = new DataSet ();
}
