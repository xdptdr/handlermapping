package com.github.xdptdr.jee7;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

import javax.transaction.xa.XAResource;
import javax.xml.bind.Binder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Unmarshaller.Listener;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttachmentRef;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSchemaTypes;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;

public class ReadingJSR222_JAXB extends Reading {

	private String contextPath;
	private ClassLoader classLoader;
	private String class1;
	private ClassLoader class2;
	private Map<String, ?> class3;
	private JAXBContext jaxbContext;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	private JAXBIntrospector jaxbIntrospector;
	private Class clazz;
	private Binder<Object> binder;
	private Binder<Node> binder2;
	private SchemaOutputResolver schemaOutputResolver;
	private ValidationEventHandler validationEventHandler;
	private String propertyName;
	private Object propertyValue;
	private Schema schema;
	private UnmarshallerHandler unmarshallerHandler;
	private Listener listener;
	private Object object;
	private File file;
	private URL url;
	private InputStream inputStream;
	private InputSource inputSource;
	private Node node;
	private Source source;
	private XMLStreamReader xmlStreamReader;
	private XMLEventReader xmlEventReader;
	private javax.xml.bind.Marshaller.Listener marshallerListener;
	private Writer writer;
	private OutputStream outputStream;
	private ContentHandler contentHandler;
	private Result result;
	private XMLStreamWriter xmlStreamWriter;
	private boolean b;
	private QName qName;

