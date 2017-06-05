package com.github.xdptdr.mbwar.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;
import java.io.Writer;
import java.util.Enumeration;
//import java.security.DigestInputStream;
//import java.util.jar.JarInputStream;
//import java.util.zip.CheckedInputStream;
//import java.util.zip.DeflaterInputStream;
//import java.util.zip.GZIPInputStream;
//import java.util.zip.InflaterInputStream;
//import java.util.zip.ZipInputStream;

//import javax.crypto.CipherInputStream;
//import javax.mail.util.SharedByteArrayInputStream;
//import javax.mail.util.SharedFileInputStream;
//import javax.servlet.ServletInputStream;
//import javax.sound.sampled.AudioInputStream;
//import javax.swing.ProgressMonitorInputStream;

//import com.sun.mail.imap.IMAPInputStream;
//import com.sun.mail.util.BASE64DecoderStream;
//import com.sun.mail.util.LineInputStream;
//import com.sun.mail.util.QDecoderStream;
//import com.sun.mail.util.QPDecoderStream;
//import com.sun.mail.util.TraceInputStream;
//import com.sun.mail.util.UUDecoderStream;

//import org.omg.CORBA.portable.InputStream;
@SuppressWarnings("deprecation")
public class MyIO {

	@SuppressWarnings("unused")
	private OutputStream outputStream;
	private PipedOutputStream pipedOutputStream;

	@SuppressWarnings("unused")
	private Reader reader;
	@SuppressWarnings("unused")
	private Writer writer;

	private InputStream inputStream;
	@SuppressWarnings("unused")
	private ByteArrayInputStream byteArrayInputStream;
	@SuppressWarnings("unused")
	private FileInputStream fileInputStream;
	@SuppressWarnings("unused")
	private FilterInputStream filterInputStream;
	@SuppressWarnings("unused")
	private BufferedInputStream bufferedInputStream;
	@SuppressWarnings("unused")
	private DataInputStream dataInputStream;
	@SuppressWarnings("unused")
	private LineNumberInputStream lineNumberInputStream;
	@SuppressWarnings("unused")
	private PushbackInputStream pushbackInputStream;
	@SuppressWarnings("unused")
	private ObjectInputStream objectInputStream;
	@SuppressWarnings("unused")
	private PipedInputStream pipedInputStream;
	@SuppressWarnings("unused")
	private SequenceInputStream sequenceInputStream;
	@SuppressWarnings("unused")
	private StringBufferInputStream stringBufferInputStream;

	private byte[] bytes;
	private int offset;
	private int length;
	private File file;
	private String fileName;
	private FileDescriptor fieDescriptor;
	private int size;
	private int pipeSize;
	private InputStream inputStream1;
	private InputStream inputStream2;
	private Enumeration<? extends InputStream> inputStreamEnumeration;
	private String string;

	public void foo() throws IOException {

		byteArrayInputStream = new ByteArrayInputStream(bytes);
		byteArrayInputStream = new ByteArrayInputStream(bytes, offset, length);
		fileInputStream = new FileInputStream(file);
		fileInputStream = new FileInputStream(fileName);
		fileInputStream = new FileInputStream(fieDescriptor);
		// filterInputStream = new ;
		bufferedInputStream = new BufferedInputStream(inputStream);
		bufferedInputStream = new BufferedInputStream(inputStream, size);
		dataInputStream = new DataInputStream(inputStream);
		lineNumberInputStream = new LineNumberInputStream(inputStream);
		pushbackInputStream = new PushbackInputStream(inputStream);
		pushbackInputStream = new PushbackInputStream(inputStream, size);
		objectInputStream = new ObjectInputStream(inputStream);
		pipedInputStream = new PipedInputStream();
		pipedInputStream = new PipedInputStream(pipedOutputStream);
		pipedInputStream = new PipedInputStream(pipeSize);
		pipedInputStream = new PipedInputStream(pipedOutputStream, pipeSize);
		sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2);
		sequenceInputStream = new SequenceInputStream(inputStreamEnumeration);
		stringBufferInputStream = new StringBufferInputStream(string);

		new Class<?>[] {}.getClass();

	}
}
