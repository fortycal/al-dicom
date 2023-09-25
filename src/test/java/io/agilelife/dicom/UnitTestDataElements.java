package io.agilelife.dicom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.agilelife.dicom.macro.FileMeta;

class UnitTestDataElements
{
	@Test
	void testValidAttributeTag ()
	{
		final String GROUP = "0000";
		final String ELEMENT = "FFFF";
		AttributeTag at = new AttributeTag (GROUP, ELEMENT);
		assertEquals ("(" + GROUP + "," + ELEMENT + ")", at.toString ());
		at = AttributeTag.parseTag (GROUP + ELEMENT);
		assertEquals ("(" + GROUP + "," + ELEMENT + ")", at.toString ());
		at = AttributeTag.parseTag ("(" + GROUP + ", " + ELEMENT + ")");
		assertEquals ("(" + GROUP + "," + ELEMENT + ")", at.toString ());
		assertThrows (IllegalArgumentException.class, () -> new AttributeTag (GROUP, "00 N0"));
	}
	
	@Test
	void testInvalidAttributeTagNumberFormat ()
	{
		final String GROUP_OK = "00A0";
		final String GROUP_NOT_OK = "00N0";
		final String ELEMENT_OK = "00A0";
		final String ELEMENT_NOT_OK = "00N0";
		assertThrows (NumberFormatException.class, () -> new AttributeTag (GROUP_OK, ELEMENT_NOT_OK));
		assertThrows (NumberFormatException.class, () -> new AttributeTag (GROUP_NOT_OK, ELEMENT_OK));
	}
	
	@Test
	void testAttributeTagOutOfRange ()
	{
		final String GROUP_OK = "00A0";
		final String GROUP_NOT_OK = "F0000";
		final String ELEMENT_OK = "00A0";
		final String ELEMENT_NOT_OK = "F0000";
		assertThrows (IllegalArgumentException.class, () -> new AttributeTag (GROUP_OK, ELEMENT_NOT_OK));
		assertThrows (IllegalArgumentException.class, () -> new AttributeTag (GROUP_NOT_OK, ELEMENT_OK));
	}
	
	@Test
	void testValueMultiplicity ()
	{
		final ValueMultiplicity ONE_OR_MORE = ValueMultiplicity.nOrMore (1);
		assertTrue (ONE_OR_MORE.allows (65535));
		assertFalse (ONE_OR_MORE.allows (0));
		assertEquals ("1-n", ONE_OR_MORE.toString ());
		
		final ValueMultiplicity TWO = ValueMultiplicity.exactly (2);
		assertTrue (TWO.allows (2));
		assertFalse (TWO.allows (1));
		assertEquals ("2", TWO.toString ());
		
		final ValueMultiplicity MULTIPLE_OF_THREE = ValueMultiplicity.multipleOf (3);
		assertTrue (MULTIPLE_OF_THREE.allows (3));
		assertTrue (MULTIPLE_OF_THREE.allows (12));
		assertFalse (MULTIPLE_OF_THREE.allows (17));
		assertEquals ("3-3n", MULTIPLE_OF_THREE.toString ());
	}
	
	@Test
	void testValueMultiplicityParse ()
	{
		assertEquals (ValueMultiplicity.exactly (1), ValueMultiplicity.parse ("1"));
		assertEquals (ValueMultiplicity.nOrMore (1), ValueMultiplicity.parse ("1-n"));
		assertEquals (ValueMultiplicity.rangeInclusive (1, 2), ValueMultiplicity.parse ("1-2"));
		assertEquals (ValueMultiplicity.multipleOf (2), ValueMultiplicity.parse ("2-2n"));
	}
	
	@Test
	void testValueRepresentationParse ()
	{
		assertEquals (ValueRepresentation.parseRep ("ST"), ValueRepresentation.ST);
		assertEquals (ValueRepresentation.parseRep ("*gibberish*"), ValueRepresentation.UN); // default Unknown
	}
	
	@Test
	void testStandardDictionary ()
	{
		final ElementDictionary DICT = ElementDictionary.getStandard ();
		// System.out.println (DICT);
		
		AttributeTag toLookUp = AttributeTag.parseTag ("00281200");
		ElementDictionaryEntry entry = DICT.get (toLookUp);
		assertEquals (toLookUp, entry.getTag ());
		
		toLookUp = AttributeTag.parseTag ("002808A3"); // Orig JSON has "002808x3" so "x" can be 0...F
		entry = DICT.get (toLookUp);
		assertEquals (toLookUp, entry.getTag ());
	}
	
	@Test
	void testWellKnownAttributes ()
	{
		AttributeTag fmiglTag = AttributeTag.parseTag ("00020000");
		Attribute<?> fmigl = new FileMeta ().fileMetaInformationGroupLength;
		assertEquals (fmiglTag, fmigl.getAttributeTag ());
		assertEquals (ValueRepresentation.UL, fmigl.getVr ());
	}
	
//	@Test
//	void testStandardDictionaryMultiVr ()
//	{
//		final ElementDictionary DICT = ElementDictionary.getStandard ();
//		for (AttributeTag tag : DICT.getTags ())
//		{
//			ElementDictionaryEntry def = DICT.get (tag);
//			@SuppressWarnings("rawtypes")
//			ValueRepresentation[] defVr = def.getVr ();
//			if (defVr.length > 1)
//			{
//				System.out.println (def);
//			}
//		}
//	}
}
