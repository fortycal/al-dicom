package io.agilelife.dicom;

/**
 * One Data Element (a.k.a "attribute", "record" or "item") in a Data Set.
 * 
 * Note that "A Data Element is uniquely identified by a Data Element Tag. The Data Elements in a Data Set 
 * shall be ordered by increasing Data Element Tag Number and shall occur at most once in a Data Set."
 * 
 * @author Elliott Wade
 */
public abstract class Attribute<V extends Object>
{
	public static final String VALUE_LENGTH_UNDEFINED = "FFFFFFFF"; // 0xFFFFFFFF is bigger than Integer.MAX_VALUE (0x7FFFFFFF)
	
	/** The Attribute Tag is a pair of 16-bit unsigned integers of form (Group number, Element number). 
	 * The tag uniquely identifies the element.*/
	AttributeTag attributeTag;
	
	/** Optional when Value Representation Encoding is "implicit" as opposed to "explicit."
	 * Normally, we should just naively be able to pass it along. */
	ValueRepresentation valueRepresentation; 
	
	/** <p>Value length gives the length of the data contained in the Value Field tag, or is a flag 
	 * specifying the Value Field is of undefined length, and thus must be terminated later in the 
	 * data stream with a special Item or Sequence Delimitation tag.</p>
	 * <p>According to section 7.1.1 of PS 3.5, Value Length is either:
	 * <ul>
	 * <li> a 16 or 32-bit (dependent on VR and whether VR is explicit or implicit) unsigned integer 
	 * containing the Explicit Length of the Value Field as the number of bytes (even) that make up 
	 * the Value. It does not include the length of the Data Element Tag, Value Representation, and 
	 * Value Length Fields.</li>
	 * <li>a 32-bit Length Field set to Undefined Length (FFFFFFFFH). Undefined Lengths may be used 
	 * for Data Elements having the Value Representation (VR) Sequence of Items (SQ) and Unknown (UN). 
	 * For Data Elements with Value Representation OW or OB Undefined Length may be used depending on 
	 * the negotiated Transfer Syntax (see Section 10 and Annex A).</li>
	 * </ul>*/
	Integer valueLength = 0;
	
	/** An even number of bytes storing the value(s) of the data element. The exact format of this 
	 * data depends on the Value Representation and the Value Multiplicity. */
	byte[] value = new byte[0];
	
	public Attribute (AttributeTag attributeTag, ValueRepresentation valueRepresentation)
	{
		this.attributeTag = attributeTag;
		this.valueRepresentation = valueRepresentation;
	}
	
	public abstract void setValue (V value);
	
	public abstract V getValue ();
}
