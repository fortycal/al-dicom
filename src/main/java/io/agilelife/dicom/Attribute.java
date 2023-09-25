package io.agilelife.dicom;

/**
 * One Data Element (a.k.a "attribute", "item") in a Data Set.
 * 
 * Note that "A Data Element is uniquely identified by a Data Element Tag. The Data Elements in a Data Set 
 * shall be ordered by increasing Data Element Tag Number and shall occur at most once in a Data Set."
 * 
 * @param <V> Normalized Java type of a single value, of which this Attribute may hold multiple.  Multiple
 * values admit of semantic interpretation according to the VR of this attribute and the IOD to which this 
 * Attribute contributes.
 * 
 * @author Elliott Wade
 */
public class Attribute<V extends Object> implements IUsable
{
	public static final String VALUE_LENGTH_UNDEFINED = "FFFFFFFF"; // 0xFFFFFFFF is bigger than Integer.MAX_VALUE (0x7FFFFFFF)
	
	private final ElementDictionaryEntry definition;
	
	private int selectedVr = 0;
	private V[] value;
	public final Usage usage;
	
	public Attribute (ElementDictionaryEntry definition, Usage usage)
	{
		this.definition = definition;
		this.selectedVr = 0;
		this.usage = usage;
	}
	
	public AttributeTag getAttributeTag () { return definition.getTag (); }
	
	@SuppressWarnings("unchecked")
	public ValueRepresentation<V> getVr () { return (ValueRepresentation<V>) definition.getVr ()[selectedVr]; }
	
	public ValueMultiplicity getVm () { return definition.getVm (); }
	
	@Override
	public Usage getUsage () { return usage; }
	
	@SuppressWarnings("unchecked")
	public void set (V... value)
	{
		validate (value);
		this.value = value;
	}
	
	public V get ()
	{
		return value[0];
	}
	
	/**
	 * Override to throw <code>IllegalArgumentException</code> in the case of an invalid value.
	 * The default version of this method delegates to <code>ValueRepresentation.validate(candidateValue)</code>.
	 * 
	 * @param candidateValue Value to check
	 */
	@SuppressWarnings("unchecked")
	public void validate (V[] candidateValue)
	{
		((ValueRepresentation<V>) definition.getVr ()[selectedVr]).validate (candidateValue);
	}
	
	@Override
	public String toString () { return String.valueOf (get ()); }
}
