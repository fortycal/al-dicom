package io.agilelife.dicom;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

import io.agilelife.dicom.attribute.DefaultRepertoire;

/**
 * DICOM Value Representation (as of writing, according to PS3.5 2023c).
 * <p>
 * <a href="https://dicom.nema.org/medical/dicom/2023c/output/chtml/part05/sect_6.2.html">This file based on Specification 2023c</a>
 * <br>
 * <a href="https://dicom.nema.org/medical/dicom/current/output/chtml/part05/sect_6.2.html">Current Specification</a>
 * </p>
 * 
 * @author Elliott Wade
 * @version 2023c
 */
public abstract class ValueRepresentation <V extends Object>
{
	private String code;
	private String description;
	
	public ValueRepresentation (String code, String description)
	{
		this.code = code;
		this.description = description;
	}
	
	public String getCode () { return code; }
	public String getDescription () { return description; }
	
	/**
	 * Override to throw <code>IllegalArgumentException</code> in the case of an invalid value.
	 * @param candidateValue Value to check
	 */
	public abstract void validate (V candidateValue);
	
	@Override
	public String toString () { return code; }
	
	public static ValueRepresentation<?> parseRep (String s)
	{
		switch (s)
		{
			case "AE": return AE;
			case "AS": return AS;
			case "AT": return AT;
			case "CS": return CS;
			case "DA": return DA;
			case "DS": return DS;
			case "DT": return DT;
			case "FL": return FL;
			case "FD": return FD;
			case "IS": return IS;
			case "LO": return LO;
			case "LT": return LT;
			case "OB": return OB;
			case "OD": return OD;
			case "OF": return OF;
			case "OL": return OL;
			case "OV": return OV;
			case "OW": return OW;
			case "PN": return PN;
			case "SL": return SL;
			case "SQ": return SQ;
			case "SS": return SS;
			case "ST": return ST;
			case "SV": return SV;
			case "TM": return TM;
			case "UC": return UC;
			case "UI": return UI;
			case "UL": return UL;
			case "UN": return UN;
			case "UR": return UR;
			case "US": return US;
			case "UT": return UT;
			case "UV": return UV;
			default: return UN; // UN --> Unknown
		}
	}
	
	/** DICOM Value Representation: AE (Application Entity) */
	public static final AE AE = new AE ();
	public static final class AE extends ValueRepresentation<String>
	{
		public AE () { super ("AE", "Application Entity"); }
		
		@Override
		public void validate (String candidateValue)
		{
			if (candidateValue == null || candidateValue.isBlank ()) 
				throw new IllegalArgumentException (
					"AE value may not be blank."
				);
			
			int aeLen = candidateValue.length ();
			if (aeLen > 16)
				throw new IllegalArgumentException ("AE value length may not exceed 16 bytes.");
			
			for (int i=0; i<aeLen; i++)
			{
				if (DefaultRepertoire.isControlCharacter (candidateValue.charAt (i)) || 
					DefaultRepertoire.BACKSLASH_CHAR == candidateValue.charAt (i))
				{
					throw new IllegalArgumentException (
						"AE value may contain characters in Default Character Repertoire "
						+ "excluding character code 5CH (the BACKSLASH in ISO-IR 6), and all control characters."
					);
				}
			}
		}
	}
	
	/** DICOM Value Representation: AS (Age String) */
	public static final AS AS = new AS ();
	public static final class AS extends ValueRepresentation<Duration>
	{
		public AS () { super ("AS", "Age String"); }

		@Override
		public void validate (Duration candidateValue) { }
	}
	
	/** DICOM Value Representation: AT (Attribute Tag) */
	public static final AT AT = new AT ();
	public static final class AT extends ValueRepresentation<AttributeTag>
	{
		public AT () { super ("AT", "Attribute Tag"); }

		@Override
		public void validate (AttributeTag candidateValue) { }
	}
	
	/** DICOM Value Representation: CS (Code String) */
	public static final CS CS = new CS ();
	public static final class CS extends ValueRepresentation<String>
	{
		public CS () { super ("CS", "Code String"); }
		
		@Override
		public void validate (String candidateValue)
		{
			// TODO
		}
	}
	
	/** DICOM Value Representation: DA (Date) */
	public static final DA DA = new DA ();
	public static final class DA extends ValueRepresentation<LocalDate>
	{
		public DA () { super ("DA", "Date"); }

		@Override
		public void validate (LocalDate candidateValue) { }
	}
	
	/** DICOM Value Representation: DS (Decimal String) */
	public static final DS DS = new DS ();
	public static final class DS extends ValueRepresentation<BigDecimal>
	{
		public DS () { super ("DS", "Decimal String"); }

