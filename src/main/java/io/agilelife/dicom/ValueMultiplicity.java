package io.agilelife.dicom;

public abstract class ValueMultiplicity
{
	public final int minimum;
	public final int maximum;
	
	/**
	 * Cannot be directly instantiated.  Use one of the static factory methods of this class instead.
	 * @param minimum
	 * @param maximum
	 */
	private ValueMultiplicity (int minimum, int maximum)
	{
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	@Override
	public int hashCode ()
	{
		int hash = 23;
		hash = hash * 31 + Integer.valueOf (minimum).hashCode ();
		hash = hash * 37 + Integer.valueOf (maximum).hashCode ();
		return hash;
	}
	
	public abstract boolean allows (int i);
	
	public static ValueMultiplicity exactly (int i) { return new Exactly (i); }
	public static ValueMultiplicity rangeInclusive (int min, int max) { return new RangeInclusive (min, max); }
	public static ValueMultiplicity nOrMore (int min) { return new RangeInclusive (min, Integer.MAX_VALUE); }
	public static ValueMultiplicity multipleOf (int i) { return new MultipleOf (i); }
	
	public static ValueMultiplicity parse (String s)
	{
		String t = s.trim ().replace (" ", "");
		try {
			int i = Integer.parseInt (t);
			return exactly (i); // e.g. "1"
		} catch (Exception e) {}
		
		try {
			String[] sa = t.split ("-");
			int min = Integer.parseInt (sa[0]);
			
			try {
				int max = Integer.parseInt (sa[1]);
				if (min == max) return exactly (min); // e.g. "2-2"
				else 
				if (min < max) return rangeInclusive (min, max); // e.g. "1-2"
			} catch (Exception e) {}
			
			if (sa[1].equalsIgnoreCase ("n")) return nOrMore (min); // e.g. "1-n"
			
			if (sa[1].endsWith("n") || sa[1].endsWith ("N"))
			{
				int max = Integer.parseInt (sa[1].substring (0, sa[1].length () - 1));
				if (min == max) return multipleOf (min); // e.g. "2-2n"
			}
		} catch (Exception e) {}
		
		throw new IllegalArgumentException ("Unable to parse ValueMultiplicity for input: " + String.valueOf (t));
	}
	
	private static class Exactly extends ValueMultiplicity
	{
		public Exactly (int i) { super (i, i); }
		
		@Override public boolean allows (int i) {
			return i == minimum;
		}
		
		@Override public String toString () {
			return String.valueOf (minimum);
		}
		
		@Override
		public boolean equals (Object other)
		{
			return
				other instanceof Exactly 
				&& ((ValueMultiplicity) other).minimum == this.minimum
				&& ((ValueMultiplicity) other).maximum == this.maximum;
		}
	}
	
	private static class RangeInclusive extends ValueMultiplicity
	{
		public RangeInclusive (int min, int max) { super (min, max); }
		
		public boolean allows (int i) {
			return i >= minimum && i <= maximum;
		}
		
		@Override
		public String toString ()
		{
			return
				String.valueOf (minimum) 
				+ (maximum == minimum ? 
					"" :
					("-" + (Integer.valueOf (Integer.MAX_VALUE).equals (maximum) ? "n" : String.valueOf (maximum)))
				);
		}
		
		@Override
		public boolean equals (Object other)
		{
			return
				other instanceof RangeInclusive 
				&& ((ValueMultiplicity) other).minimum == this.minimum
				&& ((ValueMultiplicity) other).maximum == this.maximum;
		}
	}
	
	private static class MultipleOf extends ValueMultiplicity
	{
		public MultipleOf (int i) { super (i, 0); }
		
		@Override public boolean allows (int i) {
			return i >= minimum && i % minimum == 0;
		}
		
		@Override public String toString () {
			return String.valueOf (minimum + "-" + minimum + "n");
		}
		
		@Override
		public boolean equals (Object other)
		{
			return
				other instanceof MultipleOf 
				&& ((ValueMultiplicity) other).minimum == this.minimum
				&& ((ValueMultiplicity) other).maximum == this.maximum;
		}
	}
}
