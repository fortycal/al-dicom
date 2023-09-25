package io.agilelife.dicom;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ElementDictionary
{
	private static ElementDictionary standardDictionary = null;
	
	public String name = "<unknown>";
	public String version = "<unknown>";
	
	@JsonDeserialize(using = DictionaryEntryMapDeserializer.class)
	public final Map<AttributeTag, ElementDictionaryEntry> entries = Collections.synchronizedSortedMap (new TreeMap<> ());
	
	public ElementDictionary () { }
	
	public ElementDictionary (String name, String version)
	{
		this.name = name;
		this.version = version;
	}
	
	public AttributeTag[] getTags ()
	{
		ArrayList<AttributeTag> al = new ArrayList<> ();
		for (AttributeTag t : entries.keySet ()) al.add (t);
		al.sort (null);
		return al.toArray (new AttributeTag[] {});
	}
	
	/**
	 * Adds a new entry to this dictionary.  If the new entry's tag is already included in this
	 * dictionary, then calling this method has no effect.
	 * 
	 * @return this dictionary, for fluent call chaining
	 */
	public ElementDictionary add (ElementDictionaryEntry entry)
	{
		if (entries.containsKey (entry.getTag ())) return this;
		entries.put (entry.getTag (), entry);
		return this;
	}
	
	/**
	 * Adds a new entry to this dictionary.  If the new entry's tag is already included in this
	 * dictionary, then calling this method has no effect.
	 * 
	 * @return this dictionary for fluent chaining
	 */
	public ElementDictionary add (AttributeTag tag, String name, String keyword, ValueRepresentation<?> vr, ValueMultiplicity vm, String retirement)
	{
		return add (new ElementDictionaryEntry (tag, name, keyword, new ValueRepresentation[] {vr}, vm, retirement));
	}
	
	/**
	 * Adds a new entry to this dictionary.  If the new entry's tag is already included in this
	 * dictionary, then calling this method has no effect.
	 * 
	 * @return this dictionary for fluent chaining
	 */
	public ElementDictionary add (AttributeTag tag, String name, String keyword, ValueRepresentation<?>[] vra, ValueMultiplicity vm, String retirement)
	{
		return add (new ElementDictionaryEntry (tag, name, keyword, vra, vm, retirement));
	}
	
	public ElementDictionaryEntry get (String tag)
	{
		return get (AttributeTag.parseTag (tag));
	}
	
	public ElementDictionaryEntry get (AttributeTag tag)
	{
		return entries.get (tag);
	}
	
	/**
	 * @param tag Tag string in the conventional format, e.g. 00000000 or (0000,0000)
	 * @return An new Attribute instance with the standard (usually only possible) Value Representation for the given Tag.
	 */
	public Attribute<?> attribute (String tag) throws Exception
	{
		ElementDictionaryEntry entry = get (tag);
		String className = "io.agilelife.dicom.attribute.Attribute" + entry.getVr ()[0].getCode ();
		Class<?> clazz = Class.forName (className);
		return (Attribute<?>) clazz.getDeclaredConstructor (
			AttributeTag.class, 
			ValueRepresentation.class
		).newInstance ();
	}
	
	@Override
	public String toString ()
	{
		return "Dictionary [" + entries.size() + " entries]: " + name + " (" + version + ")";
	}
	
	public static ElementDictionary getStandard ()
	{
		if (standardDictionary != null) return standardDictionary;
		
		ObjectMapper mapper = new ObjectMapper ();
//		SimpleModule module = new SimpleModule ("ElementDictionaryDeserializer", new Version (1, 0, 0, null, null, null));
//		module.addDeserializer (ElementDictionary.class, new ElementDictionaryDeserializer ());
//		mapper.registerModule (module);
		
//		SimpleModule module = new SimpleModule ("DictionaryEntryMapDeserializer", new Version (1, 0, 0, null, null, null));
//		module.addDeserializer (null, new DictionaryEntryMapDeserializer ());
//		mapper.registerModule (module);
		
		final String JSON_FILE = "io/agilelife/dicom/dict/dict-standard-2023c.json";
		try (InputStream in=Thread.currentThread ().getContextClassLoader().getResourceAsStream (JSON_FILE))
		{
			ElementDictionary ret = mapper.readValue (in, ElementDictionary.class);
			return standardDictionary = ret;
		}
		catch (Exception e)
		{
			throw (e instanceof RuntimeException) ? (RuntimeException) e : new RuntimeException ("Unable to load standard dictionary.", e);
		}
	}
}
