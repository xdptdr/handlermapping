package com.github.xdptdr.mbwar.jaxb;

import java.awt.Image;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.W3CDomHandler;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;

@XmlRootElement
@XmlSeeAlso({ MyOtherUnusedThingy.class })
public class MyThingy {

	private boolean theBoolean;
	private byte theByte;
	private short theShort;
	private int theInt;
	private long theLong;

	private float theFloat;
	private double theDouble;

	private String theString;
	private BigInteger theBigInteger;
	private BigDecimal theBigDecimal;
	private Calendar theCalendar;
	private Date theDate;
	private QName theQName;
	private URI theURI;
	private XMLGregorianCalendar theXMLGregorianCalendar;
	private Duration theDuration;
	private Object theObject;
	private Image theImage;
	private DataHandler theDataHandler;
	private Source theSource;
	private UUID theUUID;

	private MyOtherThingy theOtherThingy;

	private MyFactoryThingy myFactoryThingy;

	private List<String> theListOfString = new ArrayList<>();
	private Map<String, String> theMapOfStringtoString = new HashMap<>();
	private Set<String> theSetOfString = new HashSet<>();

	private MyEnumThingy theEnumThingy;

	private Map<String, String> attributes = new HashMap<>();

	private MyThingyWithIds myThingyWithIds;

	private MyThingyLists myThingyLists;

	private MyMixedThingy myMixedThingy;

	private MyMimeTypeThingy myMimeTypeThingy;

	private MyXARThingy myXARThingy;

	private MyXIBDThingy myXIBDThingy;

	private ObjectFactory myXEDThingy;

	private MyXJTAThingy myXJTAThingy;

	@XmlElement(defaultValue = "true", name = "daBool", nillable = false, required = false)
	public boolean isTheBoolean() {
		return theBoolean;
	}

	public void setTheBoolean(boolean theBoolean) {
		this.theBoolean = theBoolean;
	}

	public byte getTheByte() {
		return theByte;
	}

	public void setTheByte(byte theByte) {
		this.theByte = theByte;
	}

	public short getTheShort() {
		return theShort;
	}

	public void setTheShort(short theShort) {
		this.theShort = theShort;
	}

	public int getTheInt() {
		return theInt;
	}

	public void setTheInt(int theInt) {
		this.theInt = theInt;
	}

	public long getTheLong() {
		return theLong;
	}

	public void setTheLong(long theLong) {
		this.theLong = theLong;
	}

	@XmlAttribute(name = "lalaFloat")
	public float getTheFloat() {
		return theFloat;
	}

	public void setTheFloat(float theFloat) {
		this.theFloat = theFloat;
	}

	public double getTheDouble() {
		return theDouble;
	}

	public void setTheDouble(double theDouble) {
		this.theDouble = theDouble;
	}

	public String getTheString() {
		return theString;
	}

	public void setTheString(String theString) {
		this.theString = theString;
	}

	public BigInteger getTheBigInteger() {
		return theBigInteger;
	}

	public void setTheBigInteger(BigInteger theBigInteger) {
		this.theBigInteger = theBigInteger;
	}

	public BigDecimal getTheBigDecimal() {
		return theBigDecimal;
	}

	public void setTheBigDecimal(BigDecimal theBigDecimal) {
		this.theBigDecimal = theBigDecimal;
	}

	public Calendar getTheCalendar() {
		return theCalendar;
	}

	public void setTheCalendar(Calendar theCalendar) {
		this.theCalendar = theCalendar;
	}

