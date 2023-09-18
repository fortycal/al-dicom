package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeFL extends Attribute<Float>
{
	private Float value;
	
	public AttributeFL (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		super (attributeTag, valueRepresentation);
	}
	
	@Override
	public void setValue (Float value)
	{
		this.value = value;
	}
	
	@Override
	public Float getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
