package io.agilelife.dicom.io;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.macro.FileMeta;

/**
 * Comprises a collection of DataElement items.  Note that "A Data Element is uniquely identified by a 
 * Data Element Tag. The Data Elements in a Data Set shall be ordered by increasing Data Element Tag Number 
 * and shall occur at most once in a Data Set."
 *
 * @author Elliott Wade
 */
public class DataSet
{
	private static final AttributeTag TRANSFER_SYNTAX_UID_TAG = new FileMeta ().transferSyntaxUID.getAttributeTag ();
	private final Map<AttributeTag, Attribute<?>> attributes = Collections.synchronizedSortedMap (new TreeMap<> ());
	
	public void add (Attribute<?> a)
	{
		// https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/sect_7.2.html
		if (a.getAttributeTag ().equals (TRANSFER_SYNTAX_UID_TAG))
			throw new IllegalArgumentException ("A DataSet may not define or change its own Transfer​ Syntax.");
		
		attributes.put (a.getAttributeTag (), a);
	}
	
	
	// TODO where and when to add padding?
//	public void pad (int byteCount, char padWith)
//	{
//		DataSetTrailingPadding padding = new DataSetTrailingPadding ();
//		byte[] bytes = new byte[byteCount];
//		for (int i=0; i<bytes.length; i++) bytes[i] = (byte) padWith;
//		padding.set (new byte[][] {bytes});
//		add (padding);
//	}
}