	public Date getTheDate() {
		return theDate;
	}

	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}

	public QName getTheQName() {
		return theQName;
	}

	public void setTheQName(QName theQName) {
		this.theQName = theQName;
	}

	public URI getTheURI() {
		return theURI;
	}

	public void setTheURI(URI theURI) {
		this.theURI = theURI;
	}

	public XMLGregorianCalendar getTheXMLGregorianCalendar() {
		return theXMLGregorianCalendar;
	}

	public void setTheXMLGregorianCalendar(XMLGregorianCalendar theXMLGregorianCalendar) {
		this.theXMLGregorianCalendar = theXMLGregorianCalendar;
	}

	public Duration getTheDuration() {
		return theDuration;
	}

	public void setTheDuration(Duration theDuration) {
		this.theDuration = theDuration;
	}

	@XmlAnyElement(lax = true, value = W3CDomHandler.class)
	public Object getTheObject() {
		return theObject;
	}

	public void setTheObject(Object theObject) {
		this.theObject = theObject;
	}

	public Image getTheImage() {
		return theImage;
	}

	public void setTheImage(Image theImage) {
		this.theImage = theImage;
	}

	public DataHandler getTheDataHandler() {
		return theDataHandler;
	}

	public void setTheDataHandler(DataHandler theDataHandler) {
		this.theDataHandler = theDataHandler;
	}

	public Source getTheSource() {
		return theSource;
	}

	public void setTheSource(Source theSource) {
		this.theSource = theSource;
	}

	public UUID getTheUUID() {
		return theUUID;
	}

	public void setTheUUID(UUID theUUID) {
		this.theUUID = theUUID;
	}

	public MyOtherThingy getTheOtherThingy() {
		return theOtherThingy;
	}

	public void setTheOtherThingy(MyOtherThingy theOtherThingy) {
		this.theOtherThingy = theOtherThingy;
	}

	@XmlElementWrapper(name = "listWrapper")
	public List<String> getTheListOfString() {
		return theListOfString;
	}

	public void setTheListOfString(List<String> theListOfString) {
		this.theListOfString = theListOfString;
	}

	public Map<String, String> getTheMapOfStringtoString() {
		return theMapOfStringtoString;
	}

	public void setTheMapOfStringtoString(Map<String, String> theMapOfStringtoString) {
		this.theMapOfStringtoString = theMapOfStringtoString;
	}

	public Set<String> getTheSetOfString() {
		return theSetOfString;
	}

	public void setTheSetOfString(Set<String> theSetOfString) {
		this.theSetOfString = theSetOfString;
	}

	public MyEnumThingy getTheEnumThingy() {
		return theEnumThingy;
	}

	public void setTheEnumThingy(MyEnumThingy theEnumThingy) {
		this.theEnumThingy = theEnumThingy;
	}

	public MyFactoryThingy getMyFactoryThingy() {
		return myFactoryThingy;
	}

	public void setMyFactoryThingy(MyFactoryThingy myFactoryThingy) {
		this.myFactoryThingy = myFactoryThingy;

	}

	@XmlAnyAttribute
	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public MyThingyWithIds getMyThingyWithIds() {
		return myThingyWithIds;
	}

	public void setMyThingyWithIds(MyThingyWithIds myThingyWithIds) {
		this.myThingyWithIds = myThingyWithIds;
	}

	public MyThingyLists getMyThingyLists() {
		return myThingyLists;
	}

	public void setMyThingyLists(MyThingyLists myThingyLists) {
		this.myThingyLists = myThingyLists;
	}

	public MyMixedThingy getMyMixedThingy() {
		return myMixedThingy;
	}

	public void setMyMixedThingy(MyMixedThingy myMixedThingy) {
		this.myMixedThingy = myMixedThingy;
	}

	public MyMimeTypeThingy getMyMimeTypeThingy() {
		return myMimeTypeThingy;
	}

	public void setMyMimeTypeThingy(MyMimeTypeThingy myMimeTypeThingy) {
		this.myMimeTypeThingy = myMimeTypeThingy;
	}

	public MyXARThingy getMyXARThingy() {
		return myXARThingy;
	}

	public void setMyXARThingy(MyXARThingy myXARThingy) {
		this.myXARThingy = myXARThingy;
	}

	public MyXIBDThingy getMyXIBDThingy() {
		return myXIBDThingy;
	}

	public void setMyXIBDThingy(MyXIBDThingy myXIBDThingy) {
		this.myXIBDThingy = myXIBDThingy;
	}

	public ObjectFactory getMyXEDThingy() {
		return myXEDThingy;
	}

	public void setMyXEDThingy(ObjectFactory myXEDThingy) {
		this.myXEDThingy = myXEDThingy;
	}

	public MyXJTAThingy getMyXJTAThingy() {
		return myXJTAThingy;
	}

	public void setMyXJTAThingy(MyXJTAThingy myXJTAThingy) {
		this.myXJTAThingy = myXJTAThingy;
	}

}