		@Override
		public void validate (BigDecimal candidateValue)
		{
			return; // TODO check valid byte-encoded length
		}
	}
	
	/** DICOM Value Representation: DT (Date Time) */
	public static final DT DT = new DT ();
	public static final class DT extends ValueRepresentation<ZonedDateTime>
	{
		public DT () { super ("DT", "Date Time"); }
		
		@Override
		public void validate (ZonedDateTime candidateValue) { }
	}
	
	/** DICOM Value Representation: FL (Floating Point Single) */
	public static final FL FL = new FL ();
	public static final class FL extends ValueRepresentation<Float>
	{
		public FL () { super ("FL", "Floating Point Single"); }

		/**
		 * Note that Java Float values are IEEE 754:1985 32-bit floating-point values.
		 */
		@Override
		public void validate (Float candidateValue) { }
	}
	
	/** DICOM Value Representation: FD (Floating Point Double) */
	public static final FD FD = new FD ();
	public static final class FD extends ValueRepresentation<Double>
	{
		public FD () { super ("FD", "Floating Point Double"); }
		
		/**
		 * Note that Java Double values are IEEE 754:1985 64-bit floating-point values.
		 */
		@Override
		public void validate (Double candidateValue) { }
	}
	
	/** DICOM Value Representation: IS (Integer String) */
	public static final IS IS = new IS ();
	public static final class IS extends ValueRepresentation<BigInteger>
	{
		public IS () { super ("IS", "Integer String"); }

		@Override
		public void validate (BigInteger candidateValue)
		{
			return; // TODO check valid byte-encoded length
		}
	}
	
	/** DICOM Value Representation: LO (Long String) */
	public static final LO LO = new LO ();
	public static final class LO extends ValueRepresentation<String>
	{
		public LO () { super ("LO", "Long String"); }

		@Override
		public void validate (String candidateValue)
		{
			// TODO
		}
	}
	
	/** DICOM Value Representation: LT (Long Text) */
	public static final LT LT = new LT ();
	public static final class LT extends ValueRepresentation<String>
	{
		public LT () { super ("LT", "Long Text"); }
		
		@Override
		public void validate (String candidateValue)
		{
			// TODO
		}
	}
	
	/** DICOM Value Representation: OB (Other Byte) */
	public static final OB OB = new OB ();
	public static final class OB extends ValueRepresentation<byte[]>
	{
		public OB () { super ("OB", "Other Byte"); }
		
		@Override
		public void validate (byte[] candidateValue) { }
	}
	
	/** DICOM Value Representation: OD (Other Double) */
	public static final OD OD = new OD ();
	public static final class OD extends ValueRepresentation<double[]>
	{
		public OD () { super ("OD", "Other Double"); }
		
		@Override
		public void validate (double[] candidateValue) { }
	}
	
	/** DICOM Value Representation: OF (Other Float) */
	public static final OF OF = new OF ();
	public static final class OF extends ValueRepresentation<float[]>
	{
		public OF () { super ("OF", "Other Float"); }
		
		@Override
		public void validate (float[] candidateValue) { }
	}
	
	/** DICOM Value Representation: OL (Other Long) */
	public static final OL OL = new OL ();
	public static final class OL extends ValueRepresentation<int[]>
	{
		public OL () { super ("OL", "Other Long"); }
		
		@Override
		public void validate (int[] candidateValue) { }
	}
	
	/** DICOM Value Representation: OV (Other 64-bit Very Long) */
	public static final OV OV = new OV ();
	public static final class OV extends ValueRepresentation<long[]>
	{
		public OV () { super ("OV", "Other 64-bit Very Long"); }
		
		@Override
		public void validate (long[] candidateValue) { }
	}
	
	/** DICOM Value Representation: OW (Other Word) */
	public static final OW OW = new OW ();
	public static final class OW extends ValueRepresentation<short[]>
	{
		public OW () { super ("OW", "Other Word"); }
		
		@Override
		public void validate (short[] candidateValue) { }
	}
	
	/** DICOM Value Representation: PN (Person Name) */
	public static final PN PN = new PN ();
	public static final class PN extends ValueRepresentation<String>
	{
		public PN () { super ("PN", "Person Name"); }
		
		@Override
		public void validate (String candidateValue)
		{
			// TODO Create PersonName class?
		}
	}
	
	/** DICOM Value Representation: SH (Short String) */
	public static final SH SH = new SH ();
	public static final class SH extends ValueRepresentation<String>
	{
		public SH () { super ("SH", "Short String"); }
		
		@Override
		public void validate (String candidateValue)
		{
			// TODO
		}
	}
	
