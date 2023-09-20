package io.agilelife.dicom.dict;

import java.util.Arrays;

import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueMultiplicity;
import io.agilelife.dicom.ValueRepresentation;

public class ElementDictionaryEntry
{
	private AttributeTag tag;
	private String name;
	private String keyword;
	private ValueRepresentation<?>[] vr;
	private ValueMultiplicity vm;
	private String retirement;
	
	public ElementDictionaryEntry (AttributeTag tag, String name, String keyword, ValueRepresentation<?> vr, ValueMultiplicity vm, String retirement)
	{
		this (tag, name, keyword, new ValueRepresentation[] {vr}, vm, retirement);
	}
	
	public ElementDictionaryEntry (AttributeTag tag, String name, String keyword, ValueRepresentation<?>[] vr, ValueMultiplicity vm, String retirement)
	{
		this.tag = tag;
		this.name = name;
		this.keyword = keyword;
		this.vr = vr;
		this.vm = vm;
		this.retirement = retirement;
	}

	public AttributeTag getTag () { return tag; }
	public void setTag (AttributeTag tag) { this.tag = tag; }

	public String getName () { return name; }
	public void setName (String name) { this.name = name; }

	public String getKeyword () { return keyword; }
	public void setKeyword (String keyword) { this.keyword = keyword; }
	
	public ValueRepresentation<?>[] getVr () { return vr; }
	public void setValueRepresentation (ValueRepresentation<?>... vr) { this.vr = vr; }

	public ValueMultiplicity getVm () { return vm; }
	public void setValueMultiplicity (ValueMultiplicity vm) { this.vm = vm; }

	public String getRetirement () { return retirement; }
	public void setRetirement (String retirement) { this.retirement = retirement; }
	
	@Override
	public String toString ()
	{
		return tag + " " + name + " " + keyword + " " + Arrays.toString (vr) + " " + vm + " " + retirement;
	}
	
	public static void main (String[] args)
	{
		AttributeTag tag = AttributeTag.parseTag ("00080001");
		ElementDictionaryEntry entry = new ElementDictionaryEntry (
			tag, 
			"Test Attribute", 
			"TestAttribute", 
			ValueRepresentation.ST, 
			ValueMultiplicity.exactly (1), 
			"RET"
		);
		System.out.println (entry);
	}
}
