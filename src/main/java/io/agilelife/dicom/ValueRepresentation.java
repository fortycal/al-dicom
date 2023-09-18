package io.agilelife.dicom;

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
public class ValueRepresentation
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
	
	@Override
	public String toString () { return code; }
	
	public static ValueRepresentation parseRep (String s)
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
	public static final class AE extends ValueRepresentation { public AE () { super ("AE", "Application Entity"); } }
	
	/** DICOM Value Representation: AS (Age String) */
	public static final AS AS = new AS ();
	public static final class AS extends ValueRepresentation { public AS () { super ("AS", "Age String"); } }
	
	/** DICOM Value Representation: AT (Attribute Tag) */
	public static final AT AT = new AT ();
	public static final class AT extends ValueRepresentation { public AT () { super ("AT", "Attribute Tag"); } }
	
	/** DICOM Value Representation: CS (Code String) */
	public static final CS CS = new CS ();
	public static final class CS extends ValueRepresentation { public CS () { super ("CS", "Code String"); } }
	
	/** DICOM Value Representation: DA (Date) */
	public static final DA DA = new DA ();
	public static final class DA extends ValueRepresentation { public DA () { super ("DA", "Date"); } }
	
	/** DICOM Value Representation: DS (Decimal String) */
	public static final DS DS = new DS ();
	public static final class DS extends ValueRepresentation { public DS () { super ("DS", "Decimal String"); } }
	
	/** DICOM Value Representation: DT (Date Time) */
	public static final DT DT = new DT ();
	public static final class DT extends ValueRepresentation { public DT () { super ("DT", "Date Time"); } }
	
	/** DICOM Value Representation: FL (Floating Point Single) */
	public static final FL FL = new FL ();
	public static final class FL extends ValueRepresentation { public FL () { super ("FL", "Floating Point Single"); } }
	
	/** DICOM Value Representation: FD (Floating Point Double) */
	public static final FD FD = new FD ();
	public static final class FD extends ValueRepresentation { public FD () { super ("FD", "Floating Point Double"); } }
	
	/** DICOM Value Representation: IS (Integer String) */
	public static final IS IS = new IS ();
	public static final class IS extends ValueRepresentation { public IS () { super ("DT", "Integer String"); } }
	
	/** DICOM Value Representation: LO (Long Text) */
	public static final LO LO = new LO ();
	public static final class LO extends ValueRepresentation { public LO () { super ("LO", "Long String"); } }
	
	/** DICOM Value Representation: LT (Long Text) */
	public static final LT LT = new LT ();
	public static final class LT extends ValueRepresentation { public LT () { super ("LT", "Long Text"); } }
	
	/** DICOM Value Representation: OB (Other Byte) */
	public static final OB OB = new OB ();
	public static final class OB extends ValueRepresentation { public OB () { super ("OB", "Other Byte"); } }
	
	/** DICOM Value Representation: OD (Other Double) */
	public static final OD OD = new OD ();
	public static final class OD extends ValueRepresentation { public OD () { super ("OD", "Other Double"); } }
	
	/** DICOM Value Representation: OF (Other Float) */
	public static final OF OF = new OF ();
	public static final class OF extends ValueRepresentation { public OF () { super ("OF", "Other Float"); } }
	
	/** DICOM Value Representation: OL (Other Long) */
	public static final OL OL = new OL ();
	public static final class OL extends ValueRepresentation { public OL () { super ("OL", "Other Long"); } }
	
	/** DICOM Value Representation: OV (Other 64-bit Very Long) */
	public static final OV OV = new OV ();
	public static final class OV extends ValueRepresentation { public OV () { super ("OV", "Other 64-bit Very Long"); } }
	
	/** DICOM Value Representation: OW (Other Word) */
	public static final OW OW = new OW ();
	public static final class OW extends ValueRepresentation { public OW () { super ("OW", "Other Word"); } }
	
	/** DICOM Value Representation: PN (Person Name) */
	public static final PN PN = new PN ();
	public static final class PN extends ValueRepresentation { public PN () { super ("PN", "Person Name"); } }
	
	/** DICOM Value Representation: SH (Short String) */
	public static final SH SH = new SH ();
	public static final class SH extends ValueRepresentation { public SH () { super ("SH", "Short String"); } }
	
	/** DICOM Value Representation: SL (Signed Long) */
	public static final SL SL = new SL ();
	public static final class SL extends ValueRepresentation { public SL () { super ("SL", "Signed Long"); } }
	
	/** DICOM Value Representation: SQ (Sequence of Items) */
	public static final SQ SQ = new SQ ();
	public static final class SQ extends ValueRepresentation { public SQ () { super ("SQ", "Sequence of Items"); } }
	
	/** DICOM Value Representation: SS (Signed Short) */
	public static final SS SS = new SS ();
	public static final class SS extends ValueRepresentation { public SS () { super ("SS", "Signed Short"); } }
	
	/** DICOM Value Representation: ST (Short Text) */
	public static final ST ST = new ST ();
	public static final class ST extends ValueRepresentation { public ST () { super ("ST", "Short Text"); } }
	
	/** DICOM Value Representation: SV (Signed 64-bit Very Long) */
	public static final SV SV = new SV ();
	public static final class SV extends ValueRepresentation { public SV () { super ("SV", "Signed 64-bit Very Long"); } }
	
	/** DICOM Value Representation: TM (Time) */
	public static final TM TM = new TM ();
	public static final class TM extends ValueRepresentation { public TM () { super ("TM", "Time"); } }
	
	/** DICOM Value Representation: UC (Unlimited Characters) */
	public static final UC UC = new UC ();
	public static final class UC extends ValueRepresentation { public UC () { super ("UC", "Unlimited Characters"); } }
	
	/** DICOM Value Representation: UI (Unique Identifier (UID)) */
	public static final UI UI = new UI ();
	public static final class UI extends ValueRepresentation { public UI () { super ("UI", "Unique Identifier (UID)"); } }
	
	/** DICOM Value Representation: UL (Unsigned Long) */
	public static final UL UL = new UL ();
	private static final class UL extends ValueRepresentation { public UL () { super ("UL", "Unsigned Long"); } }
	
	/** DICOM Value Representation: UN (Unknown) */
	public static final UN UN = new UN ();
	public static final class UN extends ValueRepresentation { public UN () { super ("UN", "Unknown"); } }
	
	/** DICOM Value Representation: UR (Universal Resource Identifier or Universal Resource Locator (URI/URL)) */
	public static final UR UR = new UR ();
	public static final class UR extends ValueRepresentation { public UR () { super ("UR", "Universal Resource Identifier or Universal Resource Locator (URI/URL)"); } }
	
	/** DICOM Value Representation: US (Unsigned Short) */
	public static final US US = new US ();
	public static final class US extends ValueRepresentation { public US () { super ("US", "Unsigned Short"); } }
	
	/** DICOM Value Representation: UT (Unlimited Text) */
	public static final UT UT = new UT ();
	public static final class UT extends ValueRepresentation { public UT () { super ("UT", "Unlimited Text"); } }
	
	/** DICOM Value Representation: UV (Unsigned 64-bit Very Long) */
	public static final UV UV = new UV ();
	public static final class UV extends ValueRepresentation { public UV () { super ("UV", "Unsigned 64-bit Very Long"); } }
}
