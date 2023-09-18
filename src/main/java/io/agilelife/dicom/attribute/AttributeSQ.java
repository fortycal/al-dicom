package io.agilelife.dicom.attribute;

import java.util.List;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeSQ extends Attribute<List<Attribute<?>>>
{
	private List<Attribute<?>> value;
	
	public AttributeSQ (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		super (attributeTag, valueRepresentation);
	}
	
	@Override
	public void setValue (List<Attribute<?>> value)
	{
		this.value = value;
	}
	
	@Override
	public List<Attribute<?>> getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
