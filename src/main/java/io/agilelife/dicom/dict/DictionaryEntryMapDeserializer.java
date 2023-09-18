package io.agilelife.dicom.dict;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import io.agilelife.dicom.AttributeTag;
import io.agilelife.dicom.ValueMultiplicity;
import io.agilelife.dicom.ValueRepresentation;

public class DictionaryEntryMapDeserializer extends JsonDeserializer<Map<AttributeTag, ElementDictionaryEntry>>
{
	private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
	
	@Override
	public Map<AttributeTag, ElementDictionaryEntry> deserialize (JsonParser parser, DeserializationContext ctxt)
		throws IOException, JsonProcessingException
	{
		Map<AttributeTag, ElementDictionaryEntry> ret = new HashMap<> ();
		
		ObjectCodec codec = parser.getCodec ();
		TreeNode entries = codec.readTree (parser);
		
		if (entries.isArray ())
		{
			tags: for (JsonNode entry : (ArrayNode) entries)
			{
				// tag, name, keyword, vr[], vm, retirement
				JsonNode tagNode = entry.get ("tag");
				
				if (tagNode == null) continue tags;
				String tagText = tagNode.asText ();
				if (tagText == null || tagText.isBlank ()) continue;
				
				String[] sa = new String[] {tagText};
				if (tagText.contains("x"))
					sa = xpand (tagText);
				
				for (String s : sa)
				{
					AttributeTag t = AttributeTag.parseTag (s);
					String n = entry.get ("name").asText();
					String k = entry.get ("keyword").asText ();
					ValueRepresentation[] v = parseVR (entry.get ("vr"));
					ValueMultiplicity m = ValueMultiplicity.parseMult (entry.get ("vm").asText ());
					String r = entry.get ("retirement").asText ();
					
					ret.put (t, new ElementDictionaryEntry (t, n, k, v, m, r));
				}
			}
		}
		return ret;
	}
	
	private static String[] xpand (String s)
	{
		s = s.toLowerCase ();
		
		List<Integer> posns = new ArrayList<> (s.length ());
		for (int i=0; i<s.length (); i++)
			if (s.charAt (i) == 'x') posns.add (i);
		
		String[][] perms = permute (posns.size ());
		String[] sa = new String[perms.length];
		for (int i=0; i<perms.length; i++)
		{
			sa[i] = s;
			for (int j=0; j<perms[0].length; j++)
			{
				sa[i] = sa[i].replaceFirst ("x", perms[i][j]);
			}
		}
		return sa;
	}
	
	private static String[][] permute (int posns)
	{
		String[][] ia = new String[(int) Math.pow (16, posns)][posns];
		
		for (int all=0; all<ia.length; all++)
		{
			for (int dig=1; dig<=posns; dig++) // e.g. 1, 2, 3
			{
				ia[all][posns - dig] = HEX_DIGITS[all / ((int) (Math.pow (16, dig-1))) % 16];
			}
		}
		return ia;
	}
	
	private ValueRepresentation[] parseVR (JsonNode vrn)
	{
		if (vrn.isArray ())
		{
			int size = ((ArrayNode) vrn).size ();
			ValueRepresentation[] ret = new ValueRepresentation[size];
			for (int i=0; i<size; i++)ret[i] = ValueRepresentation.parseRep (vrn.get (i).asText ());
			return ret;
		}
		else return new ValueRepresentation[] {ValueRepresentation.parseRep (vrn.asText ())};
	}
}