	/** DICOM Value Representation: SL (Signed Long) */
	public static final SL SL = new SL ();
	public static final class SL extends ValueRepresentation<Integer>
	{
		public SL () { super ("SL", "Signed Long"); }
		
		@Override
		public void validate (Integer candidateValue) { }
	}
	
	/** DICOM Value Representation: SQ (Sequence of Items) */
	public static final SQ SQ = new SQ ();
	public static final class SQ extends ValueRepresentation<List<Attribute<?>>>
	{
		public SQ () { super ("SQ", "Sequence of Items"); }
		
		@Override
		public void validate (List<Attribute<?>> candidateValue) { }
	}
	
	/** DICOM Value Representation: SS (Signed Short) */
	public static final SS SS = new SS ();
	public static final class SS extends ValueRepresentation<Short>
	{
		public SS () { super ("SS", "Signed Short"); }
		
		@Override
		public void validate (Short candidateValue) { }
	}
	
	/** DICOM Value Representation: ST (Short Text) */
	public static final ST ST = new ST ();
	public static final class ST extends ValueRepresentation<String>
	{
		public ST () { super ("ST", "Short Text"); }
		
		@Override
		public void validate (String candidateValue)
		{
			// TODO
		}
	}
	
	/** DICOM Value Representation: SV (Signed 64-bit Very Long) */
	public static final SV SV = new SV ();
	public static final class SV extends ValueRepresentation<Long>
	{
		public SV () { super ("SV", "Signed 64-bit Very Long"); }
		
		@Override
		public void validate (Long candidateValue) { }
	}
	
	/** DICOM Value Representation: TM (Time) */
	public static final TM TM = new TM ();
	public static final class TM extends ValueRepresentation<LocalTime>
	{
		public TM () { super ("TM", "Time"); }
		
		@Override
		public void validate (LocalTime candidateValue) { }
	}
	
	/** DICOM Value Representation: UC (Unlimited Characters) */
	public static final UC UC = new UC ();
	public static final class UC extends ValueRepresentation<String>
	{
		public UC () { super ("UC", "Unlimited Characters"); }
		
		@Override
		public void validate (String candidateValue)
		{
			// 2^32 chars with no line breaks or other whitespace formatting!?
			// TODO
		}
	}
	
	/** DICOM Value Representation: UI (Unique Identifier (UID)) */
	public static final UI UI = new UI ();
	public static final class UI extends ValueRepresentation<String>
	{
		public UI () { super ("UI", "Unique Identifier (UID)"); }
		
		@Override
		public void validate (String candidateValue)
		{
			// TODO
		}
	}
	
	/** DICOM Value Representation: UL (Unsigned Long) */
	public static final UL UL = new UL ();
	public static final class UL extends ValueRepresentation<BigInteger>
	{
		public UL () { super ("UL", "Unsigned Long"); }
		
		@Override
		public void validate (BigInteger candidateValue) { }
	}
	
	/** DICOM Value Representation: UN (Unknown) */
	public static final UN UN = new UN ();
	public static final class UN extends ValueRepresentation<byte[]>
	{
		public UN () { super ("UN", "Unknown"); }
		
		@Override
		public void validate (byte[] candidateValue) { }
	}
	
	/** DICOM Value Representation: UR (Universal Resource Identifier or Universal Resource Locator (URI/URL)) */
	public static final UR UR = new UR ();
	public static final class UR extends ValueRepresentation<URI>
	{
		public UR () { super ("UR", "Universal Resource Identifier or Universal Resource Locator (URI/URL)"); }
		
		@Override
		public void validate (URI candidateValue) { }
	}
	
	/** DICOM Value Representation: US (Unsigned Short) */
	public static final US US = new US ();
	public static final class US extends ValueRepresentation<Integer>
	{
		public US () { super ("US", "Unsigned Short"); }
		
		@Override
		public void validate (Integer candidateValue)
		{
			// TODO validate 0 <= n < 2^16
		}
	}
	
	/** DICOM Value Representation: UT (Unlimited Text) */
	public static final UT UT = new UT ();
	public static final class UT extends ValueRepresentation<String>
	{
		public UT () { super ("UT", "Unlimited Text"); }
		
		@Override
		public void validate (String candidateValue)
		{
			// TODO
		}
	}
	
	/** DICOM Value Representation: UV (Unsigned 64-bit Very Long) */
	public static final UV UV = new UV ();
	public static final class UV extends ValueRepresentation<BigInteger>
	{
		public UV () { super ("UV", "Unsigned 64-bit Very Long"); }
		
		@Override
		public void validate (BigInteger candidateValue)
		{
			// TODO validate 0 <= n < 2^64
		}
	}
}
