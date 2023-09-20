package io.agilelife.dicom;

/**
 * A.k.a Data Element Tag
 * 
 * @author Elliott Wade
 */
public class AttributeTag implements Comparable<AttributeTag>
{
	public static final Integer MIN_COMPONENT_VALUE = 0;
	public static final Integer MAX_COMPONENT_VALUE = Integer.parseInt ("FFFF", 16);
	
	private Integer groupNumber;
	private Integer elementNumber;
	
	public AttributeTag (String groupNumber, String elementNumber)
	{
		setGroupNumber (groupNumber);
		setElementNumber (elementNumber);
	}
	
	private void setGroupNumber (String s) { this.groupNumber = convert (s); }
	private void setElementNumber (String s) { this.elementNumber = convert (s); }
	
	public String getGroupNumberString () { return Integer.toHexString (groupNumber); }
	public String getElementNumberString () { return Integer.toHexString (elementNumber); }
	
	private int convert (String s) throws NumberFormatException, IllegalArgumentException
	{
		int ret = Integer.parseInt (s.trim ().toLowerCase ().replace(" ", "").replace ("x", "0"), 16);
		if (ret >= MIN_COMPONENT_VALUE && ret <= MAX_COMPONENT_VALUE) return ret;
		else 
			throw new IllegalArgumentException (
				"Group or Element Number must be given in hexadecimal and be in the range 0000-FFFF "
				+ "(i.e. expressible as a two-byte unsigned integer)."
			);
	}
	
	public static AttributeTag parseTag (String tagString)
	{
		try
		{
			String[] sa;
			tagString = tagString.trim ().toLowerCase ().replace (" ", "").replace ("x", "0");
			if (tagString.startsWith ("(") || tagString.endsWith (")"))
			{
				tagString = tagString
					.replace ("(", "")
					.replace (")", "");
				sa = tagString.split (",");
			}
			else
			{
				sa = new String[] {tagString.substring (0, 4), tagString.substring (4)};
			}
			
			return new AttributeTag (sa[0], sa[1]);
		}
		catch (Exception e)
		{
			throw new IllegalArgumentException ("Attribute tag not in canonical format: " + String.valueOf (tagString), e);
		}
	}
	
	@Override
	public String toString ()
	{
		return ("(" + String.format ("%1$04X", groupNumber) + "," + String.format ("%1$04X", elementNumber) + ")").toUpperCase ();
	}
	
	@Override
	public boolean equals (Object otherTag)
	{
		return
			otherTag instanceof AttributeTag 
			&& ((AttributeTag) otherTag).groupNumber.equals (this.groupNumber)
			&& ((AttributeTag) otherTag).elementNumber.equals (this.elementNumber);
	}
	
	@Override
	public int hashCode ()
	{
		int hash = 23;
		hash = hash * 31 + Integer.valueOf (groupNumber).hashCode ();
		hash = hash * 37 + Integer.valueOf (elementNumber).hashCode ();
		return hash;
	}

	@Override
	public int compareTo (AttributeTag o)
	{
		int g = this.groupNumber.compareTo (o.groupNumber);
		if (g != 0) return g;
		else return this.elementNumber.compareTo (o.elementNumber);
	}
}
