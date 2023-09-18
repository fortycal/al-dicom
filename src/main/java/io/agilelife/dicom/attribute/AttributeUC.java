package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeUC extends Attribute<char[]>
{
	private char[] value;
	
	public AttributeUC (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		super (attributeTag, valueRepresentation);
	}
	
	@Override
	public void setValue (char[] value)
	{
		this.value = value;
	}
	
	@Override
	public char[] getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
