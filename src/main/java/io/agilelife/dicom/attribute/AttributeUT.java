package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeUT extends Attribute<String>
{
	private String value;
	
	public AttributeUT (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		super (attributeTag, valueRepresentation);
	}
	
	@Override
	public void setValue (String value)
	{
		if (value != null && !value.isBlank ())
		{
			// TODO Validate
			this.value = value;
			return;
		}
		
		throw new IllegalArgumentException ("Invalid value was specified.");
	}
	
	@Override
	public String getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
