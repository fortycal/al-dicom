package io.agilelife.dicom;

/**
 * A compound Attribute, i.e. an Attribute with VR == SQ containing zero or more DataSets.
 * <br><br>
 * An Attribute Sequence is a "virtual attribute" that encapsulates a set of Attributes with 
 * unique Tags in which each such set is transferred as a DataSet.  A Sequence may comprise 
 * multiple DataSets, but a given Attribute may not be duplicated in a sequence unless it
 * is itself a Sequence (indicating that a sequence of similar sub-items was intended/specified).
 * TODO: verify that the way the non-dupe requirement above is always true as stated.
 * <br><br>
 * See also class constructor comments.
 * TODO: Do we actually want/need this Class?
 * 
 * @author Elliott Wade
 */
public class AttributeSequence extends Attribute<Void> //<List<DataSet>>
{
	/**
	 * Constructs a new AttributeSequence.
	 * <br><br>
	 * Note that Sequences have been defined to have a Value Multiplicity of exactly 1:  
	 * one notional "sequence."  A sequence is not considered to have a "value" of its own.
	 * A conventional VM of "1" might be considered more appropriate than either "0" or "0-n":
	 * <ul>
	 * <li>A VM of "0" might misleadingly imply "no value, empty so skip me."</li>
	 * <li>A VM of "0-n" (read "any number of Attributes") misleadingly implies that the sub-attributes 
	 * can/must be thought of as a BLOB of Attributes in the value field rather than an explicit 
	 * collection of DataSets, which themselves contain the Attributes.</li>
	 * </ul>
	 * 
	 * @param tag
	 * @param vr
	 */
	public AttributeSequence (ElementDictionaryEntry definition, Usage usage)
	{
		super (definition, usage);
	}
}
