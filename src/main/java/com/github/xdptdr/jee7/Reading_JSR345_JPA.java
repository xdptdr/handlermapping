package com.github.xdptdr.jee7;

import java.beans.Introspector;
import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PersistenceException;

public class Reading_JSR345_JPA extends Reading {

	private String string;

	@Override
	public void reading() throws Exception {
		section("1", RS.UNTOUCHED);
		section("1.1", RS.UNTOUCHED);
		section("1.2", RS.UNTOUCHED);
		section("2", RS.UNTOUCHED);
		section("2.1", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class MyEntity {
				}
			}
		});

		/* public or protected no-arg constructor */
		/* must be a top level class */

		/*-
		 * - class must not be final
		 * - methods must not be final
		 * - persistent instance variables msut not be final
		 */

		/*
		 * Entities marked Serializable may be detached and passed by value
		 * through remote interfaces
		 */

		/*-
		 * - inheritance
		 * - polymorphic associations
		 * - polymorphic queries
		 */

		/*-
		 * - abstract classes can be entities
		 * - concrete classes can be entities
		 * - entities may extend non-entity classes
		 * - entities may extend entity classes
		 * - non-entity classes may extend entity classes
		 */

		/*
		 * The persistent state of an entity is represented by instance
		 * variables which must only be access through the entity's methods
		 */

		section("2.2", RS.STARTED);

		/*-
		 * - property access
		 * - field access
		 */

		/* instance variables must not be public */
		/* property accessors must be public or protected */

		/*
		 * for property access, the entity must follow the JavaBeans read/write
		 * conventions
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				Introspector.decapitalize(string);
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				/*
				 * collection values persistent fields can only be of the
				 * following types:
				 */
				Collection.class.getName();
				Set.class.getName();
				List.class.getName();
				Map.class.getName();
			}
		});

		/*
		 * property access + lazy fetching :
		 * 
		 * applications should not directly access the entity state underlying
		 * the property methods of managed instances until after it has been
		 * fetched by the persistence provider
		 */

		/*
		 * Runtime exception in property access leads to transaction rollback
		 * and PersistenceException being thrown
		 */

		PersistenceException.class.getName();

		/*
		 * Property accessor may be overriden, but the ORM metadata should not
		 * be modified
		 */

		dontRun(new NotRunnable() {

			@Override
			public void dontRun() throws Exception {

				Class<?>[] primitiveTypes = new Class<?>[] { int.class, char.class, byte.class, float.class,
						double.class, boolean.class, long.class, short.class };

				List<Class<?>> persistentTypes = new ArrayList<>();
				persistentTypes.addAll(Arrays.asList(primitiveTypes));
				persistentTypes.add(String.class);
				persistentTypes.add(BigInteger.class);
				persistentTypes.add(BigDecimal.class);
				persistentTypes.add(Date.class);
				persistentTypes.add(Calendar.class);
				persistentTypes.add(java.sql.Date.class);
				persistentTypes.add(Time.class);
				persistentTypes.add(Timestamp.class);
				persistentTypes.add(byte[].class);
				persistentTypes.add(Byte[].class);
				persistentTypes.add(char[].class);
				persistentTypes.add(Character[].class);
				persistentTypes.add(Serializable.class);
				// enums
				// entities
				// collection of entities
				// embeddable classes
				// collections of basic types
				// collections of embeddable types
			}
		});

		section("2.2.1", RS.STARTED);

		section("2.3", RS.STARTED);
		section("2.3.1", RS.STARTED);

		/*
		 * default access type is deduced from the placement of annotations, or
		 * the use of the Access annotation
		 */

		Access.class.isAnnotation();
		Transient.class.isAnnotation();

		section("2.3.2", RS.STARTED);

		/*-
		 * - entity class
		 * - mapped superclass
		 * - embeddable class
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				@Access(AccessType.FIELD)
				class MyEntity {

					private String username;

					@Access(AccessType.PROPERTY)
					public String getFoo() {
						return null;
					}

				}

			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				@Access(AccessType.PROPERTY)
				class MyEntity {

					@Access(AccessType.FIELD)
					private String username;

					public String getFoo() {
						return null;
					}
				}
			}
		});

		/* Transient can be used to avoid duplicate persistent mappings */

		section("2.3.3", RS.STARTED);

		section("2.3.4", RS.STARTED);

		/*
		 * Care must be exercised when defining an embeddable class or mapped
		 * superclass which is used both in a context of field access and in a
		 * context of property access and whose access type is not explicitly
		 * specified by means of the Access annotation or XML mapping file.
		 */
		section("2.4", RS.STARTED);

		/* Every entity must have a primary key. */

		/*
		 * The primary key must be defined on the entity class that is the root
		 * of the entity hierarchy or on a mapped superclass that is a (direct
		 * or indirect) superclass of all entity classes in the entity
		 * hierarchy. The primary key must be defined exactly once in an entity
		 * hierarchy.
		 */

		/*
		 * A simple (i.e., non-composite) primary key must correspond to a
		 * single persistent field or property of the entity class. The Id
		 * annotation or id XML element must be used to denote a simple primary
		 * key. See Section 11.1.21.
		 */

		/*
		 * A composite primary key must correspond to either a single persistent
		 * field or property or to a set of such fields or properties as
		 * described below. A primary key class must be defined to represent a
		 * composite primary key. Composite primary keys typically arise when
		 * mapping from legacy databases when the database key is comprised of
		 * several columns. The EmbeddedId or IdClass annotation is used to
		 * denote a composite primary key. See Sections 11.1.17 and 11.1.22.
		 */

		Id.class.isAnnotation();

		EmbeddedId.class.isAnnotation();
		IdClass.class.isAnnotation();

		/*
		 * A simple primary key or a field or property of a composite primary
		 * key should be one of the following types: any Java primitive type;
		 * any primitive wrapper type; java.lang.String; java.util.Date;
		 * java.sql.Date; java.math.BigDecimal; java.math.BigInteger.[ 9] If the
		 * primary key is a composite primary key derived from the primary key
		 * of another entity, the primary key may contain an attribute whose
		 * type is that of the primary key of the referenced entity as described
		 * in Section 2.4.1. Entities whose primary keys use types other than
		 * these will not be portable. If generated primary keys are used, only
		 * integral types will be portable. If java.util.Date is used as a
		 * primary key field or property, the temporal type should be specified
		 * as DATE.
		 */
		section("2.4.1", RS.STARTED);

		/*
		 * The identity of an entity may be derived from the identity of another
		 * entity (the “parent” entity) when the former entity (the “dependent”
		 * entity) is the owner of a many-to-one or one-to-one relationship to
		 * the parent entity and a foreign key maps the relationship from
		 * dependent to parent.
		 * 
		 * If a many-to-one or one-to-one entity relationship corresponds to a
		 * primary key attribute, the entity containing this relationship cannot
		 * be persisted without the relationship having been assigned an entity
		 * since the identity of the entity containing the relationship is
		 * derived from the referenced entity.
		 * 
		 * Derived identities may be captured by means of simple primary keys or
		 * by means of composite primary keys.
		 * 
		 * If the dependent entity class has primary key attributes in addition
		 * to those corresponding to the parent's primary key or if the parent
		 * has a composite primary key, an embedded id or id class must be used
		 * to specify the primary key of the dependent entity. It is not
		 * necessary that parent entity and dependent entity both use embedded
		 * ids or both use id classes to represent composite primary keys when
		 * the parent has a composite key.
		 * 
		 * A dependent entity may have more than one parent entity.
		 */

		section("2.4.1.1", RS.STARTED);
		section("2.4.1.2", RS.STARTED);

		section("2.4.1.3", RS.STARTED);

		/* INTERESTING */

		section("2.5", RS.UNTOUCHED);
		section("2.6", RS.UNTOUCHED);
		section("2.7", RS.UNTOUCHED);
		section("2.7.1", RS.UNTOUCHED);
		section("2.7.2", RS.UNTOUCHED);
		section("2.8", RS.UNTOUCHED);
		section("2.9", RS.UNTOUCHED);
		section("2.10", RS.UNTOUCHED);
		section("2.10.1", RS.UNTOUCHED);
		section("2.10.2", RS.UNTOUCHED);
		section("2.10.3", RS.UNTOUCHED);
		section("2.10.3.1", RS.UNTOUCHED);
		section("2.10.3.2", RS.UNTOUCHED);
		section("2.10.4", RS.UNTOUCHED);
		section("2.10.5", RS.UNTOUCHED);
		section("2.10.5.1", RS.UNTOUCHED);
		section("2.10.5.2", RS.UNTOUCHED);
		section("2.11", RS.UNTOUCHED);
		section("2.11.1", RS.UNTOUCHED);
		section("2.11.2", RS.UNTOUCHED);
		section("2.11.3", RS.UNTOUCHED);
		section("2.12", RS.UNTOUCHED);
		section("2.12.1", RS.UNTOUCHED);
		section("2.12.2", RS.UNTOUCHED);
		section("2.12.3", RS.UNTOUCHED);
		section("2.13", RS.UNTOUCHED);
		section("3", RS.UNTOUCHED);
		section("3.1", RS.UNTOUCHED);
		section("3.1.1", RS.UNTOUCHED);
		section("3.1.2", RS.UNTOUCHED);
		section("3.2", RS.UNTOUCHED);
		section("3.2.1", RS.UNTOUCHED);
		section("3.2.2", RS.UNTOUCHED);
		section("3.2.3", RS.UNTOUCHED);
		section("3.2.4", RS.UNTOUCHED);
		section("3.2.5", RS.UNTOUCHED);
		section("3.2.6", RS.UNTOUCHED);
		section("3.2.7", RS.UNTOUCHED);
		section("3.2.7.1", RS.UNTOUCHED);
		section("3.2.7.2", RS.UNTOUCHED);
		section("3.2.8", RS.UNTOUCHED);
		section("3.2.9", RS.UNTOUCHED);
		section("3.3", RS.UNTOUCHED);
		section("3.3.1", RS.UNTOUCHED);
		section("3.3.2", RS.UNTOUCHED);
		section("3.3.3", RS.UNTOUCHED);
		section("3.4", RS.UNTOUCHED);
		section("3.4.1", RS.UNTOUCHED);
		section("3.4.2", RS.UNTOUCHED);
		section("3.4.3", RS.UNTOUCHED);
		section("3.4.4", RS.UNTOUCHED);
		section("3.4.4.1", RS.UNTOUCHED);
		section("3.4.4.2", RS.UNTOUCHED);
		section("3.4.4.3", RS.UNTOUCHED);
		section("3.4.5", RS.UNTOUCHED);
		section("3.5", RS.UNTOUCHED);
		section("3.5.1", RS.UNTOUCHED);
		section("3.5.2", RS.UNTOUCHED);
		section("3.5.3", RS.UNTOUCHED);
		section("3.5.4", RS.UNTOUCHED);
		section("3.5.5", RS.UNTOUCHED);
		section("3.5.6", RS.UNTOUCHED);
		section("3.5.7", RS.UNTOUCHED);
		section("3.5.8", RS.UNTOUCHED);
		section("3.5.8.1", RS.UNTOUCHED);
		section("3.5.8.2", RS.UNTOUCHED);
		section("3.6", RS.UNTOUCHED);
		section("3.6.1", RS.UNTOUCHED);
		section("3.6.1.1", RS.UNTOUCHED);
		section("3.6.1.2", RS.UNTOUCHED);
		section("", RS.UNTOUCHED);
		section("3.6.2", RS.UNTOUCHED);
		section("3.7", RS.UNTOUCHED);
		section("3.7.1", RS.UNTOUCHED);
		section("3.7.2", RS.UNTOUCHED);
		section("3.7.3", RS.UNTOUCHED);
		section("3.7.4", RS.UNTOUCHED);
		section("3.7.4.1", RS.UNTOUCHED);
		section("3.7.4.2", RS.UNTOUCHED);
		section("3.8", RS.UNTOUCHED);
		section("3.9", RS.UNTOUCHED);
		section("3.9.1", RS.UNTOUCHED);
		section("3.9.2", RS.UNTOUCHED);
		section("3.10", RS.UNTOUCHED);
		section("3.10.1", RS.UNTOUCHED);
		section("3.10.2", RS.UNTOUCHED);
		section("3.10.3", RS.UNTOUCHED);
		section("3.10.", RS.UNTOUCHED);
		section("3.10.5", RS.UNTOUCHED);
		section("3.10.6", RS.UNTOUCHED);
		section("3.10.7", RS.UNTOUCHED);
		section("3.10.7.1", RS.UNTOUCHED);
		section("3.10.8", RS.UNTOUCHED);
		section("3.10.9", RS.UNTOUCHED);
		section("3.10.10", RS.UNTOUCHED);
		section("3.10.11", RS.UNTOUCHED);
		section("3.10.12", RS.UNTOUCHED);
		section("3.10.13", RS.UNTOUCHED);
		section("3.10.14", RS.UNTOUCHED);
		section("3.10.15", RS.UNTOUCHED);
		section("3.10.16", RS.UNTOUCHED);
		section("3.10.16.1", RS.UNTOUCHED);
		section("3.10.16.2", RS.UNTOUCHED);
		section("3.10.16.2.1", RS.UNTOUCHED);
		section("3.10.16.2.2", RS.UNTOUCHED);
		section("3.10.16.3", RS.UNTOUCHED);
		section("3.10.16.4", RS.UNTOUCHED);
		section("3.10.17", RS.UNTOUCHED);
		section("3.10.17.1", RS.UNTOUCHED);
		section("3.10.17.2", RS.UNTOUCHED);
		section("3.10.17.3", RS.UNTOUCHED);
		section("3.11", RS.UNTOUCHED);
		section("4", RS.UNTOUCHED);
		section("4.1", RS.UNTOUCHED);
		section("4.2", RS.UNTOUCHED);
		section("4.2.1", RS.UNTOUCHED);
		section("4.2.2", RS.UNTOUCHED);
		section("4.3", RS.UNTOUCHED);
		section("4.3.1", RS.UNTOUCHED);
		section("4.3.2", RS.UNTOUCHED);
		section("4.4", RS.UNTOUCHED);
		section("4.4.1", RS.UNTOUCHED);
		section("4.4.2", RS.UNTOUCHED);
		section("4.4.3", RS.UNTOUCHED);
		section("4.4.4", RS.UNTOUCHED);
		section("4.4.4.1", RS.UNTOUCHED);
		section("4.4.5", RS.UNTOUCHED);
		section("4.4.5.1", RS.UNTOUCHED);
		section("4.4.5.2", RS.UNTOUCHED);
		section("4.4.5.3", RS.UNTOUCHED);
		section("4.4.6", RS.UNTOUCHED);
		section("4.4.7", RS.UNTOUCHED);
		section("4.4.8", RS.UNTOUCHED);
		section("4.4.9", RS.UNTOUCHED);
		section("4.5", RS.UNTOUCHED);
		section("4.6", RS.UNTOUCHED);
		section("4.6.1", RS.UNTOUCHED);
		section("4.6.2", RS.UNTOUCHED);
		section("4.6.3", RS.UNTOUCHED);
		section("4.6.4", RS.UNTOUCHED);
		section("4.6.4.1", RS.UNTOUCHED);
		section("4.6.4.2", RS.UNTOUCHED);
		section("4.6.5", RS.UNTOUCHED);
		section("4.6.6", RS.UNTOUCHED);
		section("4.6.7", RS.UNTOUCHED);
		section("4.6.8", RS.UNTOUCHED);
		section("4.6.9", RS.UNTOUCHED);
		section("4.6.10", RS.UNTOUCHED);
		section("4.6.11", RS.UNTOUCHED);
		section("4.6.12", RS.UNTOUCHED);
		section("4.6.13", RS.UNTOUCHED);
		section("4.6.14", RS.UNTOUCHED);
		section("4.6.15", RS.UNTOUCHED);
		section("4.6.16", RS.UNTOUCHED);
		section("4.6.17", RS.UNTOUCHED);
		section("4.6.17.1", RS.UNTOUCHED);
		section("4.6.17.2", RS.UNTOUCHED);
		section("4.6.17.2.1", RS.UNTOUCHED);
		section("4.6.17.2.2", RS.UNTOUCHED);
		section("4.6.17.2.3", RS.UNTOUCHED);
		section("4.6.17.3", RS.UNTOUCHED);
		section("4.6.17.4", RS.UNTOUCHED);
		section("4.6.17.5", RS.UNTOUCHED);
		section("4.7", RS.UNTOUCHED);
		section("4.8", RS.UNTOUCHED);
		section("4.8.1", RS.UNTOUCHED);
		section("4.8.2", RS.UNTOUCHED);
		section("4.8.3", RS.UNTOUCHED);
		section("4.8.4", RS.UNTOUCHED);
		section("4.8.5", RS.UNTOUCHED);
		section("4.8.5.1", RS.UNTOUCHED);
		section("4.8.6", RS.UNTOUCHED);
		section("4.9", RS.UNTOUCHED);
		section("4.10", RS.UNTOUCHED);
		section("4.11", RS.UNTOUCHED);
		section("4.12", RS.UNTOUCHED);
		section("4.13", RS.UNTOUCHED);
		section("4.13.1", RS.UNTOUCHED);
		section("4.13.2", RS.UNTOUCHED);
		section("4.13.3", RS.UNTOUCHED);
		section("4.14", RS.UNTOUCHED);
		section("5", RS.UNTOUCHED);
		section("5.1", RS.UNTOUCHED);
		section("5.1.1", RS.UNTOUCHED);
		section("5.1.2", RS.UNTOUCHED);
		section("5.1.3", RS.UNTOUCHED);
		section("5.1.4", RS.UNTOUCHED);
		section("5.1.5", RS.UNTOUCHED);
		section("5.1.6", RS.UNTOUCHED);
		section("5.1.7", RS.UNTOUCHED);
		section("5.1.8", RS.UNTOUCHED);
		section("5.1.9", RS.UNTOUCHED);
		section("5.1.10", RS.UNTOUCHED);
		section("5.1.11", RS.UNTOUCHED);
		section("5.1.12", RS.UNTOUCHED);
		section("5.1.13", RS.UNTOUCHED);
		section("5.1.14", RS.UNTOUCHED);
		section("5.1.15", RS.UNTOUCHED);
		section("5.1.16", RS.UNTOUCHED);
		section("5.1.17", RS.UNTOUCHED);
		section("6", RS.UNTOUCHED);
		section("6.1", RS.UNTOUCHED);
		section("6.2", RS.UNTOUCHED);
		section("6.2.1", RS.UNTOUCHED);
		section("6.2.1.1", RS.UNTOUCHED);
		section("6.2.1.2", RS.UNTOUCHED);
		section("6.2.2", RS.UNTOUCHED);
		section("6.3", RS.UNTOUCHED);
		section("6.3.1", RS.UNTOUCHED);
		section("6.3.2", RS.UNTOUCHED);
		section("6.3.3", RS.UNTOUCHED);
		section("6.3.4", RS.UNTOUCHED);
		section("6.3.5", RS.UNTOUCHED);
		section("6.3.6", RS.UNTOUCHED);
		section("6.3.7", RS.UNTOUCHED);
		section("6.3.8", RS.UNTOUCHED);
		section("6.3.9", RS.UNTOUCHED);
		section("6.3.10", RS.UNTOUCHED);
		section("6.3.11", RS.UNTOUCHED);
		section("6.3.12", RS.UNTOUCHED);
		section("6.3.13", RS.UNTOUCHED);
		section("6.3.14", RS.UNTOUCHED);
		section("6.3.15", RS.UNTOUCHED);
		section("6.3.16", RS.UNTOUCHED);
		section("6.3.17", RS.UNTOUCHED);
		section("6.3.18", RS.UNTOUCHED);
		section("6.3.19", RS.UNTOUCHED);
		section("6.3.20", RS.UNTOUCHED);
		section("6.3.21", RS.UNTOUCHED);
		section("6.3.22", RS.UNTOUCHED);
		section("6.3.23", RS.UNTOUCHED);
		section("6.3.24", RS.UNTOUCHED);
		section("6.3.25", RS.UNTOUCHED);
		section("6.4", RS.UNTOUCHED);
		section("6.5", RS.UNTOUCHED);
		section("6.5.1", RS.UNTOUCHED);
		section("6.5.2", RS.UNTOUCHED);
		section("6.5.3", RS.UNTOUCHED);
		section("6.5.4", RS.UNTOUCHED);
		section("6.5.5", RS.UNTOUCHED);
		section("6.5.6", RS.UNTOUCHED);
		section("6.5.7", RS.UNTOUCHED);
		section("6.5.8", RS.UNTOUCHED);
		section("6.5.8.1", RS.UNTOUCHED);
		section("6.5.8.1", RS.UNTOUCHED);
		section("6.5.9", RS.UNTOUCHED);
		section("6.5.10", RS.UNTOUCHED);
		section("6.5.11", RS.UNTOUCHED);
		section("6.5.11.1", RS.UNTOUCHED);
		section("6.5.12", RS.UNTOUCHED);
		section("6.5.13", RS.UNTOUCHED);
		section("6.5.14", RS.UNTOUCHED);
		section("6.5.15", RS.UNTOUCHED);
		section("6.6", RS.UNTOUCHED);
		section("6.7", RS.UNTOUCHED);
		section("6.8", RS.UNTOUCHED);
		section("6.9", RS.UNTOUCHED);
		section("7", RS.UNTOUCHED);
		section("7.1", RS.UNTOUCHED);
		section("7.2", RS.UNTOUCHED);
		section("7.2.1", RS.UNTOUCHED);
		section("7.2.2", RS.UNTOUCHED);
		section("7.3", RS.UNTOUCHED);
		section("7.3.1", RS.UNTOUCHED);
		section("7.3.2", RS.UNTOUCHED);
		section("7.4", RS.UNTOUCHED);
		section("7.5", RS.UNTOUCHED);
		section("7.5.1", RS.UNTOUCHED);
		section("7.5.2", RS.UNTOUCHED);
		section("7.5.3", RS.UNTOUCHED);
		section("7.5.4", RS.UNTOUCHED);
		section("7.6", RS.UNTOUCHED);
		section("7.6.1", RS.UNTOUCHED);
		section("7.6.2", RS.UNTOUCHED);
		section("7.6.3", RS.UNTOUCHED);
		section("7.6.4", RS.UNTOUCHED);
		section("7.6.5", RS.UNTOUCHED);
		section("7.6.5.1", RS.UNTOUCHED);
		section("7.6.5.2", RS.UNTOUCHED);
		section("7.7", RS.UNTOUCHED);
		section("7.7.1", RS.UNTOUCHED);
		section("7.7.1.1", RS.UNTOUCHED);
		section("7.7.1.2", RS.UNTOUCHED);
		section("7.7.1.3", RS.UNTOUCHED);
		section("7.7.1.4", RS.UNTOUCHED);
		section("7.8", RS.UNTOUCHED);
		section("7.8.1", RS.UNTOUCHED);
		section("7.8.2", RS.UNTOUCHED);
		section("7.9", RS.UNTOUCHED);
		section("7.9.1", RS.UNTOUCHED);
		section("7.9.2", RS.UNTOUCHED);
		section("7.10", RS.UNTOUCHED);
		section("7.11", RS.UNTOUCHED);
		section("8", RS.UNTOUCHED);
		section("8.1", RS.UNTOUCHED);
		section("8.2", RS.UNTOUCHED);
		section("8.2.1", RS.UNTOUCHED);
		section("8.2.1.1", RS.UNTOUCHED);
		section("8.2.1.2", RS.UNTOUCHED);
		section("8.2.1.3", RS.UNTOUCHED);
		section("8.2.1.4", RS.UNTOUCHED);
		section("8.2.1.5", RS.UNTOUCHED);
		section("8.2.1.6", RS.UNTOUCHED);
		section("8.2.1.6.1", RS.UNTOUCHED);
		section("8.2.1.6.2", RS.UNTOUCHED);
		section("8.2.1.6.3", RS.UNTOUCHED);
		section("8.2.1.6.4", RS.UNTOUCHED);
		section("8.2.1.7", RS.UNTOUCHED);
		section("8.2.1.8", RS.UNTOUCHED);
		section("8.2.1.9", RS.UNTOUCHED);
		section("8.2.1.10", RS.UNTOUCHED);
		section("8.2.2", RS.UNTOUCHED);
		section("8.3", RS.UNTOUCHED);
		section("9", RS.UNTOUCHED);
		section("9.1", RS.UNTOUCHED);
		section("9.2", RS.UNTOUCHED);
		section("9.2.1", RS.UNTOUCHED);
		section("9.3", RS.UNTOUCHED);
		section("9.3.1", RS.UNTOUCHED);
		section("9.3.2", RS.UNTOUCHED);
		section("9.4", RS.UNTOUCHED);
		section("9.4.1", RS.UNTOUCHED);
		section("9.5", RS.UNTOUCHED);
		section("9.5.1", RS.UNTOUCHED);
		section("9.5.2", RS.UNTOUCHED);
		section("9.6", RS.UNTOUCHED);
		section("9.6.1", RS.UNTOUCHED);
		section("9.7", RS.UNTOUCHED);
		section("9.8", RS.UNTOUCHED);
		section("9.8.1", RS.UNTOUCHED);
		section("10", RS.UNTOUCHED);
		section("10.1", RS.UNTOUCHED);
		section("10.2", RS.UNTOUCHED);
		section("10.3", RS.UNTOUCHED);
		section("10.3.1", RS.UNTOUCHED);
		section("10.3.2", RS.UNTOUCHED);
		section("10.3.3", RS.UNTOUCHED);
		section("10.4", RS.UNTOUCHED);
		section("10.4.1", RS.UNTOUCHED);
		section("10.4.2", RS.UNTOUCHED);
		section("10.4.3", RS.UNTOUCHED);
		section("10.4.4", RS.UNTOUCHED);
		section("10.5", RS.UNTOUCHED);
		section("10.5.1", RS.UNTOUCHED);
		section("10.5.2", RS.UNTOUCHED);
		section("10.6", RS.UNTOUCHED);
		section("11", RS.UNTOUCHED);
		section("11.1", RS.UNTOUCHED);
		section("11.1.1", RS.UNTOUCHED);
		section("11.1.2", RS.UNTOUCHED);
		section("11.1.3", RS.UNTOUCHED);
		section("11.1.4", RS.UNTOUCHED);
		section("11.1.5", RS.UNTOUCHED);
		section("11.1.6", RS.UNTOUCHED);
		section("11.1.7", RS.UNTOUCHED);
		section("11.1.8", RS.UNTOUCHED);
		section("11.1.9", RS.UNTOUCHED);
		section("11.1.10", RS.UNTOUCHED);
		section("11.1.11", RS.UNTOUCHED);
		section("11.1.12", RS.UNTOUCHED);
		section("11.1.13", RS.UNTOUCHED);
		section("11.1.14", RS.UNTOUCHED);
		section("11.1.15", RS.UNTOUCHED);
		section("11.1.16", RS.UNTOUCHED);
		section("11.1.17", RS.UNTOUCHED);
		section("11.1.18", RS.UNTOUCHED);
		section("11.1.19", RS.UNTOUCHED);
		section("11.1.20", RS.UNTOUCHED);
		section("11.1.21", RS.UNTOUCHED);
		section("11.1.22", RS.UNTOUCHED);
		section("11.1.23", RS.UNTOUCHED);
		section("11.1.24", RS.UNTOUCHED);
		section("11.1.25", RS.UNTOUCHED);
		section("11.1.26", RS.UNTOUCHED);
		section("11.1.27", RS.UNTOUCHED);
		section("11.1.28", RS.UNTOUCHED);
		section("11.1.29", RS.UNTOUCHED);
		section("11.1.30", RS.UNTOUCHED);
		section("11.1.31", RS.UNTOUCHED);
		section("11.1.32", RS.UNTOUCHED);
		section("11.1.33", RS.UNTOUCHED);
		section("11.1.34", RS.UNTOUCHED);
		section("11.1.35", RS.UNTOUCHED);
		section("11.1.36", RS.UNTOUCHED);
		section("11.1.37", RS.UNTOUCHED);
		section("11.1.38", RS.UNTOUCHED);
		section("11.1.39", RS.UNTOUCHED);
		section("11.1.40", RS.UNTOUCHED);
		section("11.1.41", RS.UNTOUCHED);
		section("11.1.42", RS.UNTOUCHED);
		section("11.1.43", RS.UNTOUCHED);
		section("11.1.44", RS.UNTOUCHED);
		section("11.1.45", RS.UNTOUCHED);
		section("11.1.46", RS.UNTOUCHED);
		section("11.1.47", RS.UNTOUCHED);
		section("11.1.48", RS.UNTOUCHED);
		section("11.1.49", RS.UNTOUCHED);
		section("11.1.50", RS.UNTOUCHED);
		section("11.1.51", RS.UNTOUCHED);
		section("11.1.52", RS.UNTOUCHED);
		section("11.1.53", RS.UNTOUCHED);
		section("11.1.54", RS.UNTOUCHED);
		section("11.2", RS.UNTOUCHED);
		section("11.2.1", RS.UNTOUCHED);
		section("11.2.1.1", RS.UNTOUCHED);
		section("11.2.1.2", RS.UNTOUCHED);
		section("11.2.1.3", RS.UNTOUCHED);
		section("11.2.1.4", RS.UNTOUCHED);
		section("11.2.1.5", RS.UNTOUCHED);
		section("11.2.1.6", RS.UNTOUCHED);
		section("11.2.2", RS.UNTOUCHED);
		section("11.2.2.1", RS.UNTOUCHED);
		section("11.2.2.2", RS.UNTOUCHED);
		section("11.2.2.3", RS.UNTOUCHED);
		section("11.2.2.4", RS.UNTOUCHED);
		section("11.2.2.5", RS.UNTOUCHED);
		section("11.2.2.6", RS.UNTOUCHED);
		section("11.2.2.7", RS.UNTOUCHED);
		section("11.2.2.8", RS.UNTOUCHED);
		section("11.2.3", RS.UNTOUCHED);
		section("11.2.3.1", RS.UNTOUCHED);
		section("11.2.3.2", RS.UNTOUCHED);
		section("11.2.3.3", RS.UNTOUCHED);
		section("11.2.4", RS.UNTOUCHED);
		section("11.2.4.1", RS.UNTOUCHED);
		section("11.2.4.2", RS.UNTOUCHED);
		section("11.2.4.3", RS.UNTOUCHED);
		section("11.2.4.4", RS.UNTOUCHED);
		section("11.2.5", RS.UNTOUCHED);
		section("11.2.5.1", RS.UNTOUCHED);
		section("11.2.5.2", RS.UNTOUCHED);
		section("11.2.5.3", RS.UNTOUCHED);
		section("11.3", RS.UNTOUCHED);
		section("11.3.1", RS.UNTOUCHED);
		section("11.3.2", RS.UNTOUCHED);
		section("12", RS.UNTOUCHED);
		section("12.1", RS.UNTOUCHED);
		section("12.2", RS.UNTOUCHED);
		section("12.2.1", RS.UNTOUCHED);
		section("12.2.1.1", RS.UNTOUCHED);
		section("12.2.1.2", RS.UNTOUCHED);
		section("12.2.1.3", RS.UNTOUCHED);
		section("12.2.1.4", RS.UNTOUCHED);
		section("12.2.1.5", RS.UNTOUCHED);
		section("12.2.1.6", RS.UNTOUCHED);
		section("12.2.2", RS.UNTOUCHED);
		section("12.2.2.1", RS.UNTOUCHED);
		section("12.2.2.2", RS.UNTOUCHED);
		section("12.2.2.3", RS.UNTOUCHED);
		section("12.2.2.4", RS.UNTOUCHED);
		section("12.2.2.5", RS.UNTOUCHED);
		section("12.2.2.6", RS.UNTOUCHED);
		section("12.2.2.7", RS.UNTOUCHED);
		section("12.2.2.8", RS.UNTOUCHED);
		section("12.2.2.9", RS.UNTOUCHED);
		section("12.2.2.10", RS.UNTOUCHED);
		section("12.2.2.11", RS.UNTOUCHED);
		section("12.2.2.12", RS.UNTOUCHED);
		section("12.2.2.13", RS.UNTOUCHED);
		section("12.2.2.14", RS.UNTOUCHED);
		section("12.2.3", RS.UNTOUCHED);
		section("12.2.3.1", RS.UNTOUCHED);
		section("12.2.3.2", RS.UNTOUCHED);
		section("12.2.3.3", RS.UNTOUCHED);
		section("12.2.3.4", RS.UNTOUCHED);
		section("12.2.3.5", RS.UNTOUCHED);
		section("12.2.3.6", RS.UNTOUCHED);
		section("12.2.3.7", RS.UNTOUCHED);
		section("12.2.3.8", RS.UNTOUCHED);
		section("12.2.3.9", RS.UNTOUCHED);
		section("12.2.3.10", RS.UNTOUCHED);
		section("12.2.3.11", RS.UNTOUCHED);
		section("12.2.3.12", RS.UNTOUCHED);
		section("12.2.3.13", RS.UNTOUCHED);
		section("12.2.3.14", RS.UNTOUCHED);
		section("12.2.3.15", RS.UNTOUCHED);
		section("12.2.3.16", RS.UNTOUCHED);
		section("12.2.3.17", RS.UNTOUCHED);
		section("12.2.3.18", RS.UNTOUCHED);
		section("12.2.3.19", RS.UNTOUCHED);
		section("12.2.3.20", RS.UNTOUCHED);
		section("12.2.3.21", RS.UNTOUCHED);
		section("12.2.3.22", RS.UNTOUCHED);
		section("12.2.3.23", RS.UNTOUCHED);
		section("12.2.3.24", RS.UNTOUCHED);
		section("12.2.3.25", RS.UNTOUCHED);
		section("12.2.3.26", RS.UNTOUCHED);
		section("12.2.3.26.1", RS.UNTOUCHED);
		section("12.2.3.26.2", RS.UNTOUCHED);
		section("12.2.3.26.3", RS.UNTOUCHED);
		section("12.2.3.26.4", RS.UNTOUCHED);
		section("12.2.3.26.5", RS.UNTOUCHED);
		section("12.2.3.26.6", RS.UNTOUCHED);
		section("12.2.3.26.7", RS.UNTOUCHED);
		section("12.2.3.26.8", RS.UNTOUCHED);
		section("12.2.3.26.9", RS.UNTOUCHED);
		section("12.2.3.26.10", RS.UNTOUCHED);
		section("12.2.3.26.11", RS.UNTOUCHED);
		section("12.2.4", RS.UNTOUCHED);
		section("12.2.4.1", RS.UNTOUCHED);
		section("12.2.4.2", RS.UNTOUCHED);
		section("12.2.4.3", RS.UNTOUCHED);
		section("12.2.4.4", RS.UNTOUCHED);
		section("12.2.4.5", RS.UNTOUCHED);
		section("12.2.4.6", RS.UNTOUCHED);
		section("12.2.4.7", RS.UNTOUCHED);
		section("12.2.4.8", RS.UNTOUCHED);
		section("12.2.4.8.1", RS.UNTOUCHED);
		section("12.2.4.8.2", RS.UNTOUCHED);
		section("12.2.4.8.3", RS.UNTOUCHED);
		section("12.2.4.8.4", RS.UNTOUCHED);
		section("12.2.4.8.5", RS.UNTOUCHED);
		section("12.2.4.8.6", RS.UNTOUCHED);
		section("12.2.4.8.7", RS.UNTOUCHED);
		section("12.2.4.8.8", RS.UNTOUCHED);
		section("12.2.4.8.9", RS.UNTOUCHED);
		section("12.2.4.8.10", RS.UNTOUCHED);
		section("12.2.4.8.11", RS.UNTOUCHED);
		section("12.2.5", RS.UNTOUCHED);
		section("12.2.5.1", RS.UNTOUCHED);
		section("12.2.5.2", RS.UNTOUCHED);
		section("12.2.5.3", RS.UNTOUCHED);
		section("12.2.5.3.1", RS.UNTOUCHED);
		section("12.2.5.3.2", RS.UNTOUCHED);
		section("12.2.5.3.3", RS.UNTOUCHED);
		section("12.2.5.3.4", RS.UNTOUCHED);
		section("12.2.5.3.5", RS.UNTOUCHED);
		section("12.2.5.3.6", RS.UNTOUCHED);
		section("12.2.5.3.7", RS.UNTOUCHED);
		section("12.2.5.3.8", RS.UNTOUCHED);
		section("12.3", RS.UNTOUCHED);
		section("13", RS.UNTOUCHED);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
