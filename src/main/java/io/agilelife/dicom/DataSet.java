package io.agilelife.dicom;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import io.agilelife.dicom.attribute.DataSetTrailingPadding;
import io.agilelife.dicom.attribute.TransferSyntaxUID;

/**
 * Comprises a collection of DataElement items.  Note that "A Data Element is uniquely identified by a 
 * Data Element Tag. The Data Elements in a Data Set shall be ordered by increasing Data Element Tag Number 
 * and shall occur at most once in a Data Set."
 *
 * @author Elliott Wade
 */
public class DataSet
{
	private final Map<AttributeTag, Attribute<?>> attributes = Collections.synchronizedSortedMap (new TreeMap<> ());
	
	public void add (Attribute<?> a)
	{
		// https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/sect_7.2.html
		if (a.attributeTag.equals (TransferSyntaxUID.DEFINITION.getTag ()))
			throw new IllegalArgumentException ("A DataSet may not define or change its own Transfer​ Syntax.");
		
		attributes.put (a.attributeTag, a);
	}
	
	public void pad (int byteCount, char padWith)
	{
		DataSetTrailingPadding padding = new DataSetTrailingPadding ();
		byte[] bytes = new byte[byteCount];
		for (int i=0; i<bytes.length; i++) bytes[i] = (byte) padWith;
		padding.setValue (bytes);
		add (padding);
	}
}
