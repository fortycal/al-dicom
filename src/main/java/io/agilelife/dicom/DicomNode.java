package io.agilelife.dicom;

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
}
