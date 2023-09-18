package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeAT extends Attribute<AttributeTag>
{
	private AttributeTag value;
	
	public AttributeAT (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		super (attributeTag, valueRepresentation);
	}
	
	@Override
	public void setValue (AttributeTag value)
	{
		if (value == null)
			throw new IllegalArgumentException ("Value must be a non-null Attribute Tag.");
		
		this.value = value;
	}
	
	@Override
	public AttributeTag getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
