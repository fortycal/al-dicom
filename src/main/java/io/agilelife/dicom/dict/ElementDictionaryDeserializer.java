package io.agilelife.dicom.dict;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import io.agilelife.dicom.AttributeTag;

public class ElementDictionaryDeserializer extends StdDeserializer<ElementDictionary>
{
	private static final long serialVersionUID = 1L;

	public ElementDictionaryDeserializer () { this (null); }

	public ElementDictionaryDeserializer (Class<?> vc) { super (vc); }

	@Override
	public ElementDictionary deserialize (JsonParser parser, DeserializationContext deserializer)
	{
		try
		{
			ObjectCodec codec = parser.getCodec ();
			JsonNode node = codec.readTree (parser);
			
			ElementDictionary d = new ElementDictionary (node.get ("name").asText (), node.get ("version").asText ());
			DictionaryEntryMapDeserializer deser = new DictionaryEntryMapDeserializer ();
			Map<AttributeTag, ElementDictionaryEntry> entries = deser.deserialize (parser, deserializer);
			d.entries = entries;
			return d;
		}
		catch (IOException e)
		{
			throw new RuntimeException ("Unable to import dictionary", e);
		}
	}
}
