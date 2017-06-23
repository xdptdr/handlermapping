package com.github.xdptdr.mbwar.jaxb.notes;

import javax.xml.bind.Binder;
import javax.xml.bind.DataBindingException;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.DatatypeConverterInterface;
import javax.xml.bind.Element;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.JAXBPermission;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.NotIdentifiableEvent;
import javax.xml.bind.ParseConversionEvent;
import javax.xml.bind.PrintConversionEvent;
import javax.xml.bind.PropertyException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.TypeConstraintException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.ValidationException;
import javax.xml.bind.Validator;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.bind.annotation.W3CDomHandler;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttachmentRef;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSchemaTypes;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.bind.helpers.AbstractMarshallerImpl;
import javax.xml.bind.helpers.AbstractUnmarshallerImpl;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import javax.xml.bind.helpers.NotIdentifiableEventImpl;
import javax.xml.bind.helpers.ParseConversionEventImpl;
import javax.xml.bind.helpers.PrintConversionEventImpl;
import javax.xml.bind.helpers.ValidationEventImpl;
import javax.xml.bind.helpers.ValidationEventLocatorImpl;
import javax.xml.bind.util.JAXBResult;
import javax.xml.bind.util.JAXBSource;
import javax.xml.bind.util.ValidationEventCollector;

import com.github.xdptdr.notes.N;

@SuppressWarnings("deprecation")
public class Notes {
	public static void notes(N n) {

		n.todo(Binder.class);
		n.todo(DataBindingException.class);
		n.todo(DatatypeConverter.class);
		n.todo(DatatypeConverterInterface.class);
		n.todo(Element.class);
		n.todo(JAXB.class);
		n.todo(JAXBContext.class);
		n.todo(JAXBElement.class);
		n.todo(JAXBException.class);
		n.todo(JAXBIntrospector.class);
		n.todo(JAXBPermission.class);
		n.todo(MarshalException.class);
		n.todo(Marshaller.class);
		n.todo(NotIdentifiableEvent.class);
		n.todo(ParseConversionEvent.class);
		n.todo(PrintConversionEvent.class);
		n.todo(PropertyException.class);
		n.todo(SchemaOutputResolver.class);
		n.todo(TypeConstraintException.class);
		n.todo(UnmarshalException.class);
		n.todo(Unmarshaller.class);
		n.todo(UnmarshallerHandler.class);
		n.todo(ValidationEvent.class);
		n.todo(ValidationEventHandler.class);
		n.todo(ValidationEventLocator.class);
		n.todo(ValidationException.class);
		n.todo(Validator.class);

		n.todo(DomHandler.class);
		n.todo(W3CDomHandler.class);
		n.todo(XmlAccessOrder.class);
		n.todo(XmlAccessorOrder.class);
		n.todo(XmlAccessorType.class);
		n.todo(XmlAnyAttribute.class);
		n.todo(XmlAnyElement.class);
		n.todo(XmlAttachmentRef.class);
		n.todo(XmlAttribute.class);
		n.todo(XmlElements.class);
		n.todo(XmlElementDecl.class);
		n.todo(XmlElementRef.class);
		n.todo(XmlElementRefs.class);
		n.todo(XmlElements.class);
		n.todo(XmlElementWrapper.class);
		n.todo(XmlEnum.class);
		n.todo(XmlEnumValue.class);
		n.todo(XmlID.class);
		n.todo(XmlIDREF.class);
		n.todo(XmlList.class);
		n.todo(XmlMimeType.class);
		n.todo(XmlMixed.class);
		n.todo(XmlNs.class);
		n.todo(XmlNsForm.class);
		n.todo(XmlRegistry.class);
		n.todo(XmlRootElement.class);
		n.todo(XmlSchema.class);
		n.todo(XmlSchemaType.class);
		n.todo(XmlSchemaTypes.class);
		n.todo(XmlSeeAlso.class);
		n.todo(XmlTransient.class);
		n.todo(XmlType.class);
		n.todo(XmlValue.class);

		n.todo(CollapsedStringAdapter.class);
		n.todo(HexBinaryAdapter.class);
		n.todo(NormalizedStringAdapter.class);
		n.todo(XmlAdapter.class);
		n.todo(XmlJavaTypeAdapter.class);
		n.todo(XmlJavaTypeAdapters.class);

		n.todo(AttachmentMarshaller.class);
		n.todo(AttachmentUnmarshaller.class);

		n.todo(AbstractMarshallerImpl.class);
		n.todo(AbstractUnmarshallerImpl.class);
		n.todo(DefaultValidationEventHandler.class);
		n.todo(NotIdentifiableEventImpl.class);
		n.todo(ParseConversionEventImpl.class);
		n.todo(PrintConversionEventImpl.class);
		n.todo(ValidationEventImpl.class);
		n.todo(ValidationEventLocatorImpl.class);

		n.todo(JAXBResult.class);
		n.todo(JAXBSource.class);
		n.todo(ValidationEventCollector.class);
	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
