package org.verapdf.model.impl.pb.xmp;

import org.apache.xmpbox.XMPMetadata;
import org.verapdf.model.xmplayer.XMPMainPackage;

/**
 * Current class is representation of XMPPackage interface from abstract model based on xmpbox from pdfbox.
 *
 * @author Maksim Bezrukov
 */
public class PBXMPMainPackage extends PBXMPPackage implements XMPMainPackage {

	public static final String XMP_MAIN_PACKAGE_TYPE = "XMPMainPackage";

	/**
	 * Constructs new object
	 *
	 * @param xmpMetadata     object from xmpbox represented this package
	 * @param isMetadataValid true if metadata is valid
	 * @param errorMessage message from the error if metadata is not valid
	 */
	public PBXMPMainPackage(XMPMetadata xmpMetadata, boolean isMetadataValid, String errorMessage) {
		super(xmpMetadata, isMetadataValid, XMP_MAIN_PACKAGE_TYPE, errorMessage);
	}

	/**
	 * @return true if pdfaid schema is present
	 */
	@Override
	public Boolean getispdfaidNSPresent() {
		return this.getXmpMetadata() == null ? Boolean.FALSE : Boolean
				.valueOf(this.getXmpMetadata().getPDFIdentificationSchema() != null);
	}
}
