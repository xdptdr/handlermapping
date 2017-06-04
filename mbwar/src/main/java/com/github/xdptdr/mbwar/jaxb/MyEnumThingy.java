package com.github.xdptdr.mbwar.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum(Integer.class)
public enum MyEnumThingy {
	@XmlEnumValue("1")
	THINGY,

	@XmlEnumValue("2")
	OTHER_THINGY
}
