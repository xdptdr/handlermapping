package com.github.xdptdr.notes.jee.xmlschema;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.SchemaFactoryConfigurationError;
import javax.xml.validation.SchemaFactoryLoader;
import javax.xml.validation.TypeInfoProvider;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

import com.github.xdptdr.notes.N;

public class Notes {

	private static void notes(N n) {

		n.todo(Schema.class);
		n.todo(SchemaFactory.class);
		n.todo(SchemaFactoryConfigurationError.class);
		n.todo(SchemaFactoryLoader.class);
		n.todo(TypeInfoProvider.class);
		n.todo(Validator.class);
		n.todo(ValidatorHandler.class);

	}

	public static void main(String[] args) {
		N n = new N();
		notes(n);
		n.sumUp();
	}

}
