package io.agilelife.dicom.attribute;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeAE extends Attribute<String>
{
	private String value;
	
	public AttributeAE (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
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
		
		throw new IllegalArgumentException ("An AE value may not be blank, and may contain characters in Default Character Repertoire "
			+ "excluding character code 5CH (the BACKSLASH in ISO-IR 6), and all control characters.  Value length may not exceed 16 bytes.");
	}
	
	@Override
	public String getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
