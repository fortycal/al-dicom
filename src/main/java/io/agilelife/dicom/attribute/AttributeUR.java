package io.agilelife.dicom.attribute;

import java.net.URI;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeUR extends Attribute<URI>
{
	private URI value;
	
	public AttributeUR (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		super (attributeTag, valueRepresentation);
	}
	
	@Override
	public void setValue (URI value)
	{
		if (value != null)
		{
			// TODO Validate
			this.value = value;
			return;
		}
		
		throw new IllegalArgumentException ("Invalid value was specified.");
	}
	
	@Override
	public URI getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
