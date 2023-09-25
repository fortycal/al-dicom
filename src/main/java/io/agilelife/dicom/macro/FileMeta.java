package io.agilelife.dicom.macro;

import java.math.BigInteger;

import io.agilelife.dicom.Attribute;
import io.agilelife.dicom.DicomNode;
import io.agilelife.dicom.ElementDictionary;
import io.agilelife.dicom.NodeType;
import io.agilelife.dicom.Usage;

/**
 * <a href="https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/chapter_7.html#table_7.1-1">Specification</a>
 * 
 * @author Elliott Wade
 */
public class FileMeta extends DicomNode<Void>
{
	public static final class FileMetaInformationGroupLength extends Attribute<BigInteger> {
		public FileMetaInformationGroupLength () { super (ElementDictionary.getStandard ().get ("(0002,0000)"), Usage.ONE); }
	}
	public final FileMetaInformationGroupLength fileMetaInformationGroupLength = new FileMetaInformationGroupLength ();
	
	/**
	 * Initializes value to [00000000, 00000001], as per:
	 * https://dicom.nema.org/medical/dicom/2023c/output/chtml/part10/chapter_7.html#table_7.1-1
	 */
	public class FileMetaInformationVersion extends Attribute<byte[]> {
		public FileMetaInformationVersion () {
			super (ElementDictionary.getStandard ().get ("(0002,0001)"), Usage.ONE);
			set (new byte[][] {{0x0, 0x1}});
		}
	}
	public final FileMetaInformationVersion fileMetaInformationVersion = new FileMetaInformationVersion ();
	
	public class MediaStorageSOPClassUID extends Attribute<String> {
		public MediaStorageSOPClassUID () { super (ElementDictionary.getStandard ().get ("(0002,0002)"), Usage.ONE); }
	}
	public final MediaStorageSOPClassUID mediaStorageSOPClassUID = new MediaStorageSOPClassUID ();
	
	public class MediaStorageSOPInstanceUID extends Attribute<String> {;
		public MediaStorageSOPInstanceUID () { super (ElementDictionary.getStandard ().get ("(0002,0003)"), Usage.ONE); }
	}
	public final MediaStorageSOPInstanceUID mediaStorageSOPInstanceUID = new MediaStorageSOPInstanceUID ();
	
	public class TransferSyntaxUID extends Attribute<String> {
		// TODO Init to the most common transfer syntax
		public TransferSyntaxUID () { super (ElementDictionary.getStandard ().get ("(0002,0010)"), Usage.ONE); }
	}
	public final TransferSyntaxUID transferSyntaxUID = new TransferSyntaxUID ();
	
	public class ImplementationClassUID extends Attribute<String> {
		public ImplementationClassUID () { super (ElementDictionary.getStandard ().get ("(0002,0012)"), Usage.ONE); }
	}
	public final ImplementationClassUID implementationClassUID = new ImplementationClassUID ();
	
	public class ImplementationVersionName extends Attribute<String> {
		public ImplementationVersionName () { super (ElementDictionary.getStandard ().get ("(0002,0013)"), Usage.THREE); }
	}
	public final ImplementationVersionName implementationVersionName = new ImplementationVersionName ();
	
	public class SourceApplicationEntityTitle extends Attribute<String> {
		public SourceApplicationEntityTitle () { super (ElementDictionary.getStandard ().get ("(0002,0016)"), Usage.THREE); }
	}
	public final SourceApplicationEntityTitle sourceApplicationEntityTitle = new SourceApplicationEntityTitle ();
	
	public final static class SendingApplicationEntityTitle extends Attribute<String> {
		public SendingApplicationEntityTitle () { super (ElementDictionary.getStandard ().get ("(0002,0017)"), Usage.THREE); }
	}
	public final SendingApplicationEntityTitle sendingApplicationEntityTitle = new SendingApplicationEntityTitle ();
	
	public final static class ReceivingApplicationEntityTitle extends Attribute<String> {
		public ReceivingApplicationEntityTitle () { super (ElementDictionary.getStandard ().get ("(0002,0018)"), Usage.THREE); }
	}
	public final ReceivingApplicationEntityTitle receivingApplicationEntityTitle = new ReceivingApplicationEntityTitle ();
	
	public class SourcePresentationAddress extends Attribute<String> {
		public SourcePresentationAddress () { super (ElementDictionary.getStandard ().get ("(0002,0026)"), Usage.THREE); }
	}
	public final SourcePresentationAddress sourcePresentationAddress = new SourcePresentationAddress ();
	
	public class SendingPresentationAddress extends Attribute<String> {
		public SendingPresentationAddress () { super (ElementDictionary.getStandard ().get ("(0002,0027)"), Usage.THREE); }
	}
	public final SendingPresentationAddress sendingPresentationAddress = new SendingPresentationAddress ();
	
	public class ReceivingPresentationAddress extends Attribute<String> {
		public ReceivingPresentationAddress () { super (ElementDictionary.getStandard ().get ("(0002,0028)"), Usage.THREE); }
	}
	public final ReceivingPresentationAddress receivingPresentationAddress = new ReceivingPresentationAddress ();
	
	public class PrivateInformationCreatorUID extends Attribute<String> {
		public PrivateInformationCreatorUID () { super (ElementDictionary.getStandard ().get ("(0002,0100)"), Usage.THREE); }
	}
	PrivateInformationCreatorUID privateInformationCreatorUID = new PrivateInformationCreatorUID ();
	
	public class PrivateInformation extends Attribute<byte[]> {
		public PrivateInformation () { super (ElementDictionary.getStandard ().get ("(0002,0102)"), Usage.ONE_C); }
	}
	PrivateInformation privateInformation = new PrivateInformation ();
	
	public FileMeta ()
	{
		super (NodeType.FILE_META, Usage.MANDATORY);
	}
}
