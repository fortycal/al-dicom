package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeOD extends Attribute<byte[]>
{
	private byte[] value;
	
	public AttributeOD (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		super (attributeTag, valueRepresentation);
	}
	
	@Override
	public void setValue (byte[] value)
	{
		this.value = value;
	}
	
	@Override
	public byte[] getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
