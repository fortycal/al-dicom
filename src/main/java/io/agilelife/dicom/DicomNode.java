package io.agilelife.dicom;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * A DicomNode hosts zero or more Attributes (indicating their usage), and a list of
 * zero or more sub-nodes.
 * 
 * @author Elliott Wade
 */
public abstract class DicomNode<V> implements IUsable
{
	public final NodeType type;
	public final Usage usage;
	
	public final DicomNode<?> parent = null;
	public final List<DicomNode<?>> children = new ArrayList<> ();
	
	public DicomNode (NodeType type, Usage usage)
	{
		this.type = type;
		this.usage = usage;
	}
	
	public Usage getUsage () { return usage; }
	
	public String toString ()
	{
		StringBuilder sb = new StringBuilder ();
		bufferPrettyString (0, "  ", sb);
		return sb.toString ();
	}
	
	private void bufferPrettyString (int tab, String tabString, StringBuilder buf)
	{
		tabString = (tabString == null) ? "  " : tabString;
		String indent = new String (new char[tab]).replace("\0", tabString);
		buf.append (indent + getClass ().getSimpleName () + " " + type + " " + usage + "\n");
		
		Field[] fa = this.getClass ().getDeclaredFields ();
		for (Field f : fa)
		{
			if (Attribute.class.isAssignableFrom (f.getType ()))
			{
				try
				{
					Attribute<?> a = (Attribute<?>) f.get (this);
					buf.append (indent + tabString + a.getAttributeTag () + " " + a.getName () + " " + a.getVr () + " " + a.getVm () + "\n");
				}
				catch (IllegalAccessException ignored) { }
			}
		}
		
		for (DicomNode<?> child : children)
		{
			child.bufferPrettyString (tab + 1, tabString, buf);
		}
	}
}
