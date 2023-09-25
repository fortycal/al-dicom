package io.agilelife.dicom;

public enum Usage
{
	//
	// These refer to Macros
	//
	
	CONDITIONAL ("C", "Conditional"),
	MANDATORY ("M", "Mandatory"),
	USER_OPTIONAL ("U", "User Optional"),
	
	//
	// These refer to individual Attributes
	//
	
	ONE ("1", "Required"),
	ONE_C ("1C", "Conditionally Required"),
	TWO ("2", "Required, Empty if Unknown"),
	TWO_C ("2C", "Conditionally Required, Empty if Unknown"),
	THREE ("3", "Optional");
	
	private final String code;
	private final String desc;
	
	public boolean isMacro ()
	{
		return this.equals (CONDITIONAL)
			|| this.equals (MANDATORY)
			|| this.equals (USER_OPTIONAL); 
	}
	
	public boolean isAttribute ()
	{
		return !isMacro ();
	}
	
	private Usage (String code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}
	
	public String toString () { return desc + " (" + code + ")"; }
}
