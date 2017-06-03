package com.github.xdptdr.jee7;

import java.beans.Introspector;
import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeConverter;
import javax.persistence.AttributeNode;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityGraph;
import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.FetchType;
import javax.persistence.FlushModeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.LockModeType;
import javax.persistence.LockTimeoutException;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.MapKeyJoinColumns;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.PersistenceUtil;
import javax.persistence.PessimisticLockException;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.RollbackException;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Subgraph;
import javax.persistence.SynchronizationType;
import javax.persistence.Table;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

public class Reading_JSR345_JPA extends Reading {

	private String string;
	private EntityManager entityManager;
	private Object entity;
	private Class entityClass;
	private Object primaryKey;
	private LockModeType lockMode;
	private Map properties;
	private FlushModeType flushMode;
	private boolean b;
	private String propertyName;
	private Object propertyValue;
	private CriteriaDelete deleteQuery;
	private CriteriaQuery criteriaQuery;
	private String qlString;
	private CriteriaUpdate updateQuery;
	private Class resultClass;
	private Query query;
	private TypedQuery<Object> typedQuery;
	private String queryName;
	private String sqlString;
	private Class resultSetMapping;
	private StoredProcedureQuery storedProcedureQuery;
	private String procedureName;
	private Class resultClass1;
	private Class resultClass2;
	private String resultSetMapping2;
	private String resultSetMapping1;
	private Class clazz;
	private Object delegate;
	private EntityTransaction entityTransaction;
	private EntityManagerFactory entityManagerFactory;
	private CriteriaBuilder criteriaBuilder;
	private Metamodel metamodel;
	private EntityGraph<?> entityGraph;
	private String graphName;
	private List<EntityGraph<? super Object>> entityGraphs;
	private PersistenceUtil persistenceUtil;
	private PersistenceUnitUtil persistenceUnitUtil;

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

		// 1.a

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Employee {
					@Id
					long empId;
					String empName;
				}

				class DependentId {
					String name;
					long emp;
				}