	@Override
	public void reading() throws Exception {
		section("1", RS.UNTOUCHED);
		section("2", RS.UNTOUCHED);
		section("3", RS.UNTOUCHED);
		section("4", RS.UNTOUCHED);

		Unmarshaller.class.getName();
		Marshaller.class.getName();
		Binder.class.getName();
		JAXBContext.class.getName();

		section("4.1", RS.STARTED);

		section("4.2", RS.STARTED);

		dontRun(new NotRunnable() {

			@XmlRootElement
			class Foo {
				Bar b;
			}

			@XmlType
			class Bar {
				FooBar fb;
			}

			@XmlType
			class FooBar {
				int x;
			}

			@Override
			public void dontRun() throws Exception {
				jaxbContext = JAXBContext.newInstance(contextPath);
				jaxbContext = JAXBContext.newInstance(contextPath, classLoader);
				jaxbContext = JAXBContext.newInstance(class1, class2, class3);

				marshaller = jaxbContext.createMarshaller();
				unmarshaller = jaxbContext.createUnmarshaller();
				jaxbIntrospector = jaxbContext.createJAXBIntrospector();
				binder = jaxbContext.createBinder(clazz);
				binder2 = jaxbContext.createBinder();
				jaxbContext.generateSchema(schemaOutputResolver);

				jaxbContext = JAXBContext.newInstance("com.acme.foo:com.acme.bar");
			}
		});

		/*
		 * the jaxb.index resource file is not necessary when an application
		 * initializes a JAXBContext with classes
		 */

		section("4.3", RS.UNTOUCHED);
		section("4.4", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				validationEventHandler = unmarshaller.getEventHandler();
				unmarshaller.setEventHandler(validationEventHandler);

				propertyValue = unmarshaller.getProperty(propertyName);
				unmarshaller.setProperty(propertyName, propertyValue);

				unmarshaller.setSchema(schema);
				schema = unmarshaller.getSchema();

				unmarshallerHandler = unmarshaller.getUnmarshallerHandler();

				unmarshaller.setListener(listener);
				listener = unmarshaller.getListener();

				object = unmarshaller.unmarshal(file);
				object = unmarshaller.unmarshal(url);
				object = unmarshaller.unmarshal(inputStream);
				object = unmarshaller.unmarshal(inputSource);
				object = unmarshaller.unmarshal(node);
				object = unmarshaller.unmarshal(source);
				object = unmarshaller.unmarshal(xmlStreamReader);
				object = unmarshaller.unmarshal(xmlEventReader);
				object = unmarshaller.unmarshal(node, clazz);
				object = unmarshaller.unmarshal(source, clazz);
				object = unmarshaller.unmarshal(xmlStreamReader, clazz);
				object = unmarshaller.unmarshal(xmlEventReader, clazz);

				UnmarshalException.class.getName();

			}
		});
		section("4.4.1", RS.STARTED);
		section("4.4.1.1", RS.STARTED);

		dontRun(new NotRunnable() {
			class MyThing {
				private void beforeUnmarshal(Unmarshaller unmarshaller, Object parent) {
				}

				private void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
				}
			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		section("4.4.1.2", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				unmarshaller.setListener(listener);
			}
		});

		section("4.4.2", RS.STARTED);

		section("4.4.3", RS.STARTED);
		section("4.4.4", RS.STARTED);

		section("4.5", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				propertyValue = marshaller.getProperty(propertyName);
				marshaller.setProperty(propertyName, propertyValue);

				marshaller.setEventHandler(validationEventHandler);
				validationEventHandler = marshaller.getEventHandler();

				marshaller.setSchema(schema);
				schema = marshaller.getSchema();

				marshaller.setListener(marshallerListener);
				marshallerListener = marshaller.getListener();

				marshaller.marshal(object, writer);
				marshaller.marshal(object, outputStream);
				marshaller.marshal(object, contentHandler);
				marshaller.marshal(object, result);
				marshaller.marshal(object, node);
				marshaller.marshal(object, xmlStreamWriter);

				node = marshaller.getNode(object);

			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				jaxbIntrospector.isElement(object);
			}
		});

		// use these to marshal objects which are not JAXB
		JAXBElement.class.getName();
		XmlRootElement.class.isAnnotation();

		section("4.5.1", RS.STARTED);

		section("4.5.1.1", RS.STARTED);

		dontRun(new NotRunnable() {
			class MyThing {
				private void beforeMarshal(Marshaller unmarshaller) {
				}

				private void afterMarshal(Marshaller unmarshaller) {
				}
			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		section("4.5.1.2", RS.STARTED);

		Marshaller.Listener.class.getName();

		section("4.5.2", RS.STARTED);

		/*-
		 * - jaxb.encoding
		 * - jaxb.formatted.output
		 * - jaxb.schemaLocation
		 * - jaxb.noNamespaceSchemaLocation
		 * - jaxb.fragment
		 */

		section("4.6", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				b = jaxbIntrospector.isElement(object);
				qName = jaxbIntrospector.getElementName(object);
				object = jaxbIntrospector.getValue(object);
			}
		});

		section("4.7", RS.STARTED);

		section("4.8", RS.STARTED);
		section("4.8.1", RS.STARTED);
		section("4.8.2", RS.STARTED);

		object = binder.unmarshal(object);
		object = binder.unmarshal(node, clazz);

		binder.marshal(object, object);

		object = binder.getXMLNode(object);
		object = binder.getJAXBNode(object);

		object = binder.updateXML(object);
		object = binder.updateXML(object, object);
		object = binder.updateJAXB(object);

		binder.setSchema(schema);
		schema = binder.getSchema();

		binder.setEventHandler(validationEventHandler);
		validationEventHandler = binder.getEventHandler();

		binder.setProperty(propertyName, propertyValue);
		propertyValue = binder.getProperty(propertyName);

		section("5", RS.UNTOUCHED);
		section("6", RS.UNTOUCHED);
		section("7", RS.UNTOUCHED);
		section("8", RS.STARTED);
		section("8.1", RS.STARTED);
		section("8.2", RS.STARTED);
		section("8.2.1", RS.STARTED);
		section("8.2.2", RS.STARTED);
		section("8.2.3", RS.STARTED);

		XmlTransient.class.isAnnotation();
		XmlType.class.isAnnotation();

		section("8.2.4", RS.STARTED);

		XmlRootElement.class.isAnnotation();

		section("8.2.5", RS.STARTED);

		// use this to map a class to a simple type
		XmlValue.class.isAnnotation();

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				XmlType.class.newInstance().factoryMethod();
				XmlType.class.newInstance().factoryClass();

			}
		});

		XmlAccessorOrder.class.isAnnotation();
		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				XmlType.class.newInstance().propOrder();

			}
		});

		XmlJavaTypeAdapter.class.isAnnotation();

		XmlElementWrapper.class.isAnnotation();

		XmlList.class.isAnnotation();

		section("8.2.6", RS.STARTED);

		/* implements XmlAdapter then reference it with XmlJavaTypeAdapter */

		section("8.2.7", RS.STARTED);
		XmlID.class.isAnnotation();
		XmlIDREF.class.isAnnotation();

		section("8.2.8", RS.STARTED);

		XmlTransient.class.isAnnotation();

		section("8.3", RS.STARTED);
		section("8.4", RS.STARTED);

		section("8.5", RS.STARTED);
		section("8.5.1", RS.STARTED);

		/*-
		 * - boolean => xs:boolean
		 * - byte => xs:byte
		 * - short => xs:short
		 * - int => xs:int
		 * - long => xs:long
		 * - float => xs:float
		 * - double => xs:double
		 */

		section("8.5.2", RS.STARTED);

		/*-
		 * - String => xs:string
		 * - BigInteger => xs:integer
		 * - BigDecimal => xs:decimal
		 * - Calendar => xs:dateTime
		 * - Date => xs:dateTime
		 * - QName => xs:QName
		 * - URI => xs:string
		 * - XMLGregorianCalendar => xs:anySimpleType
		 * - Duration => xs:duration
		 * - Object => xs:anyType
		 * - Image => xs:base64Binary
		 * - DataHandler => xs:base64Binary
		 * - Source => xs:base64Binary
		 * - UUID => xs:string
		 */

		section("8.5.3", RS.STARTED);
		section("8.5.3.1", RS.STARTED);
		section("8.5.3.2", RS.STARTED);
		section("8.5.4", RS.STARTED);

		Map.class.getName();
		Collection.class.getName();

		section("8.6", RS.STARTED);

		XmlSchema.class.isAnnotation();
		XmlAccessorType.class.isAnnotation();
		XmlAccessorOrder.class.isAnnotation();
		XmlSchemaType.class.isAnnotation();
		XmlSchemaTypes.class.isAnnotation();

		section("8.7", RS.STARTED);

		XmlType.class.isAnnotation();
		XmlRootElement.class.isAnnotation();
		XmlTransient.class.isAnnotation();
		XmlSeeAlso.class.isAnnotation();

		section("8.8", RS.STARTED);

		XmlEnum.class.isAnnotation();
		XmlEnumValue.class.isAnnotation();
		XmlType.class.isAnnotation();
		XmlRootElement.class.isAnnotation();

		section("8.9", RS.STARTED);

		XmlElement.class.isAnnotation();
		XmlElements.class.isAnnotation();
		XmlElementRef.class.isAnnotation();
		XmlElementRefs.class.isAnnotation();
		XmlElementWrapper.class.isAnnotation();
		XmlAnyElement.class.isAnnotation();
		XmlAttribute.class.isAnnotation();
		XmlAnyAttribute.class.isAnnotation();
		XmlTransient.class.isAnnotation();
		XmlValue.class.isAnnotation();
		XmlID.class.isAnnotation();
		XmlIDREF.class.isAnnotation();
		XmlList.class.isAnnotation();
		XmlMixed.class.isAnnotation();
		XmlMimeType.class.isAnnotation();
		XmlAttachmentRef.class.isAnnotation();
		XmlInlineBinaryData.class.isAnnotation();

		section("8.10", RS.STARTED);

		XmlElementDecl.class.isAnnotation();

		section("8.11", RS.STARTED);

		XmlJavaTypeAdapter.class.isAnnotation();
		XmlJavaTypeAdapters.class.isAnnotation();

		section("8.12", RS.STARTED);

		section("9", RS.UNTOUCHED);

	}

}
