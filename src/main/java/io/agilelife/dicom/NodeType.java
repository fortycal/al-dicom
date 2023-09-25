package io.agilelife.dicom;

public enum NodeType
{
	/**
	 * TODO: Don't think we need this one.
	 */
	ATTRIBUTE ("ATTRIBUTE"),    // A plain single- or multi-valued Attribute
	
	/**
	 * A list of Attributes informally grouped for re-use. Just means "insert this list of Attributes
	 * in the current DataSet (level in this tree)".
	 */
	MACRO ("MACRO"),
	
	/**
	 * Each node under a Sequence is transported as a DataSet.  Sequences comprise Attributes and Macros
	 * needed for SOP conformance.
	 */
	SEQUENCE ("SEQUENCE"),
	
	/**
	 * A special Macro that prefaces the data in a DICOM file or transmission.  Treated as a DataSet without
	 * an encapsulating SQ Attribute.
	 */
	FILE_META ("FILE_META"),
	
	/**
	 * A Composite (that is, "real-world" as opposed to Normal) Information Object Definition (IOD).  May be treated the same as a 
	 * Macro for transmission, or may be treated as a DataSet when it hosts a more-or-less official "top-level" SOP UID such as that for 
	 * "VL Whole Slide Microscopy Image".
	 */
	CIOD ("CIOD");
	
	private final String typeName;       
	
	private NodeType (String typeName) { this.typeName = typeName; }
	
	public String toString () { return this.typeName; }
}