				@Entity
				@IdClass(DependentId.class)
				class Dependent {
					@Id
					String name;
					@Id
					@ManyToOne
					Employee emp;
				}
			}
		});

		// 1.b

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Employee {
					@Id
					long empId;
					String empName;
				}

				@Embeddable
				class DependentId {
					String name;
					long empPK;
				}

				@Entity
				class Dependent {

					@EmbeddedId
					DependentId id;

					@MapsId("empPK")
					@ManyToOne
					Employee emp;
				}
			}
		});

		// 2.a

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				class EmployeeId {
					String firstName;
					String lastName;
				}

				@Entity
				@IdClass(EmployeeId.class)
				class Employee {
					@Id
					String firstName;
					@Id
					String lastName;
				}

				class DependentId {
					String name;
					EmployeeId emp;
				}

				@Entity
				@IdClass(DependentId.class)
				class Dependent {
					@Id
					String name;

					@Id
					@JoinColumns({ @JoinColumn(name = "FK1", referencedColumnName = "firstName"),
							@JoinColumn(name = "FK2", referencedColumnName = "lastName") })
					@ManyToOne
					Employee emp;
				}
			}
		});

		// 2.b

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				class EmployeeId {
					String firstName;
					String lastName;
				}

				@Entity
				@IdClass(EmployeeId.class)
				class Employee {
					@Id
					String firstName;
					@Id
					String lastName;
				}

				@Embeddable
				class DependentId {
					String name;
					EmployeeId empPK;
				}

				@Entity
				class Dependent {

					@EmbeddedId
					DependentId id;

					@MapsId("empPK")
					@JoinColumns({ @JoinColumn(name = "FK1", referencedColumnName = "firstName"),
							@JoinColumn(name = "FK2", referencedColumnName = "lastName") })
					@ManyToOne
					Employee emp;
				}
			}
		});

		// 3.a

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				@Embeddable
				class EmployeeId {
					String firstName;
					String lastName;
				}

				@Entity
				class Employee {
					@EmbeddedId
					EmployeeId empId;
				}

				class DependentId {
					String name;
					EmployeeId emp;
				}

				@Entity
				@IdClass(DependentId.class)
				class Dependent {
					@Id
					String name;

					@Id
					@JoinColumns({ @JoinColumn(name = "FK1", referencedColumnName = "firstName"),
							@JoinColumn(name = "FK2", referencedColumnName = "lastName") })
					@ManyToOne
					Employee emp;
				}
			}
		});

		// 3.b

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				@Embeddable
				class EmployeeId {
					String firstName;
					String lastName;
				}

				@Entity
				class Employee {
					@EmbeddedId
					EmployeeId empId;
				}

				@Embeddable
				class DependentId {
					String name;
					EmployeeId empPK;
				}

				@Entity
				class Dependent {

					@EmbeddedId
					DependentId id;

					@MapsId("empPK")
					@JoinColumns({ @JoinColumn(name = "FK1", referencedColumnName = "firstName"),
							@JoinColumn(name = "FK2", referencedColumnName = "lastName") })
					@ManyToOne
					Employee emp;
				}
			}
		});

		// 4.a

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				@Entity
				class Person {
					@Id
					String ssn;
				}

				@Entity
				class MedicalHistory {
					@Id
					@OneToOne
					@JoinColumn(name = "FK")
					Person patient;
				}
			}
		});

		// 4.b

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				@Entity
				class Person {
					@Id
					String ssn;
				}

				@Entity
				class MedicalHistory {

					@Id
					String id;

					@MapsId
					@JoinColumn(name = "FK")
					@OneToOne
					Person patient;
				}
			}
		});

		// 5.a

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				class PersonId {
					String firstName;
					String lastName;
				}

				@Entity
				@IdClass(PersonId.class)
				class Person {
					@Id
					String firstName;
					@Id
					String lastName;
				}

				@Entity
				class MedicalHistory {
					@Id
					@OneToOne
					@JoinColumn(name = "FK")
					Person patient;
				}
			}
		});

		// 5.b

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				class PersonId {
					String firstName;
					String lastName;
				}

				@Entity
				@IdClass(PersonId.class)
				class Person {
					@Id
					String firstName;
					@Id
					String lastName;
				}

				@Entity
				class MedicalHistory {
					@EmbeddedId
					PersonId id;

					@MapsId
					@JoinColumns({ @JoinColumn(name = "FK1", referencedColumnName = "firstName"),
							@JoinColumn(name = "FK2", referencedColumnName = "lastName") })
					@OneToOne
					Person patient;
				}
			}
		});

		// 6.a

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				@Embeddable
				class PersonId {
					String firstName;
					String lastName;
				}

				@Entity
				@IdClass(PersonId.class)
				class Person {
					@EmbeddedId
					PersonId id;
				}

				@Entity
				@IdClass(PersonId.class)
				class MedicalHistory {
					@Id
					@OneToOne
					@JoinColumns({ @JoinColumn(name = "FK1", referencedColumnName = "firstName"),
							@JoinColumn(name = "FK2", referencedColumnName = "lastName") })
					@JoinColumn(name = "FK")
					Person patient;
				}
			}
		});

		// 6.b

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				@Embeddable
				class PersonId {
					String firstName;
					String lastName;
				}

				@Entity
				@IdClass(PersonId.class)
				class Person {
					@EmbeddedId
					PersonId id;
				}

				@Entity
				class MedicalHistory {
					@EmbeddedId
					PersonId id;

					@MapsId
					@JoinColumns({ @JoinColumn(name = "FK1", referencedColumnName = "firstName"),
							@JoinColumn(name = "FK2", referencedColumnName = "lastName") })
					@OneToOne
					Person patient;
				}
			}
		});

		section("2.5", RS.STARTED);

		/*
		 * An entity may use other fine-grained classes to represent entity
		 * state.
		 * 
		 * Instances of these classes, unlike entity instances, do not have
		 * persistent identity of their own. Instead, they exist only as part of
		 * the state of the entity to which they belong.
		 * 
		 * An entity may have collections of embeddables as well as
		 * single-valued embeddable attributes.
		 * 
		 * Embeddables may also be used as map keys and map values.
		 * 
		 * Embedded objects belong strictly to their owning entity, and are not
		 * sharable across persistent entities.
		 * 
		 * Attempting to share an embedded object across entities has undefined
		 * semantics.
		 */

		/* embeddable classes are not annotated as @Entity */

		/*
		 * Embeddable classes must be annotated as @Embeddable or denoted in the
		 * XML descriptor as such.
		 */

		/*
		 * An embeddable class may be used to represent the state of another
		 * embeddable class.
		 * 
		 * An embeddable class (including an embeddable class within another
		 * embeddable class) may contain a collection of a basic type or other
		 * embeddable class.
		 */

		/*
		 * An embeddable class may contain a relationship to an entity or
		 * collection of entities. Since instances of embeddable classes
		 * themselves have no persistent identity, the relationship from the
		 * referenced entity is to the entity that contains the embeddable
		 * instance(s) and not to the embeddable itself.
		 * 
		 * An embeddable class that is used as an embedded id or as a map key
		 * must not contain such a relationship.
		 */

		section("2.6", RS.STARTED);

		/*
		 * A persistent field or property of an entity or embeddable class may
		 * correspond to a collection of a basic type or embeddable class
		 * (“element collection”). Such a collection, when specified as such by
		 * the ElementCollection annotation, is mapped by means of a collection
		 * table, as defined in Section 11.1.8. If the ElementCollection
		 * annotation (or XML equivalent) is not specified for the
		 * collection-valued field or property, the rules of Section 2.8 apply.
		 */

		/*
		 * An embeddable class (including an embeddable class within another
		 * embeddable class) that is contained within an element collection must
		 * not contain an element collection, nor may it contain a relationship
		 * to an entity other than a many-to-one or one-to-one relationship. The
		 * embeddable class must be on the owning side of such a relationship
		 * and the relationship must be mapped by a foreign key mapping. (See
		 * Section 2.9.)
		 */

		ElementCollection.class.isAnnotation();

		section("2.7", RS.STARTED);

		/*
		 * Collections of elements and entity relationships can be represented
		 * as java.util.Map collections.
		 * 
		 * The map key and the map value independently can each be a basic type,
		 * an embeddable class, or an entity.
		 * 
		 * The ElementCollection, OneToMany, and ManyToMany annotations are used
		 * to specify the map as an element collection or entity relationship as
		 * follows: when the map value is a basic type or embeddable class, the
		 * ElementCollection annotation is used; when the map value is an
		 * entity, the OneToMany or ManyToMany annotation is used.
		 * 
		 * Bidirectional relationships represented as java.util.Map collections
		 * support the use of the Map datatype on one side of the relationship
		 * only.
		 */

		ElementCollection.class.isAnnotation();
		OneToMany.class.isAnnotation();
		ManyToMany.class.isAnnotation();

		section("2.7.1", RS.STARTED);

		/*
		 * If the map key type is a basic type, the MapKeyColumn annotation can
		 * be used to specify the column mapping for the map key.
		 */

		MapKeyColumn.class.isAnnotation();

		/*
		 * If the map key type is an embeddable class, the mappings for the map
		 * key columns are defaulted according to the default column mappings
		 * for the embeddable class.
		 */

		AttributeOverride.class.isAnnotation();
		AttributeOverrides.class.isAnnotation();

		/*
		 * If an embeddable class is used as a map key, the embeddable class
		 * must implement the hashCode and equals methods consistently with the
		 * database columns to which the embeddable is mapped.
		 */

		/*
		 * If the map key type is an entity, the MapKeyJoinColumn and
		 * MapKeyJoinColumns annotations are used to specify the column mappings
		 * for the map key.
		 */

		MapKeyJoinColumn.class.isAnnotation();
		MapKeyJoinColumns.class.isAnnotation();

		/*
		 * If Java generic types are not used in the declaration of a
		 * relationship attribute of type java.util.Map, the MapKeyClass
		 * annotation must be used to specify the type of the key of the map.
		 */

		MapKeyClass.class.isAnnotation();

		/*
		 * The MapKey annotation is used to specify the special case where the
		 * map key is itself the primary key or a persistent field or property
		 * of the entity that is the value of the map.
		 * 
		 * The MapKeyClass annotation is not used when MapKey is specified.
		 */

		MapKey.class.isAnnotation();

		section("2.7.2", RS.STARTED);

		/*
		 * When the value type of the map is a basic type or an embeddable
		 * class, a collection table is used to map the map. If Java generic
		 * types are not used, the targetClass element of the ElementCollection
		 * annotation must be used to specify the value type for the map. The
		 * default column mappings for the map value are derived according to
		 * the default mapping rules for the CollectionTable annotation defined
		 * in section 11.1.8. The Column annotation is used to override these
		 * defaults for a map value of basic type. The AttributeOverride(s) and
		 * AssociationOverride(s) annotations are used to override the mappings
		 * for a map value that is an embeddable class.
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				ElementCollection.class.newInstance().targetClass();
			}
		});

		ElementCollection.class.isAnnotation();
		CollectionTable.class.isAnnotation();
		AttributeOverride.class.isAnnotation();
		AttributeOverrides.class.isAnnotation();
		AssociationOverride.class.isAnnotation();
		AssociationOverrides.class.isAnnotation();

		/*-
		 * When the value type of the map is an entity, a join table is used to
		 * map the map for
		 * - a many-to-many relationship (always)
		 * - or a one-to-many unidirectional relationship (by default)
		 */

		/*
		 * If the relationship is a bidirectional one-to-many/many-to-one
		 * relationship, by default the map is mapped in the table of the entity
		 * that is the value of the map.
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				OneToMany.class.newInstance().targetEntity();
				ManyToMany.class.newInstance().targetEntity();
			}
		});

		section("2.8", RS.STARTED);

		Embeddable.class.isAnnotation();
		Embedded.class.isAnnotation();
		Basic.class.isAnnotation();

		section("2.9", RS.STARTED);

		/*-
		 * - one-to-one
		 * - one-to-many
		 * - many-to-one
		 * - many-to-many
		 */

		/* Relationships are polymorphic. */

		/*
		 * If there is an association between two entities, one of the following
		 * relationship modeling annotations must be applied to the
		 * corresponding persistent property or field of the referencing entity
		 */

		/* referencing entity */

		OneToOne.class.isAnnotation();
		OneToMany.class.isAnnotation();
		ManyToOne.class.isAnnotation();
		ManyToMany.class.isAnnotation();

		/*-
		 * - bidirectional relationship : owning side and inverse non-owning side
		 * - unidirectional relationship
		 */

		/* inverse side of a bidirectional relationship : */
		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				OneToOne.class.newInstance().mappedBy();
				OneToMany.class.newInstance().mappedBy();
				ManyToMany.class.newInstance().mappedBy();
			}
		});

		/* many side must be owning side */

		/* on OneToOne relationships, owning side contains the foreign key */

		/* cascade REMOVE can only be applied to OneToOne or OneToMany */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				OneToOne.class.newInstance().orphanRemoval();
				OneToMany.class.newInstance().orphanRemoval();
			}
		});

		/*
		 * an entity that is the target of a relationship is removed from the
		 * relationshiop when: - it is set to null - or it is removed from a
		 * collection
		 */

		/*
		 * the remove operation will be applied to the entity being orphaned if
		 * orphanRemoval is set to true
		 */

		/*
		 * The remove operation is applied at the time of the flush operation.
		 */

		/*
		 * orphaned entities must not be reassigned to another relationship
		 */

		/*
		 * orphaned entities must not be persisted again
		 */

		/*
		 * The semantics of orphanRemoval do not apply on detached, new or
		 * removed entities.
		 */

		/*
		 * If the remove operation is applied to a managed source entity, the
		 * remove operation will be cascaded to the relationship target
		 */

		/*
		 * it is not necessary to specify cascade=REMOVE for the relationship
		 */

		/* alternative mapping strategies */

		/*
		 * mapping of unidirectional one-to-many relationships by means of
		 * foreign key mappings
		 */

		JoinColumn.class.isAnnotation();

		/*
		 * mapping of unidirectional and bidirectional one-to-one relationships,
		 * bidirectional many-to-one/one-to-many relationships, and
		 * unidirectional many-to-one relationships by means of join table
		 * mappings
		 */

		JoinTable.class.isAnnotation();

		/*
		 * Such mapping annotations must be specified on the owning side of the
		 * relationship.
		 */

		section("2.10", RS.STARTED);
		section("2.10.1", RS.STARTED);

		/* Bidirectional OneToOne Relationships */

		/*-
		 * - A references a single instance of B
		 * - B references a single instance of A
		 * - A is owner
		 */

		/*-
		 * - A is mapped to table A
		 * - B is mapped to table B
		 * - Table A contains a foreign key to B
		 * - There's a unique key constraint on the foreign key
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Employee {

					Cubicle assignedCubicle;

					@Entity
					class Cubicle {
						private Employee residentEmployee;

						@OneToOne(mappedBy = "assignedCubicle")
						public Employee getResidentEmployee() {
							return residentEmployee;
						}

						public void setResidentEmployee(Employee employee) {
							this.residentEmployee = employee;
						}
					}

					@OneToOne
					public Cubicle getAssignedCubicle() {
						return assignedCubicle;
					}

					public void setAssignedCubicle(Cubicle cubicle) {
						this.assignedCubicle = cubicle;
					}
				}
			}
		});

		// Employee references a single Cubicle
		// Cubicle references a single Employee
		// Employee is owner
		// Employee is mapped to table EMPLOYEE
		// Cubicle is mapped to table CUBICLE
		// table EMPLOYEE contains the foreign key to cubicle

		section("2.10.2", RS.STARTED);

		/* Bidirectional ManyToOne / OneToMany Relationships */

		/*-
		 * - A references a single B
		 * - B references a collection of A
		 * - A must be owner
		 * - Table A contains foreign key to table B
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Employee {
					@Entity
					class Department {
						Collection<Employee> employees = new HashSet<>();

						@OneToMany(mappedBy = "department")
						public Collection<Employee> getEmployees() {
							return employees;
						}

						public void setEmployees(Collection<Employee> employees) {
							this.employees = employees;
						}
					}

					private Department department;

					@ManyToOne
					public Department getDepartment() {
						return department;
					}

					public void setDepartment(Department department) {
						this.department = department;
					}
				}
			}
		});

		/*-
		 * - Employee references a single Department
		 * - Deparment references many Employees
		 * - Employee is owner
		 * - Employee contains foreign key
		 */

		section("2.10.3", RS.STARTED);

		/* Unidirectional Single-Valued Relationships */

		/*-
		 * A references a single B
		 * B does not reference A
		 */

		section("2.10.3.1", RS.STARTED);

		/* Unidirectional OneToOne Relationships */

		/* A contains foreign key to B */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class TravelProfile {

				}
				@Entity
				class Employee {
					TravelProfile travelProfile;

					@OneToOne
					public TravelProfile getTravelProfile() {
						return travelProfile;
					}

					public void setTravelProfile(TravelProfile travelProfile) {
						this.travelProfile = travelProfile;
					}
				}
			}
		});

		/* Employee contains FK to TravelProfile */

		section("2.10.3.2", RS.STARTED);

		/* Unidirectional ManyToOne */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Address {

				}
				@Entity
				class Employee {
					Address address;

					@ManyToOne
					public Address getAddress() {
						return address;
					}

					public void setAddress(Address address) {
						this.address = address;
					}
				}

			}
		});

		/* Employee contains FK */

		section("2.10.4", RS.STARTED);

		/* Bidirectional ManyToMany Relationships */

		/*-
		 * - A references many instances of B
		 * - B references many instances of A
		 * - A is owner
		 * -There's a table A_B with FKs to A and B
		 * 
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Project {
					@Entity
					class Employee {
						Collection<Project> projects;

						@ManyToMany(mappedBy = "employees")
						public Collection<Project> getProjects() {
							return projects;
						}

						public void setProjects(Collection<Project> projects) {
							this.projects = projects;
						}
					}

					Collection<Employee> employees;

					@ManyToMany
					public Collection<Employee> getEmployees() {
						return employees;
					}

					public void setEmployees(Collection<Employee> employees) {
						this.employees = employees;
					}
				}
			}
		});

		section("2.10.5", RS.STARTED);

		/* Unidirectional Multi-Valued Relationships */

		/*-
		 * - A references many instances of B
		 * - B does not know about A
		 */

		section("2.10.5.1", RS.STARTED);

		/* Unidirectional OneToMany Relationships */

		/* join table */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Employee {
					@Entity
					class AnnualReview {

					}

					Collection<AnnualReview> annualReviews;

					@OneToMany
					public Collection<AnnualReview> getAnnualReviews() {
						return annualReviews;
					}

					public void setAnnualReviews(Collection<AnnualReview> annualReviews) {
						this.annualReviews = annualReviews;
					}
				}

			}
		});

		section("2.10.5.2", RS.STARTED);

		/* Unidirectional ManyToMany Relationships */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Employee {
					@Entity
					class Patent {
					}

					Collection<Patent> patents;

					@ManyToMany
					public Collection<Patent> getPatents() {
						return patents;
					}

					public void setPatents(Collection<Patent> patents) {
						this.patents = patents;
					}
				}
			}
		});

		section("2.11", RS.STARTED);

		/*
		 * An entity may inherit from another entity class. Entities support
		 * inheritance, polymorphic associations, and polymorphic queries.
		 * 
		 * Both abstract and concrete classes can be entities. Both abstract and
		 * concrete classes can be annotated with the Entity annotation, mapped
		 * as entities, and queried for as entities.
		 * 
		 * Entities can extend non-entity classes and non-entity classes can
		 * extend entity classes.
		 */

		section("2.11.1", RS.STARTED);

		/*
		 * An abstract entity is mapped as an entity and can be the target of
		 * queries
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				class Address {
				}

				@Entity
				@Table(name = "EMP")
				@Inheritance(strategy = InheritanceType.JOINED)
				abstract class Employee {
					@Id
					protected Integer empId;
					@Version
					protected Integer version;
					@ManyToOne
					protected Address address;
				}

				@Entity
				@Table(name = "FT_EMP")
				@DiscriminatorValue("FT")
				@PrimaryKeyJoinColumn(name = "FT_EMPID")
				class FullTimeEmployee extends Employee {
					protected Integer salary;
				}

				@Entity
				@Table(name = "PT_EMP")
				@DiscriminatorValue("PT")
				class PartTimeEmployee extends Employee {
					protected Float hourlyWage;
				}
			}
		});

		section("2.11.2", RS.STARTED);

		/*
		 * An entity may inherit from a superclass that provides persistent
		 * entity state and mapping information, but which is not itself an
		 * entity.
		 */

		/*
		 * A mapped superclass is not queryable and must not be passed as an
		 * argument to EntityManager or Query operations.
		 */

		/*
		 * Persistent relationships defined by a mapped superclass must be
		 * unidirectional.
		 */

		MappedSuperclass.class.isAnnotation();

		/*
		 * A class designated as a mapped superclass has no separate table
		 * defined for it.
		 */

		AttributeOverride.class.isAnnotation();
		AssociationOverrides.class.isAnnotation();

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				@Entity
				class Address {
				}

				@MappedSuperclass
				class Employee {
					@Id
					protected Integer empId;
					@Version
					protected Integer version;
					@ManyToOne
					@JoinColumn(name = "ADDR")
					protected Address addres;
				}

				@Entity
				class FTEmployee extends Employee {
					protected Integer salary;
				}

				@Entity
				@Table(name = "PT_EMP")
				@AssociationOverride(name = "address", joinColumns = @JoinColumn(name = "ADDR_ID"))
				class PTEmployee extends Employee {
					@Column(name = "WAGE")
					protected Float hourlyWage;
				}
			}
		});

		section("2.11.3", RS.STARTED);

		section("2.12", RS.STARTED);

		/*-
		 * - single table per class hierarchy
		 * - joined subclass
		 * - table per concrete class (support of this is not mandatory)
		 */

		section("2.12.1", RS.STARTED);

		/* Single Table per Class Hierarchy Strategy */

		/* discriminator column */
		/* specific columns must be nullable */

		section("2.12.2", RS.STARTED);

		/* Joined Subclass Strategy */

		/* pk of root class is fk in subclass tables */

		/* may require many joins */

		section("2.12.3", RS.STARTED);

		/* Table per Concrete Class Strategy */

		/* poor support for polymorphism */
		/* requires SQL UNION queries for queries other the whole hierarchy */

		section("2.13", RS.STARTED);

		/* <delimited-identifiers/> */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Entity
				@Table(name = "\"MyEntity\"")
				class MyEntity {
				}
			}
		});

		/*- <table name="&quot;MyEntity&quot;" /> */

		section("3", RS.STARTED);

		/*
		 * The set of entities that can be managed by a given EntityManager
		 * instance is defined by a persistence unit.
		 */

		/* must be colocated in their mapping to a single database */

		section("3.1", RS.STARTED);

		section("3.1.1", RS.STARTED);

		entityManager.persist(entity);
		entity = entityManager.merge(entity);
		entityManager.remove(entity);

		entity = entityManager.find(entityClass, primaryKey);
		entity = entityManager.find(entityClass, primaryKey, lockMode);
		entity = entityManager.find(entityClass, primaryKey, properties);
		entity = entityManager.find(entityClass, primaryKey, lockMode, properties);

		entity = entityManager.getReference(entityClass, primaryKey);

		entityManager.flush();
		entityManager.setFlushMode(flushMode);
		flushMode = entityManager.getFlushMode();

		entityManager.lock(entity, lockMode);
		entityManager.lock(entity, lockMode, properties);

		entityManager.refresh(entity);
		entityManager.refresh(entity, lockMode);
		entityManager.refresh(entity, properties);
		entityManager.refresh(entity, lockMode, properties);

		entityManager.clear();

		entityManager.detach(entity);

		b = entityManager.contains(entity);

		lockMode = entityManager.getLockMode(entity);

		entityManager.setProperty(propertyName, propertyValue);
		properties = entityManager.getProperties();

		query = entityManager.createQuery(qlString);
		typedQuery = entityManager.createQuery(criteriaQuery);
		query = entityManager.createQuery(updateQuery);
		query = entityManager.createQuery(deleteQuery);
		typedQuery = entityManager.createQuery(qlString, resultClass);

		query = entityManager.createNamedQuery(queryName);
		typedQuery = entityManager.createNamedQuery(queryName, resultClass);

		query = entityManager.createNativeQuery(sqlString);
		query = entityManager.createNativeQuery(sqlString, resultClass);
		query = entityManager.createNativeQuery(sqlString, resultSetMapping);

		storedProcedureQuery = entityManager.createNamedStoredProcedureQuery(queryName);

		storedProcedureQuery = entityManager.createStoredProcedureQuery(procedureName);
		storedProcedureQuery = entityManager.createStoredProcedureQuery(procedureName, resultClass1, resultClass2);
		storedProcedureQuery = entityManager.createStoredProcedureQuery(procedureName, resultSetMapping1,
				resultSetMapping2);

		entityManager.joinTransaction();
		entityManager.isJoinedToTransaction();

		entity = entityManager.unwrap(clazz);

		delegate = entityManager.getDelegate();

		entityManager.close();
		b = entityManager.isOpen();

		entityTransaction = entityManager.getTransaction();
		entityManagerFactory = entityManager.getEntityManagerFactory();
		criteriaBuilder = entityManager.getCriteriaBuilder();
		metamodel = entityManager.getMetamodel();

		entityGraph = entityManager.createEntityGraph(clazz);
		entityGraph = entityManager.createEntityGraph(graphName);
		entityGraph = entityManager.getEntityGraph(graphName);
		entityGraphs = entityManager.getEntityGraphs(clazz);

		/*
		 * if persist, merge, remove or refresh are not invoked within a
		 * transaction, TransactionRequiredException is thrown
		 */

		/* Lock types other that NONE require a transaction */

		/*
		 * find with lock type NONE and getReference do not require a
		 * transaction
		 */

		/*
		 * If an entity manager with transaction-scoped persistence context is
		 * in use, the resulting entities will be detached
		 */

		/*
		 * if an entity manager with an extended persistence context is used,
		 * they will be managed
		 */

		section("3.1.2", RS.STARTED);

		dontRun(new NotRunnable() {

			@Entity
			class Order {
				Customer customer;

				public void setCustomer(Customer customer) {
					this.customer = customer;
				}
			}

			@Entity
			class Customer {
				Collection<Order> orders;

				public Collection<Order> getOrders() {
					return orders;
				}
			}

			@Stateless
			class MyStatelessBean {

				@PersistenceContext
				EntityManager entityManager;

				public void foo() {
					Customer customer = entityManager.find(Customer.class, 0);
					Order order = new Order();
					customer.getOrders().add(order);
					order.setCustomer(customer);
					entityManager.persist(order);

				}
			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		section("3.2", RS.STARTED);

		/*-
		 * - new
		 *   - no persistent identity
		 *   - not yet associated with a persistence context
		 * - managed
		 *   - persistent identity
		 *   - associated with a persistence context
		 * - detached
		 *   - persistent identity
		 *   - not associated with a persistence context
		 * - removed
		 *   - persistent identity
		 *   - scheduled for removal ; will be removed at next commit
		 */

		section("3.2.1", RS.STARTED);

		dontRun(new NotRunnable() {

			@Entity
			class MyEntity {

			}

			@Override
			public void dontRun() throws Exception {
				MyEntity entity = new MyEntity();
				/* entity is new */
			}
		});

		section("3.2.2", RS.STARTED);

		dontRun(new NotRunnable() {

			@Entity
			class MyEntity {

			}

			@Override
			public void dontRun() throws Exception {
				MyEntity entity = new MyEntity();
				entityManager.persist(entity);
				/* entity is now managed and persistent */

			}
		});

		/*
		 * new entity become managed when persisted ; they are synced with
		 * database upon transaction commit or as a result of a flush operation
		 */

		/*
		 * persisting managed entities has no effect on them, but they cause
		 * referenced entities to be persisted too if cascade is PERSIST or ALL
		 */

		/* persisting removed entities make them managed */

		/* detached entities should not be persisted */

		section("3.2.3", RS.STARTED);

		dontRun(new NotRunnable() {

			@Entity
			class MyEntity {

			}

			@Override
			public void dontRun() throws Exception {
				MyEntity entity = new MyEntity();
				entityManager.persist(entity);
				/* entity is now managed and persistent */
				entityManager.remove(entity);
				/* entity is removed */

			}
		});

		/*
		 * removing new entity has no effect, but the operation may be cascaded
		 */

		/* removing managed entities make them removed */

		/* detached entities cannot be removed */

		/* removing removed entities has no effect */

		/* actual removal will be done on transaction commit or on flush */

		section("3.2.4", RS.STARTED);

		/*- the following require using joinTransaction to sync with the database
		 * - persistence context of type SynchronizationType.UNSYNCHRONIZED
		 * - application-managed persistence context created outside the scope of the current transaction
		*/

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				entityManager.joinTransaction();
			}
		});

		/* persistent entities are synced on transaction commit or flush */

		/*
		 * synchronization does not involve refresh unless cascade is REFRESH or
		 * ALL
		 */

		/*
		 * Bidirectional relationships between managed entities will be
		 * persisted based on references held by the owning side of the
		 * relationship.
		 */

		/*
		 * It is the developer’s responsibility to keep the in-memory references
		 * held on the owning side and those held on the inverse side consistent
		 * with each other when they change.
		 */

		/*
		 * It is particularly important to ensure that changes to the inverse
		 * side of a relationship result in appropriate updates on the owning
		 * side, so as to ensure the changes are not lost when they are
		 * synchronized to the database.
		 */

		/* flushing can occur before transaction commit */
		FlushModeType.AUTO.toString();
		FlushModeType.COMMIT.toString();
		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				entityManager.flush();
			}
		});

		/*
		 * upon flushing, managed entities are synced with the database, and
		 * removed entities are removed from the database
		 */

		section("3.2.5", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				entityManager.refresh(entity);
			}
		});

		/* only managed entities can be refreshed */

		section("3.2.6", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				entityManager.flush();
				entityManager.detach(entity);
			}
		});

		/* better call flush before detach */

		section("3.2.7", RS.STARTED);

		/*- the following events cause an entity to become detached
		 * - transaction commit
		 * - transaction rollback
		 * - detach()
		 * - clearing the persistence context
		 * - closing the entity manager
		 * - serialization
		 * - passing by value
		 */

		/*
		 * detached entity contains only the part of the state that was
		 * retrieved from the database
		 */

		section("3.2.7.1", RS.STARTED);

		/* merging a managed entity has no effect */

		/* merging a removed entity is illegal */

		/*
		 * merging a detached entity cause the state of the detached entity to
		 * be copied to a preexisting or new managed copy of the entity
		 */

		/*
		 * mergin a new entity cause a new managed instance to be created and
		 * the state copied onto the new managed instance
		 */

		/* fields marked LAZY are not merged */

		/* @Version fields are checked when merging */

		section("3.2.7.2", RS.STARTED);

		/*
		 * Serializing entities and merging those entities back into a
		 * persistence context may not be interoperable across vendors when lazy
		 * properties or fields and/or relationships are used.
		 */

		/*
		 * When interoperability across vendors is required, the application
		 * must not use lazy loading.
		 */

		section("3.2.8", RS.STARTED);

		/* an entity instance must be managed by only one persistence context */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				entityManager.contains(entity);
			}
		});

		/*- contains return:
		 * - true if a new entity has been persisted
		 * - true if the entity has been retrieved from the database or with getReference and has not been removed or detached
		 * - false if the entity is detached
		 * - false if the entity has been removed
		 * - false if the entity is new and has not been persisted
		 */

		section("3.2.9", RS.STARTED);

		/* an entity is loaded when all EAGER attributes have been fetched */

		dontRun(new NotRunnable() {

			@Override
			public void dontRun() throws Exception {
				persistenceUtil.isLoaded(entity);
				persistenceUnitUtil.isLoaded(entity);
			}
		});

		section("3.3", RS.STARTED);

		/*-
		 * - transaction-scoped presistence context
		 * - extended persistence context
		 */

		PersistenceContextType.TRANSACTION.toString();
		PersistenceContextType.EXTENDED.toString();

		/*
		 * The persistence context lifetime scope is defined when the
		 * EntityManager instance is created
		 */

		/*
		 * By default, the lifetime of the persistence context of a
		 * container-managed entity manager corresponds to the scope of a
		 * transaction
		 */

		/*
		 * When an extended persistence context is used, the extended
		 * persistence context exists from the time the EntityManager instance
		 * is created until it is closed. This persistence context might span
		 * multiple transactions and non-transactional invocations of the
		 * EntityManager.
		 */

		/*
		 * An EntityManager with an extended persistence context maintains its
		 * references to the entity objects after a transaction has committed.
		 * Those objects remain managed by the EntityManager, and they can be
		 * updated as managed objects between transactions.[30] Navigation from
		 * a managed object in an extended persistence context results in one or
		 * more other managed objects regardless of whether a transaction is
		 * active.
		 */

		/*
		 * When an EntityManager with an extended persistence context is used,
		 * the persist, remove, merge, and refresh operations can be called
		 * regardless of whether a transaction is active. The effects of these
		 * operations will be committed to the database when the extended
		 * persistence context is enlisted in a transaction and the transaction
		 * commits.
		 */

		/*
		 * It is the responsibility of the application to manage the lifecycle
		 * of the persistence context.
		 */

		section("3.3.1", RS.STARTED);

		/*
		 * By default, a container-managed persistence context is of
		 * SynchronizationType.SYNCHRONIZED and is automatically joined to the
		 * current transaction.
		 */

		/*
		 * A persistence context of SynchronizationType. UNSYNCHRONIZED will not
		 * be enlisted in the current transaction, unless the EntityManager
		 * joinTransaction method is invoked.
		 */

		/*
		 * By default, an application-managed persistence context that is
		 * associated with a JTA entity manager and that is created within the
		 * scope of an active transaction is automatically joined to that
		 * transaction.
		 */

		/*
		 * An application-managed JTA persistence context that is created
		 * outside the scope of a transaction or an application-managed
		 * persistence context of type SynchronizationType.UNSYNCHRONIZED will
		 * not be joined to that transaction unless the EntityManager
		 * joinTransaction method is invoked.
		 */

		/*
		 * An application-managed persistence context associated with a
		 * resource-local entity manager is always automatically joined to any
		 * resource-local transaction that is begun for that entity manager.
		 */

		section("3.3.2", RS.STARTED);

		/*
		 * The managed entities of a transaction-scoped persistence context
		 * become detached when the transaction commits.
		 */

		/*
		 * The managed entities of an extended persistence context remain
		 * managed when the transaction commits.
		 */

		section("3.3.3", RS.STARTED);

		/*
		 * For both transaction-scoped persistence contexts and for extended
		 * persistence contexts that are joined to the current transaction,
		 * transaction rollback causes all pre-existing managed instances and
		 * removed instances to become detached.
		 */

		/*
		 * Transaction rollback typically causes the persistence context to be
		 * in an inconsistent state at the point of rollback.
		 */

		/*
		 * The state of version attributes and generated primary keys may be
		 * inconsistent.
		 */

		/*
		 * Instances that were formerly managed by the persistence context,
		 * including new instances that were made persistent in that
		 * transaction, may therefore not be reusable in the same manner as
		 * other detached objects, they may fail when passed to the merge
		 * operation.
		 */

		/*
		 * The container closes a transaction-scoped persistence context upon
		 * transaction rollback.
		 */

		/*
		 * An extended persistence context that is not joined to a transaction
		 * is unaffected by transaction rollback
		 */

		section("3.4", RS.STARTED);

		/*
		 * This specification assumes the use of optimistic concurrency control.
		 */

		/*
		 * It assumes that the databases to which persistence units are mapped
		 * will be accessed by the implementation using read-committed
		 * isolation,
		 * 
		 * and that writes to the database will typically occur only when the
		 * flush method has been invoked.
		 */

		/*
		 * both pessimistic and optimistic locking are supported for selected
		 * entities by means of specified lock modes
		 */

		section("3.4.1", RS.STARTED);

		/*
		 * Optimistic locking is a technique that is used to insure that updates
		 * to the database data corresponding to the state of an entity are made
		 * only when no intervening transaction has updated that data since the
		 * entity state was read.
		 */

		/*
		 * This insures that updates or deletes to that data are consistent with
		 * the current state of the database and that intervening updates are
		 * not lost.
		 */

		/* OptimisticLockException may be thrown */

		/*
		 * optimistic locking requires Version attributes
		 */

		/*
		 * Applications are strongly encouraged to enable optimistic locking for
		 * all entities that may be concurrently accessed or that may be merged
		 * from a disconnected state.
		 */

		/*
		 * Failure to use optimistic locking may lead to inconsistent entity
		 * state, lost updates and other state irregularities.
		 */

		section("3.4.2", RS.STARTED);

		/*
		 * An entity is automatically enabled for optimistic locking if it has a
		 * property or field mapped with a Version mapping.
		 */

		/* An entity must not modify the version value. */

		/*
		 * only the persistence provider is permitted to set or update the value
		 * of the version attribute in the object
		 */

		/*
		 * The version attribute is updated by the persistence provider runtime
		 * when the object is written to the database.
		 */

		/*
		 * All non-relationship fields and properties and all relationships
		 * owned by the entity are included in version checks.
		 */

		/*
		 * The persistence provider's implementation of the merge operation must
		 * examine the version attribute when an entity is being merged and
		 * throw an OptimisticLockException if it is discovered that the object
		 * being merged is a stale copy of the entity.
		 */

		/*
		 * It is possible that this exception may not be thrown until flush is
		 * called or commit time, whichever happens first.
		 */

		/*
		 * The persistence provider runtime is required to use only the version
		 * attribute when performing optimistic lock checking.
		 */

		/*
		 * If only some entities contain version attributes, the persistence
		 * provider runtime is required to check those entities for which
		 * version attributes have been specified.
		 */

		section("3.4.3", RS.STARTED);

		/*
		 * Optimistic locking is typically appropriate in dealing with moderate
		 * contention among concurrent transactions.
		 */

		/*
		 * In some applications it may be useful to immediately obtain long-term
		 * database locks for selected entities because of the often late
		 * failure of optimistic transactions.
		 */

		/*
		 * Pessimistic locking guarantees that once a transaction has obtained a
		 * pessimistic lock on an entity instance, no other transaction may
		 * successfully modify or delete that instance until the transaction
		 * holding the lock has ended, and the transaction may modify or delete
		 * that entity instance.
		 */

		/*
		 * When an entity instance is locked using pessimistic locking, the
		 * persistence provider must lock the database row(s) that correspond to
		 * the non-collection-valued persistent state of that instance. If a
		 * joined inheritance strategy is used, or if the entity is otherwise
		 * mapped to a secondary table, this entails locking the row(s) for the
		 * entity instance in the additional table(s). Entity relationships for
		 * which the locked entity contains the foreign key will also be locked,
		 * but not the state of the referenced entities (unless those entities
		 * are explicitly locked). Element collections and relationships for
		 * which the entity does not contain the foreign key (such as
		 * relationships that are mapped to join tables or unidirectional
		 * one-to-many relationships for which the target entity contains the
		 * foreign key) will not be locked by default.
		 */

		/*
		 * Element collections and relationships owned by the entity that are
		 * contained in join tables will be locked if the
		 * javax.persistence.lock.scope property is specified with a value of
		 * PessimisticLockScope.EXTENDED. The state of entities referenced by
		 * such relationships will not be locked (unless those entities are
		 * explicitly locked). This property may be passed as an argument to the
		 * methods of the EntityManager, Query, and TypedQuery interfaces that
		 * allow lock modes to be specified or used with the NamedQuery
		 * annotation.
		 */

		/*
		 * Locking such a relationship or element collection generally locks
		 * only the rows in the join table or collection table for that
		 * relationship or collection. This means that phantoms will be
		 * possible.
		 */

		section("3.4.4", RS.STARTED);

		/*
		 * Lock modes are intended to provide a facility that enables the effect
		 * of “repeatable read” semantics for the items read.
		 */

		section("3.4.4.1", RS.STARTED);

		LockModeType.OPTIMISTIC.toString();
		LockModeType.OPTIMISTIC_FORCE_INCREMENT.toString();

		LockModeType.READ.toString();
		LockModeType.WRITE.toString();

		/*
		 * Insures against - dirty reads - non-repeatable reads
		 */

		/*
		 * The persistence implementation is not required to support locing on a
		 * non-versioned objectand can throw PersistenceException in this case.
		 */

		/* Locking cause a forced version update. */

		section("3.4.4.2", RS.STARTED);

		LockModeType.PESSIMISTIC_READ.toString();
		LockModeType.PESSIMISTIC_WRITE.toString();
		LockModeType.PESSIMISTIC_FORCE_INCREMENT.toString();

		/* long-term database locks */

		/*-
		 * - dirty reads
		 * - non-repeatable reads
		 */

		PessimisticLockException.class.getName();
		LockTimeoutException.class.getName();
		OptimisticLockException.class.getName();
		PersistenceException.class.getName();

		section("3.4.4.3", RS.STARTED);

		/* javax.persistence.lock.scope */

		/* javax.persistence.lock.timeout */

		section("3.4.5", RS.STARTED);

		section("3.5", RS.STARTED);

		/*
		 * Default entity listeners can be specified by means of the XML
		 * descriptor.
		 */

		/*
		 * If multiple entity listeners are defined, the order in which they are
		 * invoked is determined by the order in which they are specified in the
		 * EntityListeners annotation.
		 */

		dontRun(new NotRunnable() {

			class MyEntityListener {
				public MyEntityListener() {
				}

				@PostConstruct
				public void postConstruct() {

				}

				@PreDestroy
				public void preDestroy() {

				}

				@PrePersist
				public void prePersist(MyEntity entity) {
				}

				@PostPersist
				public void postPersist(MyEntity entity) {
				}

				@PreRemove
				public void preRemove(MyEntity entity) {
				}

				@PostRemove
				public void postRemove(MyEntity entity) {
				}

				@PreUpdate
				public void preUpdate(MyEntity entity) {
				}

				@PostUpdate
				public void postUpdate(MyEntity entity) {
				}

				@PostLoad
				public void postLoad(MyEntity entity) {
				}

			}

			@Entity
			@EntityListeners(MyEntityListener.class)
			class MyEntity {

			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		section("3.5.1", RS.STARTED);

		section("3.5.2", RS.STARTED);

		/*
		 * Lifecycle callbacks can invoke JNDI, JDBC, JMS, and enterprise beans.
		 */

		section("3.5.3", RS.STARTED);

		section("3.5.4", RS.STARTED);
		section("3.5.5", RS.STARTED);

		/*
		 * default listeners are invoked first, and can be excluded for some
		 * entities
		 */

		dontRun(new NotRunnable() {
			@Entity
			@ExcludeDefaultListeners
			class MyEntity {

			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		/*
		 * the listeners defined for a superclass are invoked before the
		 * listeners defined for its subclasses
		 */

		dontRun(new NotRunnable() {
			@Entity
			@ExcludeSuperclassListeners
			class MyEntity {

			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		section("3.5.6", RS.STARTED);
		section("3.5.7", RS.STARTED);
		section("3.5.8", RS.STARTED);
		section("3.5.8.1", RS.STARTED);
		section("3.5.8.2", RS.STARTED);
		section("3.6", RS.STARTED);

		section("3.6.1", RS.STARTED);
		section("3.6.1.1", RS.STARTED);

		/* validation-mode in persistence.xml */

		/* javax.persistence.validation.mode */

		section("3.6.1.2", RS.STARTED);

		/* default bean validation group */

		/*-
		 * - javax.persistence.validation.group.pre-persist
		 * - javax.persistence.validation.group.pre-update
		 * - javax.persistence.validation.group.pre-remove
		 */

		section("3.6.2", RS.STARTED);
		section("3.7", RS.STARTED);

		EntityGraph.class.getName();
		AttributeNode.class.getName();
		Subgraph.class.getName();
		NamedEntityGraph.class.isAnnotation();
		NamedAttributeNode.class.isAnnotation();
		NamedSubgraph.class.isAnnotation();

		section("3.7.1", RS.STARTED);
		section("3.7.2", RS.STARTED);
		section("3.7.3", RS.STARTED);
		section("3.7.4", RS.STARTED);

		/*-
		 * - javax.persistence.fetchgraph
		 * - javax.persistence.loadgraph
		 */

		section("3.7.4.1", RS.STARTED);

		dontRun(new NotRunnable() {
			class PhoneTypeEnum {
			}

			@NamedEntityGraph
			@Entity
			class PhoneNumber {
				@Id
				protected String number;
				protected PhoneTypeEnum type;
			}

			@Entity
			class Dependent {
			}

			@Entity
			class Approval {
			}

			@Entity
			class Requirements {
				@Id
				protected long id;
				@Lob
				protected String descrition;
				@OneToOne(fetch = FetchType.LAZY)
				protected Approval approval;
			}

			@Entity
			@Inheritance
			class Project {
				@Id
				@GeneratedValue
				protected long id;
				String name;
				@OneToOne(fetch = FetchType.EAGER)
				Requirements doc;
			}

			@Entity
			class LargeProject extends Project {
				@OneToOne(fetch = FetchType.LAZY)
				protected Employee approver;

			}

			@NamedEntityGraph(attributeNodes = { @NamedAttributeNode("projects") })
			@Entity
			class Employee {
				@Id
				@GeneratedValue
				protected long id;
				@Basic
				protected String name;
				@Basic
				protected String employeeNumber;
				@OneToMany
				protected List<Dependent> dependents;
				@OneToMany
				protected List<Project> projects;
				@OneToMany
				protected List<PhoneNumber> phoneNumbers;
			}

			@Override
			public void dontRun() throws Exception {

			}
		});

		section("3.7.4.2", RS.STARTED);

		/* javax.persistence.loadgraph */

		section("3.8", RS.STARTED);

		AttributeConverter.class.isInterface();
		Converter.class.isAnnotation();
		Converter.class.newInstance().autoApply();
		Convert.class.isAnnotation();

		section("3.9", RS.STARTED);

		/* second-level cache */

		/* stale reads */

		/*
		 * shared-cache-mode : ALL, NONE, ENABLE_SELECTIVE, DISABLE_SELECTIVE,
		 * UNSPECIFIED
		 */

		Cacheable.class.isAnnotation();

		section("3.9.1", RS.STARTED);
		section("3.9.2", RS.STARTED);

		/* retrieveMode, storeMode */

		section("3.10", RS.STARTED);
		section("3.10.1", RS.STARTED);
		section("3.10.2", RS.STARTED);
		section("3.10.3", RS.STARTED);
		section("3.10.4", RS.STARTED);
		section("3.10.5", RS.STARTED);
		section("3.10.6", RS.STARTED);
		section("3.10.7", RS.STARTED);

		query.getSingleResult();
		query.getResultList();
		query.executeUpdate();

		section("3.10.7.1", RS.UNTOUCHED);
		section("3.10.8", RS.STARTED);

		section("3.10.9", RS.STARTED);
		section("3.10.10", RS.STARTED);

		/* javax.persistence.query.timeout */

		section("3.10.11", RS.STARTED);
		section("3.10.12", RS.STARTED);
		section("3.10.13", RS.STARTED);
		section("3.10.14", RS.STARTED);
		section("3.10.15", RS.STARTED);
		section("3.10.16", RS.STARTED);
		section("3.10.16.1", RS.STARTED);

		SqlResultSetMapping.class.isAnnotation();

		section("3.10.16.2", RS.STARTED);

		section("3.10.16.2.1", RS.UNTOUCHED);
		section("3.10.16.2.2", RS.UNTOUCHED);

		section("3.10.16.3", RS.STARTED);

		section("3.10.16.4", RS.STARTED);
		section("3.10.17", RS.STARTED);

		section("3.10.17.1", RS.UNTOUCHED);
		section("3.10.17.2", RS.UNTOUCHED);
		section("3.10.17.3", RS.UNTOUCHED);
		section("3.11", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				Class<?>[] exceptions = new Class<?>[] {

						PersistenceException.class,

						TransactionRequiredException.class,

						OptimisticLockException.class,

						PessimisticLockException.class,

						LockTimeoutException.class,

						RollbackException.class,

						EntityExistsException.class,

						EntityNotFoundException.class,

						NoResultException.class,

						NonUniqueResultException.class,

						QueryTimeoutException.class,

				};
			}
		});

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
		section("7", RS.STARTED);
		section("7.1", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				entityManagerFactory.createEntityManager();
			}
		});

		section("7.2", RS.STARTED);

		/*
		 * Entity managers and persistence contexts are not required to be
		 * threadsafe.
		 */

		section("7.2.1", RS.STARTED);

		dontRun(new NotRunnable() {
			@Stateless
			@PersistenceContext(name = "FooEM")
			class MyBean {

				@Resource
				SessionContext ctx;

				@PersistenceContext
				EntityManager entityManager;

				@PersistenceContext(type = PersistenceContextType.EXTENDED, synchronization = SynchronizationType.SYNCHRONIZED)
				EntityManager entityManager2;

				public void foo() {
					EntityManager em = (EntityManager) ctx.lookup("FooEM");
				}
			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		section("7.2.2", RS.STARTED);
		section("7.3", RS.STARTED);
		section("7.3.1", RS.STARTED);

		dontRun(new NotRunnable() {

			@PersistenceUnit
			EntityManagerFactory entityManagerFactory;

			@Override
			public void dontRun() throws Exception {

			}
		});

		section("7.3.2", RS.STARTED);

		dontRun(new NotRunnable() {

			@Override
			public void dontRun() throws Exception {
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FooEM");
				EntityManager em = entityManagerFactory.createEntityManager();
			}
		});

		section("7.4", RS.STARTED);

		section("7.5", RS.STARTED);

		section("7.5.1", RS.STARTED);

		section("7.5.2", RS.STARTED);
		section("7.5.3", RS.STARTED);
		section("7.5.4", RS.STARTED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TOTO");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				// ...
				entityManager.getTransaction().commit();
				entityManager.close();
				entityManagerFactory.close();

			}
		});

		section("7.6", RS.STARTED);

		/*
		 * Persistence contexts are always associated with an entity manager
		 * factory.
		 */

		section("7.6.1", RS.STARTED);

		section("7.6.2", RS.STARTED);
		section("7.6.3", RS.STARTED);

		/*
		 * A container-managed extended persistence context can only be
		 * initiated within the scope of a stateful session bean.
		 */

		section("7.6.3.1", RS.STARTED);

		/*
		 * If a stateful session bean instantiates a stateful session bean which
		 * also has such an extended persistence context with the same
		 * synchronization type, the extended persistence context of the first
		 * stateful session bean is inherited by the second stateful session
		 * bean and bound to it. If the stateful session beans differ in
		 * declared synchronization type, the EJBException is thrown by the
		 * container.
		 */

		section("7.6.4", RS.STARTED);

		/*
		 * A single persistence context may correspond to one or more JTA entity
		 * manager instances, all associated with the same entity manager
		 * factory.
		 */

		/*
		 * The persistence context is propagated across the entity manager
		 * instances as the JTA transaction is propagated.
		 */

		/*
		 * A persistence context of type SynchronizationType.UNSYNCHRONIZED is
		 * propagated with the JTA transaction regardless of whether it has been
		 * joined to the transaction.
		 */

		/*
		 * Persistence contexts are not propagated to remote tiers.
		 */
		section("7.6.4.1", RS.STARTED);

		section("7.6.5", RS.STARTED);

		section("7.6.5.1", RS.STARTED);

		dontRun(new NotRunnable() {

			@Entity
			class Item {
			}

			@Stateless
			class MyBean {
				@PersistenceContext
				EntityManager entityManager;

				public Item foo() {
					Item item = new Item();
					entityManager.persist(item);
					return item;
				}
			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		section("7.6.5.2", RS.STARTED);

		dontRun(new NotRunnable() {

			@Entity
			class Item {
			}

			@Stateful
			@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
			class MyBean {
				@PersistenceContext(type = PersistenceContextType.EXTENDED)
				EntityManager entityManager;

			}

			@Override
			public void dontRun() throws Exception {
			}
		});

		section("7.7", RS.STARTED);
		
		
		
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
