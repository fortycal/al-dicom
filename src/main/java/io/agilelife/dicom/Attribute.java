package io.agilelife.dicom;

/**
 * One Data Element (a.k.a "attribute", "item" or (less often) multi-valued item "record") in a Data Set.
 * 
 * Note that "A Data Element is uniquely identified by a Data Element Tag. The Data Elements in a Data Set 
 * shall be ordered by increasing Data Element Tag Number and shall occur at most once in a Data Set."
 * 
 * @author Elliott Wade
 */
public class Attribute<V extends Object>
{
	public static final String VALUE_LENGTH_UNDEFINED = "FFFFFFFF"; // 0xFFFFFFFF is bigger than Integer.MAX_VALUE (0x7FFFFFFF)
	
	/** The Attribute Tag is a pair of 16-bit unsigned integers of form (Group number, Element number). 
	 * The tag uniquely identifies the element.*/
	private final AttributeTag attributeTag;
	
	/** Optional when Value Representation Encoding is "implicit" as opposed to "explicit."
	 * Normally, we should just naively be able to pass it along. */
	private ValueRepresentation<V> valueRepresentation;
	
	private V value;
	
	public Attribute (AttributeTag attributeTag, ValueRepresentation<V> valueRepresentation)
	{
		this.attributeTag = attributeTag;
		this.valueRepresentation = valueRepresentation;
	}
	
	public AttributeTag getAttributeTag () { return attributeTag; }
	public ValueRepresentation<V> getValueRepresentation () { return valueRepresentation; }
	
	public void setValue (V value)
	{
		validate (value);
		this.value = value;
	}
	
	public V getValue ()
	{
		return value;
	}
	
	/**
	 * Override to throw <code>IllegalArgumentException</code> in the case of an invalid value.
	 * The default version of this method delegates to <code>ValueRepresentation.validate(candidateValue)</code>.
	 * @param candidateValue Value to check
	 */
	public void validate (V candidateValue) { valueRepresentation.validate (candidateValue); }
	
	@Override
	public String toString () { return String.valueOf (getValue ()); }
}
