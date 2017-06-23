package com.github.xdptdr.notes.stream;

import javax.xml.stream.EventFilter;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.Location;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.Comment;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.EntityReference;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.NotationDeclaration;
import javax.xml.stream.events.ProcessingInstruction;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.EventReaderDelegate;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.stream.util.XMLEventAllocator;
import javax.xml.stream.util.XMLEventConsumer;

import com.github.xdptdr.notes.N;

public class Notes {

	private static void notes(N n) {

		n.todo(EventFilter.class);
		n.todo(FactoryConfigurationError.class);
		n.todo(Location.class);
		n.todo(StreamFilter.class);
		n.todo(XMLEventFactory.class);
		n.todo(XMLEventReader.class);
		n.todo(XMLEventWriter.class);
		n.todo(XMLInputFactory.class);
		n.todo(XMLOutputFactory.class);
		n.todo(XMLReporter.class);
		n.todo(XMLResolver.class);
		n.todo(XMLStreamConstants.class);
		n.todo(XMLStreamException.class);
		n.todo(XMLStreamReader.class);
		n.todo(XMLStreamWriter.class);

		n.todo(Attribute.class);
		n.todo(Characters.class);
		n.todo(Comment.class);
		n.todo(DTD.class);
		n.todo(EndDocument.class);
		n.todo(EndElement.class);
		n.todo(EntityDeclaration.class);
		n.todo(EntityReference.class);
		n.todo(Namespace.class);
		n.todo(NotationDeclaration.class);
		n.todo(ProcessingInstruction.class);
		n.todo(StartDocument.class);
		n.todo(StartElement.class);
		n.todo(XMLEvent.class);

		n.todo(EventReaderDelegate.class);
		n.todo(StreamReaderDelegate.class);
		n.todo(XMLEventAllocator.class);
		n.todo(XMLEventConsumer.class);

	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
