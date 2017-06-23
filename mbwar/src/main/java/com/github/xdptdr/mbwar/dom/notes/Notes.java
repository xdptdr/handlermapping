package com.github.xdptdr.mbwar.dom.notes;

import java.util.EventListener;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DOMImplementationList;
import org.w3c.dom.DOMImplementationSource;
import org.w3c.dom.DOMLocator;
import org.w3c.dom.DOMStringList;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Entity;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NameList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Notation;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventException;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.events.MutationEvent;
import org.w3c.dom.events.UIEvent;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSException;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSLoadEvent;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSParserFilter;
import org.w3c.dom.ls.LSProgressEvent;
import org.w3c.dom.ls.LSResourceResolver;
import org.w3c.dom.ls.LSSerializer;
import org.w3c.dom.ls.LSSerializerFilter;
import org.w3c.dom.ranges.Range;
import org.w3c.dom.ranges.RangeException;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.w3c.dom.traversal.TreeWalker;

import com.github.xdptdr.mbwar.jaxrs.notes.N;

public class Notes {
	public static void notes(N n) {

		n.todo(Attr.class);
		n.todo(CDATASection.class);
		n.todo(CharacterData.class);
		n.todo(Comment.class);
		n.todo(Document.class);
		n.todo(DocumentFragment.class);
		n.todo(DocumentType.class);
		n.todo(DOMConfiguration.class);
		n.todo(DOMError.class);
		n.todo(DOMErrorHandler.class);
		n.todo(DOMException.class);
		n.todo(DOMImplementation.class);
		n.todo(DOMImplementationList.class);
		n.todo(DOMImplementationSource.class);
		n.todo(DOMLocator.class);
		n.todo(DOMStringList.class);
		n.todo(Element.class);
		n.todo(Entity.class);
		n.todo(EntityReference.class);
		n.todo(NamedNodeMap.class);
		n.todo(NameList.class);
		n.todo(Node.class);
		n.todo(NodeList.class);
		n.todo(Notation.class);
		n.todo(ProcessingInstruction.class);
		n.todo(Text.class);
		n.todo(TypeInfo.class);
		n.todo(UserDataHandler.class);

		n.todo(DOMImplementationRegistry.class);

		n.todo(DocumentEvent.class);
		n.todo(Event.class);
		n.todo(EventException.class);
		n.todo(EventListener.class);
		n.todo(EventTarget.class);
		n.todo(MouseEvent.class);
		n.todo(MutationEvent.class);
		n.todo(UIEvent.class);

		n.todo(DOMImplementationLS.class);
		n.todo(LSException.class);
		n.todo(LSInput.class);
		n.todo(LSLoadEvent.class);
		n.todo(LSOutput.class);
		n.todo(LSParser.class);
		n.todo(LSParserFilter.class);
		n.todo(LSProgressEvent.class);
		n.todo(LSResourceResolver.class);
		n.todo(LSSerializer.class);
		n.todo(LSSerializerFilter.class);

		n.todo(DocumentTraversal.class);
		n.todo(Range.class);
		n.todo(RangeException.class);

		n.todo(DocumentTraversal.class);
		n.todo(NodeFilter.class);
		n.todo(NodeIterator.class);
		n.todo(TreeWalker.class);

	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}
}
