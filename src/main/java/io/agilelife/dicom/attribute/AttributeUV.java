package io.agilelife.dicom.attribute;

import java.math.BigInteger;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueRepresentation;

/**
 * 
 * @author Elliott Wade
 */
public class AttributeUV extends Attribute<BigInteger>
{
	private BigInteger value;
	
	public AttributeUV (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		super (attributeTag, valueRepresentation);
	}
	
	@Override
	public void setValue (BigInteger value)
	{
		this.value = value;
	}
	
	@Override
	public BigInteger getValue ()
	{
		return value;
	}
	
	@Override
	public String toString () { return String.valueOf (value); }
}
