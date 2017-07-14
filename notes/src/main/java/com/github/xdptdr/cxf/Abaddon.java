package com.github.xdptdr.cxf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.activation.CommandInfo;
import javax.activation.CommandMap;
import javax.activation.DataHandler;

import org.apache.cxf.attachment.AttachmentDataSource;
import org.apache.cxf.attachment.AttachmentDeserializer;
import org.apache.cxf.attachment.AttachmentImpl;
import org.apache.cxf.attachment.AttachmentSerializer;
import org.apache.cxf.attachment.AttachmentUtil;
import org.apache.cxf.attachment.Base64DecoderStream;
import org.apache.cxf.attachment.ByteDataSource;
import org.apache.cxf.attachment.ContentDisposition;
import org.apache.cxf.attachment.DelegatingInputStream;
import org.apache.cxf.attachment.ImageDataContentHandler;
import org.apache.cxf.attachment.LazyAttachmentCollection;
import org.apache.cxf.attachment.LazyDataSource;
import org.apache.cxf.attachment.MimeBodyPartInputStream;
import org.apache.cxf.attachment.QuotedPrintableDecoderStream;
import org.apache.cxf.attachment.Rfc5987Util;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Message;

import com.github.xdptdr.cxf.abaddon.AbaddonMessage;

public class Abaddon {

	private static void foo() throws IOException {

		System.out.println(AttachmentUtil.BODY_ATTACHMENT_ID);

		System.out.println(AttachmentUtil.cleanContentId(null));
		System.out.println(AttachmentUtil.cleanContentId("<id>"));
		System.out.println(AttachmentUtil.cleanContentId("<cid:id>"));
		System.out.println(AttachmentUtil.cleanContentId("<cid:i%20d>"));

		System.out.println(AttachmentUtil.createContentID(null));
		System.out.println(AttachmentUtil.createContentID("titou"));
		System.out.println(AttachmentUtil.createContentID("http://www.titou.com:81/yopla/tam"));

		CommandMap cm = AttachmentUtil.getCommandMap();
		for (String mt : cm.getMimeTypes()) {
			System.out.println(mt);
			for (CommandInfo ci : cm.getAllCommands(mt)) {
				System.out.println(" - " + ci.getCommandName());
			}
		}

		System.out.println(AttachmentUtil.getUniqueBoundaryValue());

		Message message = new AbaddonMessage(true);
		System.out.println(AttachmentUtil.isMtomEnabled(message));

		InputStream stream = new ByteArrayInputStream(new byte[] {});
		Map<String, List<String>> headers = new HashMap<>();
		headers.put("Content-ID", Arrays.asList(new String[] { "id" }));
		headers.put("Content-Type", Arrays.asList(new String[] { "titi/toto" }));
		// headers.put("Content-Disposition", Arrays.asList(new String[] {
		// "inline" }));
		headers.put("Content-Disposition", Arrays.asList(new String[] { "attachment; filename=\"filename.txt\"" }));
		// headers.put("Content-Disposition",
		// Arrays.asList(new String[] { "form-data; name=\"fieldname\";
		// filename=\"filename.txt\"" }));
		headers.put("Content-Transfer-Encoding", Arrays.asList(new String[] { "binary" }));
		// headers.put("Content-Transfer-Encoding", Arrays.asList(new String[] {
		// "7bit" }));
		// headers.put("Content-Transfer-Encoding", Arrays.asList(new String[] {
		// "8bit" }));
		// headers.put("Content-Transfer-Encoding", Arrays.asList(new String[] {
		// "base64" }));
		// headers.put("Content-Transfer-Encoding", Arrays.asList(new String[] {
		// "quoted-printable" }));
		// headers.put("Content-Transfer-Encoding", Arrays.asList(new String[] {
		// "unknown" }));

		Attachment a = AttachmentUtil.createAttachment(stream, headers);
		DataHandler dh = a.getDataHandler();
		Iterator<String> hnames = a.getHeaderNames();
		String id = a.getId();
		boolean xop = a.isXOP();

		AttachmentUtil.createMtomAttachment(false, "", "", new byte[] {}, 0, 0, 0);
		

	}

	public static void main(String[] args) throws IOException {

		foo();

		new Class<?>[] { AttachmentDataSource.class, AttachmentDeserializer.class, AttachmentImpl.class,
				AttachmentSerializer.class, AttachmentUtil.class, Base64DecoderStream.class, ByteDataSource.class,
				ContentDisposition.class, DelegatingInputStream.class, ImageDataContentHandler.class,
				LazyAttachmentCollection.class, LazyDataSource.class, MimeBodyPartInputStream.class,
				QuotedPrintableDecoderStream.class, Rfc5987Util.class }.getClass();
	}

}
