package com.github.xdptdr.jee7;

import java.awt.dnd.DragGestureEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.AccessException;
import java.rmi.MarshalException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.security.Identity;
import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.AccessTimeout;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.ApplicationException;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.BeforeCompletion;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.ConcurrentAccessException;
import javax.ejb.ConcurrentAccessTimeoutException;
import javax.ejb.CreateException;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.EJBException;
import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.EJBMetaData;
import javax.ejb.EJBObject;
import javax.ejb.EJBTransactionRequiredException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.FinderException;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.ejb.NoSuchEJBException;
import javax.ejb.NoSuchObjectLocalException;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.RemoveException;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Schedules;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.SessionSynchronization;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.Stateless;
import javax.ejb.TimedObject;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerHandle;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.ejb.TransactionRequiredLocalException;
import javax.ejb.TransactionRolledbackLocalException;
import javax.ejb.embeddable.EJBContainer;
import javax.ejb.spi.HandleDelegate;
import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;
import javax.mail.search.SearchException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;
import javax.transaction.InvalidTransactionException;
import javax.transaction.TransactionRequiredException;
import javax.transaction.TransactionRolledbackException;
import javax.transaction.UserTransaction;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.handler.MessageContext;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;

public class ReadingJSR345 extends Reading {

	private Future<Object> future;
	private boolean mayInterruptIfRunning;
	private SessionContext sessionContext;
	private Identity identity;
	private Identity roleName;
	private Class businessInterface;
	private String name;
	private Principal principal;
	private boolean callerInRole;
	private boolean rollbackOnly;
	private UserTransaction userTransaction;
	private TimerService timerService;
	private Object businessObject;
	private Class invokedBusinessInterface;
	private EJBObject ejbObject;
	private EJBHome ejbHome;
	private EJBLocalObject ejbLocalObject;
	private EJBLocalHome ejbLocalHome;
	private Object object;
	private boolean wasCancelled;
	private Map<String, Object> contextData;
	private SessionBean sessionBean;
	private MessageDrivenContext messageDrivenContext;
	private Connection connection;
	private boolean autoCommit;
	private Session session;
	private HandleDelegate handleDelegate;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private EJBContext ejbContext;
	protected String role;
	private Timer timer;
	private long duration;
	private Serializable info;
	private long timeRemaining;
	private Date nextTimeout;
	private TimerHandle timerHandle;
	private boolean persistent;
	private boolean isCalendarTimer;
	private Date date;
	private TimerConfig timerConfig;
	private long initialDuration;
	private long intervalDuration;
	private Date initialExpiration;
	private ScheduleExpression scheduleExpression;
	private Collection<Timer> timers;

	@Override
	public void reading() throws Exception {

		section("CORE", RS.STARTED);

		section("CORE.1", RS.COMPLETED);

		section("CORE.1.2", RS.COMPLETED);

		/* this section requires some familiarity with EJBs */
		toReadAgain();

		section("CORE.1.3", RS.COMPLETED);

		/* this section requires some familiarity with EJBs */
		toReadAgain();

		section("CORE.2", RS.COMPLETED);

		section("CORE.2.1", RS.COMPLETED);

		section("CORE.2.2", RS.COMPLETED);

		section("CORE.2.3", RS.COMPLETED);
		section("CORE.2.3.2", RS.COMPLETED);

		/* stateless service */

		/* stateless service with web service endpoint */

		/* stateless asynchronous service */

		/* conversational session */

		section("CORE.2.4", RS.COMPLETED);

		/* session objects */

		/* message-driven objects */

		/* entity objects (optional) */

		section("CORE.2.4.1", RS.COMPLETED);

		/* session objects */

		/* can be transaction aware */

		/* can update shared data in a database */

		/* stateful session beans */
		/* stateless session beans */
		/* singleton session beans */

		section("CORE.2.4.2", RS.COMPLETED);

		/* message driven objects */

		/* asynchronous */

		/* can be transaction aware */

		/* can update shared data in a database */

		/* is stateless */

		section("CORE.2.4.3", RS.COMPLETED);

		/* entity objects */

		/* part of a domain model */

		/* as the same lifespan as the corresponding data in the database */

		/* survives the crash of an EJB container */

		section("CORE.2.5", RS.COMPLETED);

		/* the container must provide support for CORBA/IIOP */

		section("CORE.2.6", RS.COMPLETED);

		/* support for WSDL, SOAP or XML over HTTP is mandatory */

		/* support for JAX-RPC is optional */

		section("CORE.2.7", RS.COMPLETED);

		section("CORE.2.8", RS.COMPLETED);

		/* EJB extends Managed Beans */

		section("CORE.2.9", RS.COMPLETED);

		/*
		 * an EJB packaged into a CDI archive and not annotated with
		 * javax.enterprise.inject.Vetoed is considered a CDI-enabled bean
		 */

		Vetoed.class.isAnnotation();

		/*
		 * the CDI container performs dependency injection on all instances of
		 * CDI-enabled session and message-driven beans
		 */

		/* i.e., those which are contextual isntances */

		/* and those which are non-contextual instances too */

		/*
		 * a session bean obtained via dependency injection is a contextual
		 * instances
		 */

		/* message-driven bean instances are always non-contextual */

		/* so what's the bottom line ? */

		toReadAgain();

		section("CORE.2.10", RS.COMPLETED);

		toReadAgain();

		section("CORE.3", RS.COMPLETED);

		/* client view of a session bean */

		section("CORE.3.1", RS.COMPLETED);

		/*
		 * to the client, a session object is a non-persistent extension of the
		 * client program
		 */

		/*
		 * stateless and stateful session beans are not shared among multiple
		 * clients
		 */

		/* session beans can be invoked synchronously or asynchronously */

		{ // asynchronous methods return object of this type
			@SuppressWarnings("unused")
			Future<?> future = constructANewInstanceOf(Future.class);
		}

		/* a session object lives in the container */

		/* client access session bean objects through their client view */

		/*
		 * clients may be local clients, remote clients or web service clients
		 */

		/* typically, only one client view will be provided by a session bean */

		/*
		 * using a local client view entails the colocation of the local client
		 * and the session
		 */

		/*
		 * only stateless session bean or singleton session beans may provided
		 * web services client views
		 */

		section("CORE.3.2", RS.COMPLETED);

		/* local client view */
		/* remote client view */
		/* web service client view */

		/*- remote business interface : EJB 3.x : interface of a session bean that supports remote access */
		/*- remote component interface : EJB 2.1 : remote component interface of the client view (EJBObject) */
		/*
		 * local business interface : EJB 3.x : interface of a session bean that
		 * supports local access
		 */
		/*
		 * local component interface : EJB 2.1 : local component interface of
		 * the client view (EJBLocalObhect)
		 */
		/* business interface : local or remote business interface */
		/* component interface : local or remote component interface */

		/* business method : method exposed by : */
		/*-
		 * - local business interface
		 * - remote business interface
		 * - no-interface view
		 * - local component interface
		 * - remote component interface
		 * - web service client view
		 */

		section("CORE.3.2.1", RS.COMPLETED);

		section("CORE.3.2.2", RS.COMPLETED);

		section("CORE.3.2.3", RS.COMPLETED);

		section("CORE.3.2.4", RS.COMPLETED);

		section("CORE.3.3", RS.COMPLETED);

		section("CORE.3.4", RS.COMPLETED);

		/*
		 * EJB 3.x clients access a session bean through its business interface
		 */

		/* an EJB 3.x business interface is an ordinary interface */

		/*
		 * with previous EJB versions, it had to extend EJBObject or
		 * EJBLocalObject
		 */

		/*
		 * a local client may access a session bean through a no-interface view
		 * that exposes all non-static public methods of the bean class
		 */

		section("CORE.3.4.1", RS.COMPLETED);

		/* obtaining a reference to the business interface */

		{ // dependency injection
			@SuppressWarnings("unused")
			class Foo<T> {
				@EJB
				T myT;
			}
		}

		{ // JNDI lookcup
			@SuppressWarnings("unused")
			class Foo<T> {
				@Resource
				SessionContext sessionContext;

				@SuppressWarnings("unused")
				public void foo() {
					@SuppressWarnings({ "unused", "unchecked" })
					T myT = (T) sessionContext.lookup("myT");
				}
			}
		}

		section("CORE.3.4.2", RS.COMPLETED);

		/* obtaining a reference to the no-interface view */

		/* same as 3.4.1, but use the actual bean class instead */

		section("CORE.3.4.3", RS.COMPLETED);

		NoSuchEJBException.class.getName();

		section("CORE.3.4.4", RS.COMPLETED);

		/* clients must not instanciate Bean class directly */

		EJBException.class.getName();

		{
			@SuppressWarnings("unused")
			class MyBean {
				@PostConstruct
				public void postConstruct() {
					// initialization here
				}

			}
		}

		section("CORE.3.4.5", RS.COMPLETED);

		{
			@SuppressWarnings("unused")
			class MyBean {
				@Remove
				public void remove() {
					// method to use to remove the bean
				}
			}
		}

		/* stateless or singleton beans do not have to be removed */

		section("CORE.3.4.6", RS.COMPLETED);

		section("CORE.3.4.7", RS.COMPLETED);

		/* equality testing must use Object.equals() */

		section("CORE.3.4.7.1", RS.COMPLETED);

		/* is it possible to have reference to multiple stateful beans ? */
		questionHere();

		section("CORE.3.4.7.2", RS.COMPLETED);

		section("CORE.3.4.7.3", RS.COMPLETED);

		section("CORE.3.4.8", RS.COMPLETED);

		{
			abstract class MyBean {
				public abstract Future<String> fetch();
			}
			MyBean myBeanRef = constructANewInstanceOf(MyBean.class);

			// pattern for asynchronous methods :

			try {
				Future<String> future = myBeanRef.fetch();
			} catch (EJBException ex) {
				// may be thrown when application server does not have the
				// resources for performing the asynchonous operation
			}
		}

		section("CORE.3.4.8.1", RS.COMPLETED);

		/* asynchronous methods return void or Future */

		section("CORE.3.4.8.1.1", RS.COMPLETED);

		{
			// will work only if the call has not yet been dispatched
			future.cancel(mayInterruptIfRunning);
			// must return true if mayInterruptIfRunning was true
			sessionContext.wasCancelCalled();
		}

		toReadAgain();

		section("CORE.3.4.8.1.2", RS.COMPLETED);

		{ // retrieving the result
			Object v = future.get();

			// container may place timeouts to clear the results which have not
			// been retrieved
		}

		section("CORE.3.4.9", RS.COMPLETED);

		/*
		 * concurrent access to session beans depend on the semantics of the
		 * target bean
		 */

		section("CORE.3.5", RS.COMPLETED);

		section("CORE.3.5.1", RS.COMPLETED);

		{// example

			abstract class StockQuoteProvider {
				public abstract double getLastTradePrice(String string);
			}
			abstract class StockQuoteService {
				public abstract StockQuoteProvider getStockQuoteProviderPort();
			}
			class Foo {
				@WebServiceRef
				public StockQuoteService stockQuoteService;

				public void foo() {
					StockQuoteProvider stockQuoteProvider = stockQuoteService.getStockQuoteProviderPort();
					double quotePrice = stockQuoteProvider.getLastTradePrice("ACME");
				}
			}

		}

		section("CORE.3.6", RS.COMPLETED);

		/* this section pertains to EJB 2.1 */

		skipped();

		section("CORE.4", RS.COMPLETED);
		section("CORE.4.1", RS.COMPLETED);

		/* transaction and database considerations */
		toReadAgain();

		/* stateless */
		/* stateful */
		/* singleton */

		section("CORE.4.2", RS.COMPLETED);

		/* passivation and activation */

		{
			class MyBean {
				@PrePassivate
				public void prePassivate() {
					// close resources here
				}

				@PostActivate
				public void postActivate() {
					// reopen resources here
				}

			}
		}

		/* a bean may me marked as not passivation capable */

		/*
		 * a container may passivate a stateful session bean that contains an
		 * extended persistence context only if
		 */
		/*-
		 * - all the entities in the persistence context are Serializable
		 * - the EntityManager is serializable
		 */

		/* stateless and singleton session beans are never passivated */

		section("CORE.4.2.1", RS.COMPLETED);

		/* transient fields will not be serialized */

		/* the following item can be passivated */
		/*-
		 * - Serializable objects
		 * - null
		 * - references to EJB business interfaces
		 * - references to EJB no-interface views
		 * - references to EJB component interfaces (stub class need not be marked as Serializable)
		 * - references to EJB local interfaces (need not be marked as Serializable)
		 * - SessionContext (need not be marked as Serizaliable)
		 * - references to the environment naming context
		 * - UserTransaction
		 * - resource manager connection factory
		 * - container-managed EntityManager
		 * - container-managed EntityManagerFactory
		 * - javax.ejb.Timer
		 * 
		 */

		/*
		 * beans should close JDBC connection and set connections to null in
		 * PrePassivate
		 */

		/* there are object replacement techniques used in these classes */
		ObjectOutputStream.class.getName();
		ObjectInputStream.class.getName();

		/*
		 * container may destroy bean instances that do not meet the
		 * requirements for passivation
		 */

		section("CORE.4.2.2", RS.COMPLETED);

		/* conversational state is not transactional */
		/*
		 * i.e. it is not automatically rolled back when the transaction in
		 * which it has participated is rolled back
		 */

		/*
		 * bean developer should use afterCompletion notification if specific
		 * rollback actions are required
		 */

		section("CORE.4.3", RS.COMPLETED);

		section("CORE.4.3.1", RS.COMPLETED);

		/* the following annotations may be applied on bean classes */

		Stateless.class.isAnnotation();
		Stateful.class.isAnnotation();
		Singleton.class.isAnnotation();

		/*
		 * they are not mandatory, as the same effect can be achieved with
		 * declarations in the deployment descriptor
		 */

		section("CORE.4.3.2", RS.COMPLETED);

		/* focus of the SessionContext */

		SessionContext.class.getName();

		{ // Case 1 : explicit injection
			@SuppressWarnings("unused")
			class MyBean {
				@Resource
				private SessionContext sessionContext;
			}
		}

		{ // Case 2 : using SessionBean
			@SuppressWarnings("unused")
			class MyBean implements SessionBean {

				private static final long serialVersionUID = 1L;

				private SessionContext sessionContext;

				@Override
				public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {
					sessionContext = ctx;
				}

				@Override
				public void ejbRemove() throws EJBException, RemoteException {
				}

				@Override
				public void ejbActivate() throws EJBException, RemoteException {
				}

				@Override
				public void ejbPassivate() throws EJBException, RemoteException {
				}
			}
		}

		{ // Case 3 : relying on the deployment descriptor
			@SuppressWarnings("unused")
			class MyBean {
				private SessionContext sessionContext;
			}
			// use resource-env-ref in deployment descriptor
		}

		section("CORE.4.3.3", RS.COMPLETED);

		{
			// identify the invokers
			principal = sessionContext.getCallerPrincipal();

			// test for roles
			callerInRole = sessionContext.isCallerInRole(identity);
			callerInRole = sessionContext.isCallerInRole(roleName);

			// mark the current transaction so that the only possible outcome is
			// a rollback
			sessionContext.setRollbackOnly();
			rollbackOnly = sessionContext.getRollbackOnly();

			// requires bean-managed transaction demarcation
			userTransaction = sessionContext.getUserTransaction();

			// only stateless and singleton bean can use this method
			timerService = sessionContext.getTimerService();

			businessObject = sessionContext.getBusinessObject(businessInterface);
			invokedBusinessInterface = sessionContext.getInvokedBusinessInterface();
			ejbObject = sessionContext.getEJBObject();
			ejbHome = sessionContext.getEJBHome();
			ejbLocalObject = sessionContext.getEJBLocalObject();
			ejbLocalHome = sessionContext.getEJBLocalHome();

			// JNDI lookup
			object = sessionContext.lookup(name);

			// asynchronous call was canceled
			wasCancelled = sessionContext.wasCancelCalled();

			// to retrieve or update interceptor or webservice context data
			contextData = sessionContext.getContextData();
		}

		section("CORE.4.3.3.1", RS.COMPLETED);

		/* if using JAX-WS, prefer WebServiceContext or MessageContext */

		WebServiceContext.class.getName();
		MessageContext.class.getName();

		section("CORE.4.3.4", RS.COMPLETED);

		{
			class MyBean {

				@AroundConstruct
				public void aroundConstruct() {
				}

				@PostConstruct
				public void postConstruct() {

					// after dependency injection
					// before first business method invocation

					// transaction context:
					/*-
					 * - stateless bean : unspecified
					 * - singleton bean : function of bean's transaction management type and transaction attributes
					 * - statefull : lifecycle callback method's transaction attribute
					 */

				}

				@PreDestroy
				public void preDestroy() {

					// unspecified security context

					// transaction context as for PostConstruct

					// release resources here
				}

				@PrePassivate
				public void prePassivate() {
					// stateful bean are passivation capable by default
					// unspecified security context
					/*
					 * transaction context determined by the lifecycle callback
					 * method's transaction attribute
					 */
				}

				@PostActivate
				public void postActivate() {

				}
			}
		}

		section("CORE.4.3.5", RS.COMPLETED);

		/*
		 * Under EJB 3.x, session beans are no longer required to implement
		 * SessionBean or Serializable
		 */

		sessionBean.setSessionContext(sessionContext);
		sessionBean.ejbRemove(); // corresponds to @PreDestroy
		sessionBean.ejbPassivate(); // corresponds to @PrePassivate
		sessionBean.ejbActivate(); // corresponds to @PostActivate

		section("CORE.4.3.6", RS.COMPLETED);

		/* three possibilities */

		{ // interface
			class MyBean implements SessionSynchronization {

				@Override
				public void afterBegin() throws EJBException, RemoteException {

				}

				@Override
				public void beforeCompletion() throws EJBException, RemoteException {

				}

				@Override
				public void afterCompletion(boolean committed) throws EJBException, RemoteException {

				}

			}
		}

		{ // annotations
			class MyBean {
				@AfterBegin
				public void afterBegin() {

				}

				@BeforeCompletion
				public void beforeCompletion() {

				}

				@AfterCompletion
				public void afterCompletion(boolean committed) {

				}
			}
		}

		{ // annotations
			class MyBean {
				public void afterBegin() {

				}

				public void beforeCompletion() {

				}

				public void afterCompletion(boolean committed) {

				}
			}
			// information in deployment descriptor
		}

		/*
		 * session synchronization methods may be public, protected, package or
		 * private
		 */
		/* session synchronization methods cannot be final or static */

		/*
		 * only stateful bean with container-managed transaction demarcation can
		 * receive session synchronization notifications
		 */

		section("CORE.4.3.7", RS.COMPLETED);

		section("CORE.4.3.8", RS.COMPLETED);

		section("CORE.4.3.9", RS.COMPLETED);

		/*
		 * The semantic of AroundConstruct is defined in the Interceptors
		 * specification
		 */

		section("CORE.4.3.9.1", RS.COMPLETED);

		section("CORE.4.3.9.2", RS.COMPLETED);

		section("CORE.4.3.10", RS.COMPLETED);

		{
			class MyBean {

				// several remove methods are possible

				@Remove
				public void remove1() {

				}

				@Remove(retainIfException = true)
				public void remove2() {
					// bean won't be removed here
					throw new RuntimeException();
				}

				@Remove(retainIfException = false)
				public void remove3() {
					// bean will be removed here
					throw new RuntimeException();
				}
			}
		}

		/*- in XML deployment descriptor: 
		 * - remove-method
		 * - retain-if-exception */

		section("CORE.4.3.11", RS.COMPLETED);

		/*
		 * The container may remove idle stateful session beans after a
		 * specified timeout
		 */

		{
			@StatefulTimeout(value = 1, unit = TimeUnit.HOURS)
			class MyBean {

			}
		}

		// in XML : stateful-timeout

		section("CORE.4.3.12", RS.COMPLETED);

		AroundInvoke.class.isAnnotation();

		/* afterBegin occurs before AroundInvoke */
		/* beforeCompletion occurs after AroundInvoke */

		section("CORE.4.3.13", RS.COMPLETED);

		/* this applies to stateless and stateful session beans */

		/*
		 * stateless and stateful session beans do not have to be coded as
		 * reentrant
		 */

		/* calls to session beans are serialized */

		{

			@AccessTimeout(value = 0)
			class MyBean {

			}
		}

		/* in XML : access-timeout */

		/* calling this bean may throw ConcurrentAccessException */
		ConcurrentAccessException.class.getName();

		/* in EJB 2.1, it will throw RemoteException or EJBException instead */
		RemoteException.class.getName();
		EJBException.class.getName();

		section("CORE.4.3.13.1", RS.COMPLETED);

		{
			class MyBean {
				@AccessTimeout(value = -1)
				public void foo() {
					// calls to foo can wait indefinitely
				}

				@AccessTimeout(value = 1, unit = TimeUnit.MINUTES)
				public void bar() {
					// calls to bar can wait up to one minute
				}
			}
		}

		section("CORE.4.3.14", RS.COMPLETED);

		/* about transaction contexts */

		section("CORE.4.4", RS.COMPLETED);

		section("CORE.4.4.1", RS.COMPLETED);

		/*- java:global[/<app-name>]/<module-name>/<bean-name>[!<fully-qualified-interface-name>] */

		/*
		 * <app-name> only applies if the session bean is packaged within an
		 * .ear file ; defaults to basename of the .ear file, unless overriden
		 * in the application.xml deployment descriptor
		 */

		/*- <module-name> :
		* - basename of standalone ejb-jar file or .war files
		* - path to module in .ear files, with file extension removed, unless overriden in application deployment descriptor
		 */

		/*- <bean-name> :
		 * unqualified name of the session bean class, unless specified on the Stateless, Stateful, or Singleton annotations
		 * or as specified in the ejb-name deployment descriptor element.
		 */

		toReadAgain();

		/*
		 * JNDI names must also be made available in the java:app and
		 * java:module namespace
		 */

		section("CORE.4.4.1.1", RS.COMPLETED);

		/*- java:app/<module-name>/<bean-name>[!<fully-qualified-interface-name>] */

		section("CORE.4.4.1.2", RS.COMPLETED);

		/*- java:module/<bean-name>[!<fully-qualified-interface-name>] */

		section("CORE.4.4.2", RS.COMPLETED);
		section("CORE.4.4.2.1", RS.COMPLETED);

		// FooBean, which implements Foo, in fooejb.jar

		/*-
		 * - java:global/fooejb/FooBean
		 * - java:global/fooejb/FooBean!com.acme.Foo
		 * - java:app/fooejb/FooBean
		 * - java:app/fooejb/FooBean!com.acme.Foo
		 * - java:module/FooBean
		 * - java:module/FooBean!com.acme.Foo
		 */

		// FooBean, which implements Foo, in fooejb.jar in fooapp.ear

		/*-
		 * - java:global/fooapp/fooejb/FooBean
		 * - java:global/fooapp/fooejb/FooBean!com.acme.Foo
		 * - java:app/fooejb/FooBean
		 * - java:app/fooejb/FooBean!com.acme.Foo*
		 * - java:module/FooBean
		 * - java:module/FooBean!com.acme.Foo
		 */

		// FooBean, which implements Foo, in fooweb.war

		/*-
		 * - java:global/fooweb/FooBean
		 * - java:global/fooweb/FooBean!com.acme.Foo
		 * - java:app/fooweb/FooBean
		 * - java:app/fooweb/FooBean!com.acme.Foo
		 * - java:module/FooBean
		 * - java:module/FooBean!com.acme.Foo
		* */

		// FooBean, which implements Foo, in fooweb.war in fooapp.ear

		/*-
		 * - java:global/fooapp/fooweb/FooBean
		 * - java:global/fooapp/fooweb/FooBean!com.acme.Foo
		 * - java:app/fooweb/FooBean
		 * - java:app/fooweb/FooBean!com.acme.Foo
		 * - java:module/FooBean
		 * - java:module/FooBean!com.acme.Foo
		 */

		section("CORE.4.4.2.2", RS.COMPLETED);

		{ // Singleton bean exposing multiple views
			@Singleton(name = "Shared")
			@LocalBean
			@Remote(Object.class/* com.acme.SharedRemote.class */)
			class SharedBean {

			}
		}

		// packaged in shared.jar and deployed as a standalone module

		/*-
		 * - java:global/shared/Shared!com.acme.SharedBean
		 * - java:global/shared/Shared!com.acme.SharedRemote
		 * - java:app/shared/Shared!com.acme.SharedBean
		 * - java:app/shared/Shared!com.acme.SharedRemote
		 * - java:module/Shared!com.acme.SharedBean
		 * - java:module/Shared!com.acme.SharedRemote
		*/

		section("CORE.4.5", RS.COMPLETED);

		section("CORE.4.5.1", RS.COMPLETED);

		{
			class MyBean {
				@Asynchronous
				public void foo() {
					// this method is asynchronous
				}
			}

			@Asynchronous
			class MyAsynchronousBean {
				public void foo() {
				}
			}
		}
		/*-
		 * - no-interface client view : Asynchronous method invocation semantics applies 
		 * - local business client view : Asynchronous method invocation semantics applies
		 * - remote business client view : Asynchronous method invocation semantics applies
		 * - local component : Asynchronous method invocation semantics DOES NOT apply
		 * - remote component : Asynchronous method invocation semantics DOES NOT apply
		 * - web service client view : Asynchronous method invocation semantics DOES NOT apply
		*/

		section("CORE.4.5.2", RS.COMPLETED);

		section("CORE.4.5.2.1", RS.COMPLETED);
		{ // these are the two possible return types
			class MyBean {
				@Asynchronous
				public void foo() {

				}

				@Asynchronous
				public Future<String> bar() {
					return new AsyncResult<String>("result");
				}
			}
		}

		section("CORE.4.5.2.2", RS.COMPLETED);

		future.cancel(mayInterruptIfRunning);
		sessionContext.wasCancelCalled();

		section("CORE.4.5.3", RS.COMPLETED);

		/*
		 * The client’s transaction context does not propagate with an
		 * asynchronous method invocation.
		 */

		/*
		 * This implies that the semantics of the REQUIRED transaction attribute
		 * on an asynchronous method are exactly the same as REQUIRES_NEW.
		 */

		section("CORE.4.5.4", RS.COMPLETED);

		/*
		 * The caller security principal propagates with an asynchronous method
		 * invocation.
		 */

		section("CORE.4.5.5", RS.COMPLETED);

		/* void asynchronous methods can not report exceptions */

		{ // getting the asynchronous exception

			Object result = future.get();

			if (result instanceof ExecutionException) {
				Throwable asynchronousException = ((ExecutionException) result).getCause();
			}
		}

		section("CORE.4.6", RS.COMPLETED);

		section("CORE.4.6.1", RS.COMPLETED);

		/*
		 * An invocation of a transactional method causes the instance to be
		 * included in a transaction
		 */

		/*
		 * An error occurs if a client attempts to invoke a method on the
		 * session object and the bean’s metadata annotations and/or deployment
		 * descriptor for the method requires that the container invoke the
		 * method in a different transaction context than the one with which the
		 * instance is currently associated or in an unspecified transaction
		 * context.
		 */

		section("CORE.4.6.2", RS.COMPLETED);

		section("CORE.4.6.3", RS.COMPLETED);

		/* RuntimeException induces the "does not exist" state */

		section("CORE.4.6.4", RS.COMPLETED);

		/* PreDestroy methods are not guaranteed to be called */

		/* a mechanism should be provided to clean up resources periodically */

		section("CORE.4.6.5", RS.COMPLETED);

		{
			@Stateful(passivationCapable = false)
			class MyBean {
			}
		}

		// in XML : passivation-capable

		section("CORE.4.6.6", RS.COMPLETED);

		/*
		 * REQUIRES_NEW or NOT_SUPPORTED transaction attributes are allowed on
		 * PostConstruct, PreDestroy, PrePassivate and PostActivate for stateful
		 * session beans which use container-managed transaction demarcation
		 */

		section("CORE.4.6.7", RS.COMPLETED);

		/*
		 * clients must not call methods that require no transaction in the
		 * middle of transactions, or something
		 */

		/*
		 * calling remove will trigger exception within transaction, but should
		 * not induce a rollback
		 */

		section("CORE.4.7", RS.COMPLETED);

		/* all idle stateless bean instances are equivalent */

		/*
		 * reference to bean instance variables should not be returned through
		 * local method calls
		 */

		/*
		 * stateless session beans must not implement SessionSynchronization
		 */

		section("CORE.4.7.1", RS.COMPLETED);
		section("CORE.4.7.2", RS.COMPLETED);

		section("CORE.4.7.3", RS.COMPLETED);

		/* RuntimeException induce the "not exist" state */

		/*
		 * but client do not really care since next method call will be
		 * dispatched to another instance of the bean
		 */

		section("CORE.4.8", RS.COMPLETED);

		section("CORE.4.8.1", RS.COMPLETED);
		/* singleton session bean are instanciated once per application */

		/* singleton session beans are supposed to support concurrent access */

		{ // this bean features eager initialization and depdency other a bean
			// defined in another module
			@Startup
			@Singleton
			@DependsOn(value = "b.jar#myOtherBean")
			class MyBean {

			}

		}

		section("CORE.4.8.2", RS.COMPLETED);

		section("CORE.4.8.3", RS.COMPLETED);

		// REQUIRED, REQUIRES_NEW, or NOT_SUPPORTED in PostConstruct or
		// PreDestroy

		section("CORE.4.8.4", RS.COMPLETED);

		/*
		 * exceptions from business methods do not result in the destruction of
		 * singleton beans
		 */

		section("CORE.4.8.5", RS.COMPLETED);

		/*-
		 * - container-managed concurrency (default)
		 * - bean-managed concurrency
		 */

		/*
		 * references to objects which do not support concurrency should be used
		 * with care
		 */

		/*
		 * Special locking semantics apply to loopback calls on singleton
		 * session beans with container-managed concurrency
		 */

		section("CORE.4.8.5.1", RS.COMPLETED);

		/* ConcurrentAccessTimeoutException may be thrown */

		section("CORE.4.8.5.1.1", RS.COMPLETED);

		/*
		 * IllegalLoopbackException may be thrown if a read-lock method invokes
		 * a write-lock method
		 */

		section("CORE.4.8.5.2", RS.COMPLETED);

		/* with bean-managed concurrency, but bean has full concurrent access */

		/* it may use synchronized and volatile as anywhere else */

		section("CORE.4.8.5.3", RS.COMPLETED);

		{ // container-managed concurrency
			@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
			class MyBean {

			}
		}

		{ // bean-managed concurrency
			@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
			class MyBean {

			}
		}

		section("CORE.4.8.5.4", RS.COMPLETED);

		/* bean methods get write lock by default */

		{
			class MyBean {

				@Lock(LockType.READ)
				public void foo() {

				}

				@Lock(LockType.WRITE)
				public void bar() {

				}
			}
		}

		section("CORE.4.8.5.5", RS.COMPLETED);

		AccessTimeout.class.isAnnotation();
		// -1 : block indefinitely
		// 0 : concurrent access not allowed
		ConcurrentAccessTimeoutException.class.getName();
		ConcurrentAccessException.class.getName();

		section("CORE.4.8.6", RS.COMPLETED);

		section("CORE.4.9", RS.COMPLETED);

		section("CORE.4.9.1", RS.COMPLETED);

		/*- bean provider must provide
		 * - session bean class
		 * - session bean business interface (EJB 3.x local or remote view)
		 * - session bean remote interface and remote home interface (EJB 2.1 remote client view)
		 * - session bean local interface and local home interface (EJB 2.1 local client view)
		 * - session bean web service interface
		 * - interceptor classes
		 */

		section("CORE.4.9.2", RS.COMPLETED);

		/*-
		 * - session bean class must be public
		 * - session bean class must be not final
		 * - session bean class must be not abstract
		 * - session bean class must have a public default constructor
		 * - session bean class must not define finalize()
		 * - session bean must implement the business interface, if there is one
		 * - session bean must implement the business methods of the EJB 2.1 client view, if there is one
		 * - session bean class may have an additional constructor annotated with the Inject annotation
		 * - session bean class may implement SessionBean
		 * - @Stateful session bean class may implement SessionSynchronization
		 * - session bean class may implement the web service endpoint or component interface
		 * - @Stateless session bean class may implement TimedObject
		 * - session bean class may implement ejbCreate() methods
		 * - session bean class may have superclasses or superinterfaces, which may be annotated too
		 */

		{
			class MyBean {
				public MyBean() {
				}

				@Inject
				public MyBean(String foo) {

				}
			}
		}

		section("CORE.4.9.2.1", RS.COMPLETED);

		/*
		 * implementation inheritance, but not component inheritance semantics
		 */

		section("CORE.4.9.3", RS.COMPLETED);

		/*
		 * The AroundConstruct lifecycle callback interceptor method may be
		 * defined on an interceptor class only.
		 */

		section("CORE.4.9.4", RS.COMPLETED);

		/*-
		 * - The method may have any access type: public, private, protected, or package-level.
		 * - The return type must be void.
		 * - The AfterBegin and BeforeCompletion methods must take 0 arguments.
		 * - The AfterCompletion method must take a single argument of type boolean
		 * */

		section("CORE.4.9.5", RS.COMPLETED);

		section("CORE.4.9.6", RS.COMPLETED);

		/*-
		 * - The method names can be arbitrary, but they must not start with “ejb” to avoid conflicts with the callback methods used by the EJB architecture.
		 * - The method must be declared as public.
		 * - The method must not be declared as final or static.
		 * - The argument and return value types for the method must be legal types for RMI/IIOP if the method corresponds to a business method on the session bean’s remote business interface or remote component interface.
		 * - The argument and return value types for a method must be legal types for JAX-WS if the method is a web service method or corresponds to a method on the session bean’s web service endpoint.
		 * - The throws clause may define arbitrary application exceptions
		 */

		section("CORE.4.9.7", RS.COMPLETED);

		/* THIS SECTION IS POSSIBLY THE MOST IMPORTANT IN THE WHOLE BOOK */

		important();

		/*- bottom line
		 * - implemented interfaces are interpreted as local business interfaces
		 * - unless @Remote is used somewhere
		 */

		Local.class.isAnnotation();
		Remote.class.isAnnotation();

		section("CORE.4.9.8", RS.COMPLETED);

		LocalBean.class.isAnnotation();

		/*
		 * this cause the all implemented interfaces to be ignored wrt. to local
		 * views
		 */

		section("CORE.4.9.9", RS.COMPLETED);

		section("CORE.4.9.10", RS.COMPLETED);
		section("CORE.4.9.11", RS.COMPLETED);
		section("CORE.4.9.12", RS.COMPLETED);
		section("CORE.4.9.13", RS.COMPLETED);

		section("CORE.4.10", RS.COMPLETED);

		section("CORE.4.10.1", RS.COMPLETED);
		section("CORE.4.10.2", RS.COMPLETED);
		section("CORE.4.10.3", RS.COMPLETED);
		section("CORE.4.10.4", RS.COMPLETED);
		section("CORE.4.10.5", RS.COMPLETED);
		section("CORE.4.10.6", RS.COMPLETED);
		section("CORE.4.10.7", RS.COMPLETED);
		section("CORE.4.10.8", RS.COMPLETED);
		section("CORE.4.10.9", RS.COMPLETED);
		section("CORE.4.10.10", RS.COMPLETED);
		section("CORE.4.10.11", RS.COMPLETED);
		section("CORE.4.10.12", RS.COMPLETED);
		section("CORE.4.10.13", RS.COMPLETED);

		/*
		 * an application cannot make loopback calls to a stateless or stateful
		 * session bean instance
		 */

		section("CORE.4.10.14", RS.COMPLETED);
		section("CORE.4.10.15", RS.COMPLETED);
		section("CORE.4.10.16", RS.COMPLETED);

		section("CORE.5", RS.COMPLETED);
		section("CORE.5.1", RS.COMPLETED);

		/* message driven beans are anonymous */

		section("CORE.5.2", RS.COMPLETED);
		section("CORE.5.3", RS.COMPLETED);

		{ // message bean injection
			class MyComponent {
				@Resource
				Queue myJmsQueue;
			}
		}

		{
			Context initialContext = new InitialContext();
			Queue myJmsQueue = (Queue) initialContext.lookup("java:comp/env/jms/myJmsQueue");
		}

		section("CORE.5.4", RS.COMPLETED);

		section("CORE.5.4.1", RS.COMPLETED);

		/*
		 * A message-driven bean must be annotated with the MessageDriven
		 * annotation or denoted in the deployment descriptor as a
		 * message-driven bean.
		 */

		{
			@MessageDriven
			class MyMessageBean {
			}
		}

		section("CORE.5.4.2", RS.COMPLETED);

		constructANewInstanceOf(MessageDriven.class).messageListenerInterface();

		/* default to the one implemented by the bean */

		/* possible interface to implement : */

		MessageListener.class.getName();

		/*
		 * in XML : messaging-type element of the message-driven deployment
		 * descriptor element
		 */

		section("CORE.5.4.3", RS.COMPLETED);

		/*
		 * A message-driven bean is permitted to implement a listener interface
		 * with no methods. => similare to no-interface session beans
		 */

		section("CORE.5.4.4", RS.COMPLETED);

		{
			@MessageDriven
			class MyBean {
				@Resource
				MessageDrivenContext messageDrivenContext;
			}
		}

		{
			@MessageDriven
			class MyBean implements MessageDrivenBean {

				private static final long serialVersionUID = 1L;

				@Override
				public void setMessageDrivenContext(MessageDrivenContext ctx) throws EJBException {
				}

				@Override
				public void ejbRemove() throws EJBException {
				}
			}
		}

		section("CORE.5.4.5", RS.COMPLETED);

		messageDrivenContext.setRollbackOnly();
		messageDrivenContext.getRollbackOnly();
		messageDrivenContext.getUserTransaction();
		messageDrivenContext.getTimerService();
		messageDrivenContext.getCallerPrincipal();
		messageDrivenContext.isCallerInRole(identity);
		messageDrivenContext.isCallerInRole(roleName);
		messageDrivenContext.getEJBHome();
		messageDrivenContext.getEJBLocalHome();
		messageDrivenContext.lookup(name);
		messageDrivenContext.getContextData();

		section("CORE.5.4.6", RS.COMPLETED);

		{
			@MessageDriven
			class MyBean {
				@AroundConstruct
				public void foo() {
				}

				@PostConstruct
				public void bar() {
				}

				@PreDestroy
				public void baz() {
				}
			}
		}

		section("CORE.5.4.7", RS.COMPLETED);
		section("CORE.5.4.8", RS.COMPLETED);

		section("CORE.5.4.9", RS.COMPLETED);

		section("CORE.5.4.10", RS.COMPLETED);

		/* this annotation is supported on MDBs */
		AroundInvoke.class.isAnnotation();

		section("CORE.5.4.11", RS.COMPLETED);

		section("CORE.5.4.12", RS.COMPLETED);

		/*
		 * Message-driven beans should therefore be prepared to handle messages
		 * that are out of sequence: for example, the message to cancel a
		 * reservation may be delivered before the message to make the
		 * reservation.
		 */

		section("CORE.5.4.13", RS.COMPLETED);

		section("CORE.5.4.14", RS.COMPLETED);

		{
			@MessageDriven
			@RunAs("toto")
			class MyBean {
			}
		}

		section("CORE.5.4.15", RS.COMPLETED);

		/*
		 * A message-driven bean is associated with a destination or endpoint
		 * when the bean is deployed in the container.
		 */

		section("CORE.5.4.16", RS.COMPLETED);

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "foo", propertyValue = "bar") })
			class MyBean {

			}
		}

		// activation-config in XML
		// activation-config-property in XML

		section("CORE.5.4.17", RS.COMPLETED);

		/* there's a built-in JMS provided in the container */

		section("CORE.5.4.17.1", RS.COMPLETED);

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
			class MyJMSBean {

			}
		}

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Dups-ok-acknowledge") })
			class MyJMSBean {

			}
		}

		section("CORE.5.4.17.2", RS.COMPLETED);

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JMSType = 'car' AND color = 'blue' AND weight > 2500") })
			class MyJMSBean {

			}
		}

		section("CORE.5.4.17.3", RS.COMPLETED);

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
			class MyJMSBean {

			}
		}

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
			class MyJMSBean {

			}
		}

		section("CORE.5.4.17.4", RS.COMPLETED);

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queueOrTopicName") })
			class MyJMSBean {

			}
		}
		section("CORE.5.4.17.5", RS.COMPLETED);

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "connectionFactoryLookup.", propertyValue = "connectionFactoryName") })
			class MyJMSBean {

			}
		}

		section("CORE.5.4.17.6", RS.COMPLETED);

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
					@ActivationConfigProperty(propertyName = "subscriptionDurability.", propertyValue = "Durable") })
			class MyJMSBean {

			}
		}

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
					@ActivationConfigProperty(propertyName = "subscriptionDurability.", propertyValue = "NonDurable") })
			class MyJMSBean {

			}
		}

		/*
		 * The Deployer should avoid associating more than one message-driven
		 * bean with the same JMS queue. If there are multiple JMS consumers for
		 * a queue, JMS does not define how messages are distribued between the
		 * queue receivers.
		 */

		section("CORE.5.4.17.7", RS.COMPLETED);

		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
					@ActivationConfigProperty(propertyName = "subscriptionDurability.", propertyValue = "Durable"),
					@ActivationConfigProperty(propertyName = "subscriptionName.", propertyValue = "nameOfTheSubscription") })
			class MyJMSBean {

			}
		}

		/*
		 * The Bean Provider or Deployer cannot specify whether a shared or
		 * unshared subscription will be used.
		 */

		section("CORE.5.4.17.8", RS.COMPLETED);
		{
			@MessageDriven(activationConfig = {
					@ActivationConfigProperty(propertyName = "clientId", propertyValue = "clientIdentifier") })
			class MyJMSBean {

			}
		}

		section("CORE.5.4.18", RS.COMPLETED);

		/*
		 * A message-driven bean’s message listener method must not throw the
		 * java.rmi.RemoteException.
		 */

		/*
		 * Message-driven beans should not, in general, throw RuntimeExceptions
		 * ; they induce "does not exist" state.
		 */

		/* application exception are propagated to the client */

		section("CORE.5.4.19", RS.COMPLETED);
		section("CORE.5.4.20", RS.COMPLETED);

		/* JMS replies should use the same mode */

		Queue.class.getName();
		Topic.class.getName();

		section("CORE.5.5", RS.COMPLETED);
		section("CORE.5.5.1", RS.COMPLETED);
		section("CORE.5.6", RS.COMPLETED);
		section("CORE.5.6.1", RS.COMPLETED);
		section("CORE.5.6.2", RS.COMPLETED);

		section("CORE.5.6.3", RS.COMPLETED);
		section("CORE.5.6.4", RS.COMPLETED);
		section("CORE.5.6.5", RS.COMPLETED);
		section("CORE.5.6.6", RS.COMPLETED);
		section("CORE.5.7", RS.COMPLETED);
		section("CORE.5.7.1", RS.COMPLETED);
		section("CORE.5.7.2", RS.COMPLETED);
		section("CORE.5.7.3", RS.COMPLETED);
		section("CORE.5.7.4", RS.COMPLETED);
		section("CORE.5.7.5", RS.COMPLETED);
		section("CORE.5.7.6", RS.COMPLETED);

		section("CORE.6", RS.COMPLETED);

		section("CORE.7", RS.COMPLETED);
		section("CORE.7.1", RS.COMPLETED);

		/* see the Interceptors specification */

		/*
		 * JTA transactional interceptors must not be associated to session and
		 * message driven beans
		 */

		/*
		 * default interceptors apply to all components within an ejb-jar files
		 * or .war file
		 */

		section("CORE.7.2", RS.COMPLETED);

		/*
		 * AroundConstruct, PostConstruct and PreDestroy support is required by
		 * the Interceptors specification
		 */

		/* EJB adds PostActivate and PrePassivate */

		/*
		 * The use of an extended persistence context is only supported for
		 * interceptors that are associated with stateful session beans.
		 */

		section("CORE.7.3", RS.COMPLETED);

		/*
		 * AroundInvoke interceptor methods may be defined for business methods
		 * of sessions beans and for the message listener methods of
		 * message-driven beans.
		 */

		/*
		 * Business method interceptor methods may throw runtime exceptions or
		 * application exceptions that are allowed in the throws clause of the
		 * business method.
		 */

		section("CORE.7.4", RS.COMPLETED);

		AroundTimeout.class.isAnnotation();

		/* AroundTimeout can only throw system exceptions */

		section("CORE.7.5", RS.COMPLETED);

		/*
		 * AroundConstruct lifecycle callback interceptor method may be defined
		 * on an interceptor class only
		 */

		section("CORE.7.6", RS.COMPLETED);

		/* InvocationContext, getContextData */

		section("CORE.7.7", RS.COMPLETED);

		/* interceptor can throw exceptions */

		/* interceptor can recover by calling proceed() */

		/* interceptor can mark a transaction for rollback */

		section("CORE.7.8", RS.COMPLETED);

		section("CORE.7.8.1", RS.COMPLETED);

		// in XML : interceptor, around-invoke, around-timeout,
		// around-construct, post-construct, pre-destroy, pre-passivate, and
		// post-activate */

		section("CORE.7.8.2", RS.COMPLETED);

		/*
		 * In XML : interceptor-binding, target-name, interceptor-class,
		 * nterceptor-order, exclude-default-interceptors,
		 * exclude-class-interceptors, method-name, method-params
		 */

		/*
		 * Default interceptors are bound to all target classes in a module
		 * using the wildcard syntax "*".
		 */

		/*-
		 
			<interceptor-binding>
				<target-name>*</target-name>
				<interceptor-class>INTERCEPTOR</interceptor-class>
			</interceptor-binding>
		
			<interceptor-binding>
				<target-name>TARGETNAME</target-name>
				<interceptor-class>INTERCEPTOR</interceptor-class>
			</interceptor-binding>
		
			<interceptor-binding>
				<target-name>TARGETNAME</target-name>
				<interceptor-class>INTERCEPTOR</interceptor-class>
				<method-name>METHOD</method-name>
			</interceptor-binding>
		
			<interceptor-binding>
				<target-name>TARGETNAME</target-name>
				<interceptor-class>INTERCEPTOR</interceptor-class>
				<method-name>METHOD</method-name>
				<method-params>
					<method-param>PARAM-1</method-param>
					<method-param>PARAM-2</method-param>
					...
					<method-param>PARAM-n</method-param>
				</method-params>
			<interceptor-binding>
		  
		 */

		section("CORE.7.8.2.1", RS.COMPLETED);

		/* some examples in XML */

		section("CORE.8", RS.COMPLETED);

		section("CORE.8.1", RS.COMPLETED);
		section("CORE.8.1.1", RS.COMPLETED);

		/* bean-managed transaction demarcation */

		userTransaction.begin();
		userTransaction.commit();
		userTransaction.rollback();

		/* container-managed transaction demarcation */

		/* = transaction attributes */

		/*
		 * notion of an external transaction manager.
		 */

		section("CORE.8.1.2", RS.COMPLETED);

		/*
		 * EJB supports flat transactions, which cannot have nested transactions
		 */

		section("CORE.8.1.3", RS.COMPLETED);

		/* EJB requires JTA and JCA support, but not JTS support */

		section("CORE.8.2", RS.COMPLETED);

		section("CORE.8.2.1", RS.COMPLETED);

		/* update data in multiple databases in a single transaction. */

		section("CORE.8.2.2", RS.COMPLETED);

		/* message delivery and databases updates can be transactional */

		section("CORE.8.2.3", RS.COMPLETED);

		/*
		 * several beans on different server can be part of the same transaction
		 */
		section("CORE.8.2.4", RS.COMPLETED);

		section("CORE.8.2.5", RS.COMPLETED);
		section("CORE.8.3", RS.COMPLETED);

		section("CORE.8.3.1", RS.COMPLETED);

		section("CORE.8.3.1.1", RS.COMPLETED);

		/*
		 * If an enterprise bean needs to access a resource manager that does
		 * not support an external transaction coordinator, the Bean Provider
		 * should design the enterprise bean with container-managed transaction
		 * demarcation and assign the NOT_SUPPORTED transaction attribute
		 */

		section("CORE.8.3.2", RS.COMPLETED);

		/*
		 * The API for managing an isolation level is resource-manager-specific
		 */

		/*
		 * the Bean Provider may specify the same or different isolation level
		 * for each resource manager
		 */

		/*
		 * An attempt to change the isolation level in the middle of a
		 * transaction may cause undesirable behavior
		 */

		/*
		 * Additional care must be taken if multiple enterprise beans access the
		 * same resource manager in the same transaction. Conflicts in the
		 * requested isolation levels must be avoided.
		 */

		section("CORE.8.3.3", RS.COMPLETED);

		/*
		 * question p 169 : how do the connection know about the coupled
		 * transaction ?
		 */

		section("CORE.8.3.3.1", RS.COMPLETED);

		/*
		 * An enterprise bean with bean-managed transaction demarcation must not
		 * use the getRollbackOnlyand setRollbackOnly methods of the EJBContext
		 * interface.
		 */

		section("CORE.8.3.4", RS.COMPLETED);

		/*
		 * with container-managed transaction demarcation, resource-manager
		 * specific transaction management methods that mayh interfere with the
		 * container should not be used
		 */

		/* examples include: */

		connection.commit();
		connection.setAutoCommit(autoCommit);
		connection.rollback();
		session.commit();
		session.rollback();

		/* getting a UserTransaction is forbidden */

		{
			@Stateless
			class MyBean {
				@TransactionAttribute(TransactionAttributeType.REQUIRED)
				public void foo() {

				}
			}
		}

		section("CORE.8.3.4.1", RS.COMPLETED);

		section("CORE.8.3.4.2", RS.COMPLETED);

		/*
		 * setRollbackOnlymethod of its EJBContext object to mark the
		 * transaction such that the transaction can never commit. Typically, an
		 * enterprise bean marks a transaction for rollback to protect data
		 * integrity before throwing an application exception, if the
		 * application exception class has not been specified to automatically
		 * cause the container to rollback the transaction
		 */

		section("CORE.8.3.4.3", RS.COMPLETED);
		section("CORE.8.3.5", RS.COMPLETED);

		/*
		 * The Bean Provider should not make use of the JMS request/reply
		 * paradigm within a single transaction.
		 */

		/*- with container-managed transaction, parameters to 
		 * - createSession(boolean transacted, int acknowledgeMode)
		 * - createQueueSession(boolean transacted, int acknowledgeMode) 
		 * - createTopicSession(boolean transacted, int acknowledgeMode)
		 * are ignored ; recommande to be true and 0 resp.
		 */

		/* The Bean Provider should not use the JMS acknowledge method */

		section("CORE.8.3.6", RS.COMPLETED);

		{
			@TransactionManagement(TransactionManagementType.BEAN)
			class MyBean {

			}
		}

		// In XML : transaction-type

		section("CORE.8.3.7", RS.COMPLETED);

		/* default transaction demarcation is REQUIRED */

		/*
		 * business method, message listener method, timeout callback method,
		 * web service endpoint method, PostConstruct, PreDeploy, PrePassivate,
		 * PostActivate
		 */

		/*
		 * the transactional structure of an application is typically intrinsic
		 * to the semantics of the application
		 */

		TransactionAttributeType.MANDATORY.name(); // Mandatory in XML
		TransactionAttributeType.REQUIRED.name(); // Required in XML
		TransactionAttributeType.REQUIRES_NEW.name(); // RequiresNew in XML
		TransactionAttributeType.SUPPORTS.name(); // Supports in XML
		TransactionAttributeType.NOT_SUPPORTED.name(); // NotSupported in XML
		TransactionAttributeType.NEVER.name(); // Never in XML

		/*-
		 * - message listener : REQUIRED or NOT_SUPPORTED
		 * - timeout : REQUIRED, REQUIRES_NEW or NOT_SUPPORTED
		 * - asynchronous method : REQUIRED, REQUIRES_NEW or NOT_SUPPORTED
		 * - PostConstruct and PreDestroy on singleton beans: REQUIRED, REQUIRES_NEW or NOT_SUPPORTED
		 * - PostConstruct and PreDestroy on stateful beans: REQUIRES_NEW or NOT_SUPPORTED
		 */

		/*
		 * If SessinSynchronization is used, or if the corresponding annotations
		 * are used: REQUIRED, REQUIRES_NEW, MANDATORY
		 */

		section("CORE.8.3.7.1", RS.COMPLETED);

		TransactionAttribute.class.isAnnotation();
		TransactionAttributeType.class.isEnum();

		section("CORE.8.3.7.2", RS.COMPLETED);

		/*
		 * container-transaction, method, trans-attribute, ejb-name,
		 * method-intf, method-name, method-params
		 */

		/*-
			<method>
				<ejb-name>EJBNAME</ejb-name>
				<method-name>*</method-name>
			</method>
		
			<method>
				<ejb-name>EJBNAME</ejb-name>
				<method-name>METHOD</method-name>
			</method>
			
			<method>
				<ejb-name>EJBNAME</ejb-name>
				<method-name>METHOD</method-name>
				<method-params>
					<method-param>PARAMETER_1</method-param>
					...
					<method-param>PARAMETER_N</method-param>
				</method-params>
			</method>
		 */

		/*-
		 <ejb-jar>
			...
			<assembly-descriptor>
				...
				<container-transaction>
					<method>
						<ejb-name>EmployeeRecord</ejb-name>
						<method-name>*</method-name>
					</method>
					<trans-attribute>Required</trans-attribute>
				</container-transaction>
				<container-transaction>
					<method>
						<ejb-name>EmployeeRecord</ejb-name>
						<method-name>updatePhoneNumber</method-name>
					</method>
					<trans-attribute>Mandatory</trans-attribute>
				</container-transaction>
				<container-transaction>
					<method>
						<ejb-name>AardvarkPayroll</ejb-name>
						<method-name>*</method-name>
					</method>
					<trans-attribute>RequiresNew</trans-attribute>
				</container-transaction>
			</assembly-descriptor>
		</ejb-jar>
		 */

		section("CORE.8.4", RS.COMPLETED);

		/*
		 * The Application Assembler must not define transaction attributes for
		 * an enterprise bean with bean-managed transaction demarcation.
		 */

		section("CORE.8.5", RS.COMPLETED);
		section("CORE.8.6", RS.COMPLETED);

		section("CORE.8.6.1", RS.COMPLETED);

		toReadAgain();

		section("CORE.8.6.2", RS.COMPLETED);
		section("CORE.8.6.2.1", RS.COMPLETED);
		section("CORE.8.6.3", RS.COMPLETED);
		section("CORE.8.6.3.1", RS.COMPLETED);

		/*
		 * NOT_SUPPORTED : suspend any any existing transactionthen resumes it
		 */

		section("CORE.8.6.3.2", RS.COMPLETED);

		/* REQUIRED : creates a new transaction if one is not already running */

		section("CORE.8.6.3.3", RS.COMPLETED);

		/*
		 * SUPPORTS : use existing transaction if any, but do not create a new
		 * one
		 */

		section("CORE.8.6.3.4", RS.COMPLETED);

		/*
		 * REQUIRES_NEW : suspend any existing transaction and creates a new one
		 */

		section("CORE.8.6.3.5", RS.COMPLETED);

		/*
		 * MANDATORY : do not create a new transaction, throw
		 * EJBTransactionRequiredException if a transaction does not already
		 * exist
		 */

		section("CORE.8.6.3.6", RS.COMPLETED);

		/*
		 * NEVER : throw EJBException if a transaction exists
		 */

		section("CORE.8.6.3.7", RS.COMPLETED);

		section("CORE.8.6.3.8", RS.COMPLETED);

		section("CORE.8.6.3.9", RS.COMPLETED);

		/*
		 * The container must throw the java.lang.IllegalStateException if the
		 * EJBContext.getRollbackOnly method is invoked from a business method
		 * executing with the SUPPORTS, NOT_SUPPORTED, or NEVER transaction
		 * attribute.
		 */

		section("CORE.8.6.3.10", RS.COMPLETED);

		/*
		 * If an instance of an enterprise bean with container-managed
		 * transaction demarcation attempts to invoke the getUserTransaction
		 * method of the EJBContext interface, the container must throw the
		 * java.lang.IllegalStateException.
		 */

		section("CORE.8.6.3.11", RS.COMPLETED);

		/*
		 * the container must complete the commit protocol before marshalling
		 * the return value
		 */

		section("CORE.8.6.4", RS.COMPLETED);

		section("CORE.8.6.5", RS.COMPLETED);
		section("CORE.8.6.5.1", RS.COMPLETED);
		section("CORE.8.6.5.2", RS.COMPLETED);
		section("CORE.8.6.5.3", RS.COMPLETED);
		section("CORE.8.6.5.4", RS.COMPLETED);
		section("CORE.8.6.5.5", RS.COMPLETED);
		section("CORE.8.6.6", RS.COMPLETED);

		/*
		 * The container may use a local transaction optimization for enterprise
		 * beans whose metadata annotations or deployment descriptor indicates
		 * that connections to a resource manager are shareable
		 */

		section("CORE.8.6.7", RS.COMPLETED);

		/*
		 * A failure that occurs in the middle of the execution of a method that
		 * runs with an unspecified transaction context may leave the resource
		 * managers accessed from the method in an unpredictable state. The EJB
		 * architecture does not define how the application should recover the
		 * resource managers’ state after such a failure.
		 */

		section("CORE.8.7", RS.COMPLETED);

		section("CORE.8.7.1", RS.COMPLETED);

		/* Transaction “Diamond” Scenario with an Entity Object */

		/* interesting case */

		toReadAgain();

		section("CORE.8.7.2", RS.COMPLETED);

		/* support for local diamonds */

		/*
		 * if distributed diamonds are not supported, and if the container can
		 * detect them, then it should throw an exception
		 */

		section("CORE.8.7.3", RS.COMPLETED);

		section("CORE.8.7.4", RS.COMPLETED);
		section("CORE.8.7.5", RS.COMPLETED);

		/* interesting */
		toReadAgain();

		section("CORE.9", RS.COMPLETED);
		section("CORE.9.1", RS.COMPLETED);
		section("CORE.9.1.1", RS.COMPLETED);

		/*
		 * application exceptions can subclass Exception or RuntimeException but
		 * not RemoteException
		 */

		RemoteException.class.getName();

		/* CreateException and RemoveException are application exceptions */

		CreateException.class.getName();
		RemoveException.class.getName();

		section("CORE.9.1.2", RS.COMPLETED);

		/* application exceptions do not imply transaction rollback */

		section("CORE.9.2", RS.COMPLETED);
		section("CORE.9.2.1", RS.COMPLETED);

		/*
		 * Runtime exceptions that should be handled as application exception
		 * must be marked as such in the ApplicationException metadata
		 * annotation
		 */

		ApplicationException.class.isAnnotation();
		// application-exception in XML

		constructANewInstanceOf(ApplicationException.class).rollback();

		FinderException.class.getName();

		/*
		 * designating an unchecked exception as an application exception also
		 * applies to subclasses of that exception
		 */

		constructANewInstanceOf(ApplicationException.class).inherited();

		section("CORE.9.2.2", RS.COMPLETED);

		/*
		 * A system exception is an exception that is a java.rmi.RemoteException
		 * (or one of its subclasses) or a RuntimeException that is not an
		 * application exception.
		 */

		/*
		 * checked non-recoerable system exception should be encapsulated in
		 * EJBException
		 */
		EJBException.class.getName();

		toReadAgain();

		section("CORE.9.3", RS.COMPLETED);

		section("CORE.9.3.1", RS.COMPLETED);

		section("CORE.9.3.2", RS.COMPLETED);

		section("CORE.9.3.3", RS.COMPLETED);
		section("CORE.9.3.4", RS.COMPLETED);
		section("CORE.9.3.5", RS.COMPLETED);
		section("CORE.9.3.6", RS.COMPLETED);
		section("CORE.9.3.7", RS.COMPLETED);
		section("CORE.9.3.8", RS.COMPLETED);

		section("CORE.9.3.9", RS.COMPLETED);
		section("CORE.9.3.10", RS.COMPLETED);
		section("CORE.9.4", RS.COMPLETED);
		section("CORE.9.4.1", RS.COMPLETED);
		section("CORE.9.4.2", RS.COMPLETED);
		section("CORE.9.4.2.1", RS.COMPLETED);

		// extends EJBException
		EJBTransactionRolledbackException.class.getName();

		// extends EJBException
		TransactionRolledbackLocalException.class.getName();

		// extends RemoteException
		TransactionRolledbackException.class.getName();

		section("CORE.9.4.2.2", RS.COMPLETED);

		// extends EJBException
		EJBTransactionRequiredException.class.getName();

		// extends EJBException
		TransactionRequiredLocalException.class.getName();

		// extends RemoteException
		TransactionRequiredException.class.getName();

		section("CORE.9.4.2.3", RS.COMPLETED);

		// extends EJBException
		NoSuchEJBException.class.getName();

		// extends EJBException
		NoSuchObjectLocalException.class.getName();

		// extends RemoteException
		NoSuchObjectException.class.getName();

		section("CORE.9.5", RS.COMPLETED);

		section("CORE.10", RS.COMPLETED);

		/*
		 * Distributed Interoperability is not defined for the EJB 3.x remote
		 * client view, only for EJB 2.1
		 */

		section("CORE.10.1", RS.COMPLETED);

		/* Java RMI interfaces */

		/* RMI-IIOP types */

		section("CORE.10.1.1", RS.COMPLETED);

		/*
		 * stubs for the server side objects, which implement the remote home
		 * and remote component interface
		 */

		section("CORE.10.2", RS.COMPLETED);

		section("CORE.10.2.1", RS.COMPLETED);

		section("CORE.10.3", RS.COMPLETED);

		section("CORE.10.3.1", RS.COMPLETED);

		/* JSPs on one Java EE container, EJBs on another Java EE container */

		section("CORE.10.3.2", RS.COMPLETED);

		section("CORE.10.3.3", RS.COMPLETED);

		section("CORE.10.3.4", RS.COMPLETED);

		section("CORE.10.4", RS.COMPLETED);

		section("CORE.10.5", RS.COMPLETED);

		/* IIOP 1.2 */

		/* CORBA 2.3.1 */

		/* GIOP version number 1.2 */

		/* fragmented GIOP messages */

		/* BiDirIIOPServiceContext structure */

		/* Java Language to IDL mapping specification */

		section("CORE.10.5.1", RS.COMPLETED);

		/* Java RMI APIs */

		/* CORBA portable Stub APIs */

		/* CORBA Tie objects */

		section("CORE.10.5.2", RS.COMPLETED);

		Handle.class.getName();
		HomeHandle.class.getName();
		EJBMetaData.class.getName();

		section("CORE.10.5.3", RS.COMPLETED);

		{
			Map<String, Class<?>> corbaToSystemExceptionsMapping = new HashMap<String, Class<?>>();
			corbaToSystemExceptionsMapping.put("TRANSACTION_ROLLEDBACK", TransactionRolledbackException.class);
			corbaToSystemExceptionsMapping.put("TRANSACTION_REQUIRED", TransactionRequiredException.class);
			corbaToSystemExceptionsMapping.put("INVALID_TRANSACTION", InvalidTransactionException.class);
			corbaToSystemExceptionsMapping.put("OBJECT_NOT_EXIST", NoSuchObjectException.class);
			corbaToSystemExceptionsMapping.put("NO_PERMISSION", AccessException.class);
			corbaToSystemExceptionsMapping.put("MARSHAL", MarshalException.class);
			corbaToSystemExceptionsMapping.put("UNKNOWN", RemoteException.class);
		}

		section("CORE.10.5.4", RS.COMPLETED);

		/* EJBObject or EJBHome’s IOR */

		section("CORE.10.5.5", RS.COMPLETED);

		section("CORE.10.5.5.1", RS.COMPLETED);

		HandleDelegate.class.getName();

		/* java:comp/HandleDelegate */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				handleDelegate.readEJBHome(objectInputStream);
				handleDelegate.readEJBObject(objectInputStream);
				handleDelegate.writeEJBHome(ejbHome, objectOutputStream);
				handleDelegate.writeEJBObject(ejbObject, objectOutputStream);
			}
		});

		section("CORE.10.6", RS.COMPLETED);

		/*
		 * Transaction interoperability between containers provided by different
		 * vendors is an optional feature in this version of the EJB
		 * specification.
		 */

		section("CORE.10.6.1", RS.COMPLETED);

		section("CORE.10.6.1.1", RS.COMPLETED);

		/*
		 * implicit propagation mechanism described in the CORBA Object
		 * Transaction Service (OTS) v1.2 specification
		 */

		/* CosTransactions::PropagationContext */

		section("CORE.10.6.1.2", RS.COMPLETED);

		section("CORE.10.6.1.3", RS.COMPLETED);

		/* CosTransactions::OTSPolicy */

		/* CosTransactions::InvocationPolicy */

		/* CosTransactions::SHARED or CosTransactions::EITHER */

		/* CosTransactions::ADAPTS */

		/* CosTransactions::Synchronization */

		section("CORE.10.6.1.4", RS.COMPLETED);

		section("CORE.10.6.2", RS.COMPLETED);

		/*
		 * when a Java EE container does not support transaction
		 * interoperability, the failure modes are well defined so that the
		 * integrity of an application’s data is not compromised: at worst the
		 * transaction is rolled back
		 */

		section("CORE.10.6.2.1", RS.COMPLETED);

		/* CosTransactions::Coordinator and CosTransactions::Terminator */

		/* Coordinator::register_resource call */

		section("CORE.10.6.2.2", RS.COMPLETED);

		/* CosTransactions::OTSPolicy */
		/* CosTransactions::InvocationPolicy */

		section("CORE.10.6.2.2.1", RS.COMPLETED);
		section("CORE.10.6.2.2.2", RS.COMPLETED);

		section("CORE.10.7", RS.COMPLETED);

		/* CORBA CosNaming service */

		/* CORBA Interoperable Name Service specification */

		/* corbaloc:iiop:1.2@<host>:<port>/<objectkey> */

		section("CORE.10.8", RS.COMPLETED);

		/* CSIv2 specification Conformance Level 0 */

		section("CORE.10.8.1", RS.COMPLETED);

		/* Kerberos-based secret key mechanisms */

		/* X.509 certificate-based public key mechanisms */

		section("CORE.10.8.1.1", RS.COMPLETED);

		section("CORE.10.8.1.2", RS.COMPLETED);

		/* Java Authentication and Authorization Service (JAAS) */

		section("CORE.10.8.2", RS.COMPLETED);

		section("CORE.10.8.2.1", RS.COMPLETED);

		/* Secure Sockets Layer (SSL 3.0) */

		/* Transport Layer Security (TLS 1.0) */

		/*
		 * The original SSL and TLS specifications supported only X.509
		 * certificates for authenticating principals.
		 */

		/*
		 * Recently, Kerberos-based authentication mechanisms and cipher suites
		 * have been defined for TLS
		 */

		/*
		 * EJB, web and application client containers are required to support
		 * both SSL 3.0 and TLS 1.0 as security protocols for IIOP.
		 */

		/*-
		 * - TLS_RSA_WITH_RC4_128_MD5
		 * - SSL_RSA_WITH_RC4_128_MD5
		 * - TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA
		 * - SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA
		 * - TLS_RSA_EXPORT_WITH_RC4_40_MD5
		 * - SSL_RSA_EXPORT_WITH_RC4_40_MD5
		 * - TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA
		 * - SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA
		 */

		/* SSL handshake layer */
		/* SSL record layer */

		section("CORE.10.8.2.2", RS.COMPLETED);

		/* TAG_CSI_SEC_MECH_LIST */
		/* CSIIOP::CompoundSecMech */

		section("CORE.10.8.2.3", RS.COMPLETED);

		section("CORE.10.8.2.4", RS.COMPLETED);

		section("CORE.10.8.2.5", RS.COMPLETED);

		section("CORE.11", RS.COMPLETED);

		section("CORE.11.1", RS.COMPLETED);

		section("CORE.11.2", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				sessionContext.lookup(name);
			}
		});

		section("CORE.11.2.1", RS.COMPLETED);

		/*
		 * For enterprise beans packaged in a standalone ejb-jar file or in an
		 * ejb-jar file within an .ear file, each enterprise bean defines its
		 * own set of environment entries. In this case, all instances of an
		 * enterprise bean share the same environment entries; the environment
		 * entries are not shared with other enterprise beans.
		 */

		/*
		 * In a .war file, there is only a single naming environment shared
		 * between all the components in the module. For enterprise beans
		 * packaged in a .war file, all enterprise beans share this single
		 * naming environment. The enterprise beans share their environment
		 * entries with all other enterprise bean components and web components
		 * in the .war file.
		 */

		/*
		 * lookups of objects in the JNDI java: namespace are required to return
		 * a new instance of the requested object every time.
		 */

		/*- exceptions :
		 * - immutable objects
		 * - singletons
		 * - objects intented to be shared (i.e. java:comp/ORB)
		 */

		section("CORE.11.2.2", RS.COMPLETED);

		/*
		 * a field named myDatabase in the class MySessionBean in the package
		 * com.acme.example would correspond to the JNDI name
		 * java:comp/env/com.acme.example.MySessionBean/myDatabase.
		 */

		/*
		 * The annotation is applied to the set method for the property, which
		 * is the method that is called to inject the environment entry.
		 */

		/*
		 * a method named setMyDatabase in the same MySessionBean class would
		 * correspond to the JNDI name
		 * java:comp/env/com.example.MySessionBean/myDatabase
		 */

		/*
		 * When a deployment descriptor entry is used to specify injection, the
		 * JNDI name and the instance variable name or property name are both
		 * specified explicitly.
		 */

		/*
		 * the JNDI name is always relative to the java:comp/env naming context
		 */

		/*
		 * By explicitly specifying the JNDI name of a resource, a single
		 * resource may be injected into multiple fields or methods of multiple
		 * classes.
		 */

		/*
		 * Annotations may also be applied to the bean class itself. These
		 * annotations declare an entry in the bean’s environment, but do not
		 * cause the resource to be injected. Instead, the bean is expected to
		 * use the EJBContext lookup method or the methods of the JNDI API to
		 * lookup the entry. When the annotation is applied to the bean class,
		 * the JNDI name and the environment entry type must be explicitly
		 * specified
		 */

		section("CORE.11.2.3", RS.COMPLETED);

		/*
		 * rules apply to how a deployment descriptor entry may override a
		 * Resource annotation
		 */

		/*
		 * rules for how a deployment descriptor entry may override a
		 * PersistenceUnit or PersistenceContext annotation are described in
		 * Sections 11.10 and 11.11
		 */

		/*
		 * The rules for web services references and how a deployment descriptor
		 * entry may override a WebServiceRef annotation are included in the Web
		 * Services for Java EE specification
		 */

		section("CORE.11.3", RS.COMPLETED);

		section("CORE.11.3.1", RS.COMPLETED);
		/*
		 * When using JNDI interfaces directly, an enterprise bean instance
		 * creates a javax.naming.InitialContext object by using the constructor
		 * with no arguments, and looks up the environment naming via the
		 * InitialContext under the name java:comp/env
		 */

		section("CORE.11.3.2", RS.COMPLETED);

		section("CORE.11.3.3", RS.COMPLETED);

		section("CORE.11.3.4", RS.COMPLETED);

		/*-
		 *  - java:comp/env
		 *  - java:module
		 *  - java:app
		 *  - java:global
		 *  */

		/*
		 * The container must ensure that the enterprise bean instances have
		 * only read access to their environment variables.
		 */

		OperationNotSupportedException.class.getName();

		section("CORE.11.4", RS.COMPLETED);
		section("CORE.11.4.1", RS.COMPLETED);
		section("CORE.11.4.1.1", RS.COMPLETED);

		/*
		 * The authenticationType and shareable elements of the Resource
		 * annotation must not be specified for simple environment entries
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				class MyBean {
					@Resource
					int someInteger;
				}
			}
		});

		section("CORE.11.4.1.2", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				Context initCtx = new InitialContext();
				Context myEnv = (Context) initCtx.lookup("java:comp/env");
				Integer maxExemptions = (Integer) myEnv.lookup("maxExemptions");
			}
		});

		section("CORE.11.4.1.3", RS.COMPLETED);

		/*
		 * In XML: - env-entry - env-entry-value
		 */

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>EmployeeService</ejb-name>
					<ejb-class>com.wombat.empl.EmployeeServiceBean</ejb-class>
					...
					<env-entry>
						<description>The maximum number of tax exemptions allowed to be set.</description>
						<env-entry-name>maxExemptions</env-entry-name>
						<env-entry-type>java.lang.Integer</env-entry-type>
						<env-entry-value>15</env-entry-value>
					</env-entry>
					<env-entry>
						<description>The minimum number of tax exemptions allowed to be set.</description>
						<env-entry-name>minExemptions</env-entry-name>
						<env-entry-type>java.lang.Integer</env-entry-type>
						<env-entry-value>1</env-entry-value>
					</env-entry>
					<env-entry>
						<env-entry-name>foo/name1</env-entry-name>
						<env-entry-type>java.lang.String</env-entry-type>
						<env-entry-value>value1</env-entry-value>
					</env-entry>
					<env-entry>
						<env-entry-name>foo/bar/name2</env-entry-name>
						<env-entry-type>java.lang.Boolean</env-entry-type>
						<env-entry-value>true</env-entry-value>
					</env-entry>
					<env-entry>
						<description>Some description.</description>
						<env-entry-name>name3</env-entry-name>
						<env-entry-type>java.lang.Integer</env-entry-type>
					</env-entry>
					<env-entry>
						<env-entry-name>foo/name4</env-entry-name>
						<env-entry-type>java.lang.Integer</env-entry-type>
						<env-entry-value>10</env-entry-value>
					</env-entry>
					...
				</session>
			</enterprise-beans>
		 */

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>EmployeeService</ejb-name>
					<ejb-class>com.wombat.empl.EmployeeServiceBean</ejb-class>
					...
					<env-entry>
						<description>The maximum number of tax exemptions allowed to be set.</description>
						<env-entry-name>com.wombat.empl.EmployeeService/maxExemptions</env-entry-name>
						<env-entry-type>java.lang.Integer</env-entry-type>
						<env-entry-value>15</env-entry-value>
						<injection-target>
							<injection-target-class>com.wombat.empl.EmployeeServiceBean</injection-target-class>
							<injection-target-name>maxExemptions</injection-target-name>
						</injection-target>
					</env-entry>
					<env-entry>
						<description>The minimum number of tax exemptions allowed to be set.</description>
						<env-entry-name>com.wombat.empl.EmployeeService/minExemptions</env-entry-name>
						<env-entry-type>java.lang.Integer</env-entry-type>
						<env-entry-value>1</env-entry-value>
						<injection-target>
							<injection-target-class>com.wombat.empl.EmployeeServiceBean</injection-target-class>
							<injection-target-name>minExemptions</injection-target-name>
						</injection-target>
					</env-entry>
					...
				</session>
			</enterprise-beans>
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				// default value on injected resources
				class MyBean {
					@Resource
					int maxExemptions = 4;
				}

			}
		});

		/*-
		
			<env-entry>
				<env-entry-name>com.wombat.empl.EmployeeServiceBean/timeout</env-entry-name>
				<env-entry-type>java.lang.Integer</env-entry-type>
				<injection-target>
					<injection-target-class>com.wombat.empl.EmployeeServiceBean</injection-target-class>
					<injection-target-name>timeout</injection-target-name>
				</injection-target>
				<lookup-name>java:app/env/timeout</lookup-name>
			</env-entry>
		 */

		/*
		 * It is an error for both the env-entry-value and lookup-name elements
		 * to be specified for a given env-entry element.
		 */

		section("CORE.11.4.2", RS.COMPLETED);
		section("CORE.11.4.3", RS.COMPLETED);
		section("CORE.11.4.4", RS.COMPLETED);
		section("CORE.11.5", RS.COMPLETED);
		section("CORE.11.5.1", RS.COMPLETED);
		section("CORE.11.5.1.1", RS.COMPLETED);

		EJB.class.isAnnotation();
		constructANewInstanceOf(EJB.class).name();
		constructANewInstanceOf(EJB.class).beanInterface();
		constructANewInstanceOf(EJB.class).beanName();
		constructANewInstanceOf(EJB.class).mappedName();
		constructANewInstanceOf(EJB.class).lookup();

		/*
		 * Either the beanName or the lookup element can be used to resolve the
		 * EJB dependency to the target component.
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Stateless(name = "myejb")
				class MyEJB {

				}
				class MyUsingEntity {
					@EJB(name = "ejb/myEJB", beanInterface = MyEJB.class, beanName = "myEJB")
					private MyEJB myEJB;
					@EJB(name = "ejb/myOtherEJB", beanInterface = MyEJB.class, lookup = "java:app/myModule/myOtherEJB")
					private MyEJB myOtherEJB;
				}
			}
		});

		section("CORE.11.5.1.2", RS.COMPLETED);

		/*
		 * The EJB specification recommends, but does not require, that all
		 * references to other enterprise beans be organized in the ejb
		 * subcontext of the bean’s environment
		 */

		/* java:comp/env/ejb */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {

				class MyOtherBeanInterface {
					// would actually be an interface
				}
				class MyOtherBeanHome {

				}
				@EJB(name = "ejb/myOtherBean", beanInterface = MyOtherBeanInterface.class)
				@Stateless
				class MyBean /* implements MyBeanInterface */ {
					@SuppressWarnings("unused")
					public void foo() throws NamingException {
						Context ctx = new InitialContext();
						Object result = ctx.lookup("java:comp/env/ejb/myBean");
						MyOtherBeanHome myOtherBeanHome = (MyOtherBeanHome) PortableRemoteObject.narrow(result,
								MyOtherBeanHome.class);

					}
				}
			}
		});

		section("CORE.11.5.1.3", RS.COMPLETED);

		/*
		 * Although the EJB reference is an entry in the enterprise bean’s
		 * environment, the Bean Provider must not use a env-entry element to
		 * declare it
		 */

		/*
		 * the Bean Provider must declare all the EJB references using the
		 * ejb-ref and ejb-local-ref elements of the deployment descriptor
		 */

		/*-
		 * - ejb-ref
		 *   - description
		 *   - ejb-ref-name
		 *   - ejb-ref-type
		 *   - home
		 *   - remote
		 *   - ejb-link
		 *   - lookup-name
		 * - ejb-local-ref
		 *   - description
		 *   - ejb-ref-name
		 *   - ejb-ref-type
		 *   - local-home
		 *   - local
		 *   - ejb-link
		 *   - lookup-name
		 */

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>EmployeeService</ejb-name>
					<ejb-class>com.wombat.empl.EmployeeServiceBean</ejb-class>
					...
					<ejb-ref>
						<description>This is a reference to an EJB 2.1 session bean that encapsulates access to employee records.</description>
						<ejb-ref-name>ejb/EmplRecord</ejb-ref-name>
						<ejb-ref-type>Session</ejb-ref-type>
						<home>com.wombat.empl.EmployeeRecordHome</home>
						<remote>com.wombat.empl.EmployeeRecord</remote>
					</ejb-ref>
					<ejb-local-ref>
						<description>This is a reference to the local business interface of an EJB 3.0 session bean that provides a payroll service.</description>
						<ejb-ref-name>ejb/Payroll</ejb-ref-name>
						<local>com.aardvark.payroll.Payroll</local>
					</ejb-local-ref>
					<ejb-local-ref>
						<description>This is a reference to the local business interface of an EJB 3.0 session bean that provides a pension plan service.</description>
						<ejb-ref-name>ejb/PensionPlan</ejb-ref-name>
						<local>com.wombat.empl.PensionPlan</local>
					</ejb-local-ref>
					...
				</session>
				...
			</enterprise-beans>
		 */

		section("CORE.11.5.2", RS.COMPLETED);

		/*
		 * The Application Assembler can use the ejb-link element in the
		 * deployment descriptor to link an EJB reference to a target enterprise
		 * bean within the same application.
		 */

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>EmployeeService</ejb-name>
					<ejb-class>com.wombat.empl.EmployeeServiceBean</ejb-class>
					...
					<ejb-ref>
						<ejb-ref-name>ejb/EmplRecord</ejb-ref-name>
						<ejb-ref-type>Session</ejb-ref-type>
						<home>com.wombat.empl.EmployeeRecordHome</home>
						<remote>com.wombat.empl.EmployeeRecord</remote>
						<ejb-link>EmployeeRecord</ejb-link>
					</ejb-ref>
					...
				</session>
				...
				<session>
					<ejb-name>EmployeeRecord</ejb-name>
					<home>com.wombat.empl.EmployeeRecordHome</home>
					<remote>com.wombat.empl.EmployeeRecord</remote>
					...
				</session>
				...
			</enterprise-beans>
		 */

		/*-
			<session>
				...
				<ejb-name>OrderEJB</ejb-name>
				<ejb-class>com.wombat.orders.OrderBean</ejb-class>
				...
				<ejb-ref>
					<ejb-ref-name>ejb/Product</ejb-ref-name>
					<ejb-ref-type>Session</ejb-ref-type>
					<home>com.acme.orders.ProductHome</home>
					<remote>com.acme.orders.Product</remote>
					<ejb-link>../products/product.jar#ProductEJB</ejb-link>
				</ejb-ref>
				...
			</session>
		 */

		/*-
			<ejb-ref>
				<ejb-ref-name>ShoppingService/myCart</ejb-ref-name>
				<ejb-link>product/ShoppingCart</ejb-link>
			</ejb-ref>
		 */

		/*-
			<ejb-ref>
				<ejb-ref-name>ShoppingService/myCart</ejb-ref-name>
				<lookup-name>java:app/products/ShoppingCart</lookup-name>
			</ejb-ref>
		 */

		section("CORE.11.5.2.1", RS.COMPLETED);

		section("CORE.11.5.3", RS.COMPLETED);

		/*-
			<ejb-ref>
				<ejb-ref-name>ShoppingService/myCart</ejb-ref-name>
				<lookup-name>java:global/products/ShoppingCart</lookup-name>
			</ejb-ref>
		 */

		section("CORE.11.5.4", RS.COMPLETED);

		section("CORE.11.6", RS.COMPLETED);

		/* Java API for XML Web Services (JAX-WS) */

		/* Web Services for Java EE */

		/*
		 * The EJB specification recommends, but does not require, that all
		 * references to web services be organized in the service subcontext of
		 * the bean’s environment (i.e., in the java:comp/env/service JNDI
		 * context).
		 */

		section("CORE.11.7", RS.COMPLETED);

		/* manager connection factory references */

		section("CORE.11.7.1", RS.COMPLETED);
		section("CORE.11.7.1.1", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyClass {
					@Resource
					DataSource myDataSource;

					public void foo() throws SQLException {
						connection = myDataSource.getConnection();
					}
				}
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyClass {
					@Resource(lookup = "java:app/env/myDataSource")
					DataSource myDataSource;

					public void foo() throws SQLException {
						connection = myDataSource.getConnection();
					}
				}
			}
		});

		section("CORE.11.7.1.2", RS.COMPLETED);

		/*
		 * The EJB specification recommends, but does not require, that all
		 * resource manager connection factory references be organized in the
		 * subcontexts of the bean’s environment, using a different subcontext
		 * for each resource manager type.
		 */

		/*-
		 * - java:comp/env/jdbc
		 * - java:comp/env/jms
		 * - java:comp/env/mail
		 * - java:comp/env/url
		 */

		/*
		 * resource manager connection factory references declared via
		 * annotations will not, by default, appear in any subcontext
		 */

		/*
		 * The Bean Provider can control the shareability of the connections
		 * acquired from the resource manager connection factory.
		 */

		/*
		 * by default, connections to a resource manager are shareable across
		 * other enterprise beans in the application that use the same resource
		 * in the same transaction context
		 */

		/*-
		 * - shareable annotation element
		 * - in XML : res-sharing-scope : can be 'Unshareable'
		 */

		/*-
		 * - allow the Deployer to set up principal mapping or resource manager sign-on information
		 * - sign on to the resource manager from the bean code
		 */

		/*-
		 * - authenticationType annotation element
		 * - in XML : res-auth
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Resource(name = "jdbc/myDataSource", type = DataSource.class)
				@Stateless
				class MyBean {
					@Resource
					SessionContext ctx;

					@SuppressWarnings("unused")
					public void foo() throws SQLException {
						DataSource dataSource = (DataSource) ctx.lookup("jdbc/myDataSource");
						Connection connection = dataSource.getConnection();
					}
				}
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Resource(name = "jdbc/myDataSource", type = DataSource.class)
				@Stateless
				class MyBean {
					@SuppressWarnings("unused")
					public void foo() throws SQLException, NamingException {
						Context ctx = new InitialContext();
						DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/myDataSource");
						Connection connection = dataSource.getConnection();
					}
				}
			}
		});

		section("CORE.11.7.1.3", RS.COMPLETED);

		/*
		 * the Bean Provider must not use an env-entry element to declare a
		 * resource manager connection factory
		 */

		/* resource-ref */

		/*
		 * See Section “Declaration of Resource Manager Connection Factory
		 * References in Deployment Descriptor” in the Java EE Platform
		 * specification [12] for the description of the resource-ref element.
		 */

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>EmployeeService</ejb-name>
					<ejb-class>com.wombat.empl.EmployeeServiceBean</ejb-class>
					...
					<resource-ref>
						<description>A data source for the database in which the EmployeeService enterprise bean will record a log of all transactions.</description>
						<res-ref-name>jdbc/EmployeeAppDB</res-ref-name>
						<res-type>javax.sql.DataSource</res-type>
						<res-auth>Container</res-auth>
						<res-sharing-scope>Shareable</res-sharing-scope>
					</resource-ref>
					...
				</session>
			</enterprise-beans>
		 */

		/*-
			<enterprise-beans>
				<session>
				...
				<resource-ref>
					<description>A queue connection factory used by the MySession enterprise bean to send notifications.</description>
					<res-ref-name>jms/qConnFactory</res-ref-name>
					<res-type>javax.jms.QueueConnectionFactory</res-type>
					<res-auth>Container</res-auth>
					<res-sharing-scope>Unshareable</res-sharing-scope>
				</resource-ref>
				...
				</session>
			</enterprise-beans>
		 */

		section("CORE.11.7.1.4", RS.COMPLETED);

		/*-
		 * - javax.sql.DataSource for JDBC connections in java:comp/env/jdbc
		 * - javax.jms.ConnectionFactory for JMS in java:comp/env/jms
		 * - javax.jms.QueueConnectionFactory for JMS in java:comp/env/jms
		 * - javax.jms.TopicConnectionFactory for JMS in java:comp/env/jms
		 * - javax.mail.Session for JavaMail in java:comp/env/mail
		 * - java.net.URL for URLs in java:comp/env/url
		 */

		/*
		 * The Connector architecture [14] allows an enterprise bean to use the
		 * API described in this section to obtain resource objects that provide
		 * access to additional back-end systems.
		 */

		section("CORE.11.7.2", RS.COMPLETED);
		section("CORE.11.7.3", RS.COMPLETED);
		section("CORE.11.7.4", RS.COMPLETED);
		section("CORE.11.8", RS.COMPLETED);

		/* administered objects that are associated with resources */

		/* Connector CCI InteractionSpec instance */

		/* resource environment references */

		section("CORE.11.8.1", RS.COMPLETED);
		section("CORE.11.8.1.1", RS.COMPLETED);

		Resource.class.isAnnotation();
		constructANewInstanceOf(Resource.class).authenticationType();
		constructANewInstanceOf(Resource.class).shareable();

		section("CORE.11.8.1.2", RS.COMPLETED);
		section("CORE.11.8.1.3", RS.COMPLETED);

		/*
		 * the Bean Provider must not use a env-entry element to declare
		 * resource environment references
		 */

		/* resource-env-ref */

		/*
		 * See Section “Declaration of Resource Environment References in
		 * Deployment Descriptor” in the Java EE Platform specification [12] for
		 * the description of the resource-env-ref element
		 */

		section("CORE.11.8.2", RS.COMPLETED);

		/* JNDI LinkRef mechanism */

		section("CORE.11.8.3", RS.COMPLETED);
		section("CORE.11.9", RS.COMPLETED);
		section("CORE.11.9.1", RS.COMPLETED);
		section("CORE.11.9.1.1", RS.COMPLETED);

		/*
		 * A field or a method of a bean may be annotated with the Resource
		 * annotation to request injection of a message destination reference
		 */

		/*
		 * Note that when using the Resource annotation to declare a message
		 * destination reference it is not possible to link the reference to
		 * other references to the same message destination, or to specify
		 * whether the destination is used to produce or consume messages.
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					@Resource
					Queue myQueue;
				}
			}
		});
		section("CORE.11.9.1.2", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Resource(name = "jms/myQueue", type = Queue.class)
				class MyThingy /* implements Something */ {
					@Resource
					SessionContext sessionContext;

					@SuppressWarnings("unused")
					public void foo() {
						Queue queue = (Queue) sessionContext.lookup("jms/myQueue");
					}
				}
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@Resource(name = "jms/myQueue", type = Queue.class)
				class MyThingy /* implements Something */ {
					@SuppressWarnings("unused")
					public void foo() throws NamingException {
						Context ctx = new InitialContext();
						Queue queue = (Queue) ctx.lookup("jms/myQueue");
					}
				}
			}
		});

		section("CORE.11.9.1.3", RS.COMPLETED);

		/*
		 * the Bean Provider must not use a env-entry element to declare message
		 * destination references
		 */

		/*- message-destination-ref
		 * - description
		 * - message-destination-type
		 * - message-destination-usage
		 * - message-destination-ref-name
		 */

		/*-
			<message-destination-ref>
				<description>This is a reference to a JMS queue used in processing Stock info</description>
				<message-destination-ref-name>jms/StockInfo</message-destination-ref-name>
				<message-destination-type>javax.jms.Queue</message-destination-type>
				<message-destination-usage>Produces</message-destination-usage>
			</message-destination-ref>
		 */

		section("CORE.11.9.2", RS.COMPLETED);

		/* message-destination */
		/* message-destination-link */

		/* message-destination-type element of the message-driven element */

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>EmployeeService</ejb-name>
					<ejb-class>com.wombat.empl.EmployeeServiceBean</ejb-class>
					...
					<message-destination-ref>
						<message-destination-ref-name>jms/EmployeeReimbursements</message-destination-ref-name>
						<message-destination-type>javax.jms.Queue</message-destination-type>
						<message-destination-usage>Produces</message-destination-usage>
						<message-destination-link>ExpenseProcessingQueue</message-destination-link>
					</message-destination-ref>
				</session>
				...
				<message-driven>
					<ejb-name>ExpenseProcessing</ejb-name>
					<ejb-class>com.wombat.empl.ExpenseProcessingBean</ejb-class>
					<messaging-type>javax.jms.MessageListener</messaging-type>
					...
					<message-destination-type>javax.jms.Queue</message-destination-type>
					<message-destination-link>ExpenseProcessingQueue</message-destination-link>
					...
				</message-driven>
				...
			</enterprise-beans>
			...
			<assembly-descriptor>
				...
				<message-destination>
					<message-destination-name>ExpenseProcessingQueue</message-destination-name>
				</message-destination>
				...
			</assembly-descriptor>
		 */

		/*-
			<session>
				...
				<ejb-name>EmployeeService</ejb-name>
				<ejb-class>com.wombat.empl.EmployeeServiceBean</ejb-class>
				...
				<message-destination-ref>
					<message-destination-ref-name>jms/EmployeeReimbursements</message-destination-ref-name>
					<message-destination-type>javax.jms.Queue</message-destination-type>
					<message-destination-usage>Produces</message-destination-usage>
					<message-destination-link>finance.jar#ExpenseProcessingQueue</message-destination-link>
				</message-destination-ref>
			</session>
		 */
		section("CORE.11.9.3", RS.COMPLETED);
		section("CORE.11.9.4", RS.COMPLETED);
		section("CORE.11.10", RS.COMPLETED);

		/* persistence unit reference. */

		/*
		 * The Deployer binds the persistence unit references to entity manager
		 * factories that are configured in accordance with the persistence.xml
		 * specification for the persistence unit, as described in the Java
		 * Persistence API specification
		 */

		section("CORE.11.10.1", RS.COMPLETED);
		section("CORE.11.10.1.1", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				class MyThingy {
					@PersistenceUnit
					EntityManagerFactory entityManagerFactory;

					@PersistenceUnit(unitName = "MyEntityManagerFactory")
					EntityManagerFactory myEntityManagerFactory;

				}
			}
		});

		section("CORE.11.10.1.2", RS.COMPLETED);

		/*
		 * The EJB specification recommends, but does not require, that all
		 * persistence unit references be organized in the
		 * java:comp/env/persistence subcontexts of the bean’s environment
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@PersistenceUnit(name = "persistence/MyEMF")
				@Stateless
				class MyThingy {
					@Resource
					SessionContext sessionContext;

					@SuppressWarnings("unused")
					public void foo() {
						EntityManagerFactory entityManagerFactory = (EntityManagerFactory) sessionContext
								.lookup("persistence/MyEMF");
						EntityManager entityManager = entityManagerFactory.createEntityManager();
					}
				}

			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@PersistenceUnit(name = "persistence/MyEMF")
				@Stateless
				class MyThingy {
					@SuppressWarnings("unused")
					public void foo() throws NamingException {
						Context ctx = new InitialContext();
						EntityManagerFactory entityManagerFactory = (EntityManagerFactory) ctx
								.lookup("java:comp/env/persistence/MyEMF");
						EntityManager entityManager = entityManagerFactory.createEntityManager();
					}
				}

			}
		});

		section("CORE.11.10.1.3", RS.COMPLETED);

		/*
		 * the Bean Provider must not use an env-entry element to declare
		 * persistence unit references
		 */

		/*- persistence-unit-ref
		 * - description
		 * - persistence-unit-name
		 * - persistence-unit-ref-name
		 */

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>InventoryManagerBean</ejb-name>
					<ejb-class>com.wombat.empl.InventoryManagerBean</ejb-class>
					...
					<persistence-unit-ref>
						<description>Persistence unit for the inventory management application.</description>
						<persistence-unit-ref-name>persistence/InventoryAppDB</persistence-unit-ref-name>
						<persistence-unit-name>InventoryManagement</persistence-unit-name>
					</persistence-unit-ref>
					...
				</session>
			</enterprise-beans>
		 */

		section("CORE.11.10.2", RS.COMPLETED);

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>InventoryManagerBean</ejb-name>
					<ejb-class>com.wombat.empl.InventoryManagerBean</ejb-class>
					...
					<persistence-unit-ref>
						<description>Persistence unit for the inventory management application.</description>
						<persistence-unit-ref-name>persistence/InventoryAppDB</persistence-unit-ref-name>
						<persistence-unit-name>../lib/inventory.jar#InventoryManagement</persistence-unit-name>
					</persistence-unit-ref>
					...
				</session>
			</enterprise-beans>
		 */
		section("CORE.11.10.2.1", RS.COMPLETED);
		section("CORE.11.10.3", RS.COMPLETED);
		section("CORE.11.10.4", RS.COMPLETED);
		section("CORE.11.10.5", RS.COMPLETED);

		section("CORE.11.11", RS.COMPLETED);

		/* persistence context reference */

		section("CORE.11.11.1", RS.COMPLETED);
		section("CORE.11.11.1.1", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					@PersistenceContext(type = PersistenceContextType.EXTENDED)
					EntityManager entityManager;
				}
			}
		});

		section("CORE.11.11.1.2", RS.COMPLETED);

		/*
		 * The EJB specification recommends, but does not require, that all
		 * persistence context references be organized in the
		 * java:comp/env/persistence
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@PersistenceContext(name = "persistence/MyEntityManager")
				class MyThingy {
					@Resource
					SessionContext sessionContext;

					@SuppressWarnings("unused")
					public void foo() {
						EntityManager entityManager = (EntityManager) sessionContext
								.lookup("persistence/MyEntityManager");
					}
				}
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@PersistenceContext(name = "persistence/MyEntityManager")
				class MyThingy {
					@SuppressWarnings("unused")
					public void foo() throws NamingException {
						Context ctx = new InitialContext();
						EntityManager entityManager = (EntityManager) ctx
								.lookup("java:comp/env/persistence/MyEntityManager");
					}
				}
			}
		});

		section("CORE.11.11.1.3", RS.COMPLETED);

		/*
		 * the Bean Provider must not use an env-entry element to declare
		 * persistence context references
		 */

		/*- persistence-context-ref
		 * - description
		 * -persistence-unit-name
		 * -persistence-context-type
		 * -persistence-context-synchronization
		 * -persistence-property
		 * -persistence-context-ref-name
		 */

		/*-
			<enterprise-beans>
				<session>
					...
					<ejb-name>InventoryManagerBean</ejb-name>
					<ejb-class>com.wombat.empl.InventoryManagerBean</ejb-class>
					...
					<persistence-context-ref>
						<description>Persistence context for the inventory management application.</description>
						<persistence-context-ref-name>persistence/InventoryAppMgr</persistence-context-ref-name>
						<persistence-unit-name>InventoryManagement</persistence-unit-name>
					</persistence-context-ref>
					...
				</session>
			</enterprise-beans>
		 */

		section("CORE.11.11.2", RS.COMPLETED);

		/*-
			...
			<enterprise-beans>
				<session>
					...
					<ejb-name>InventoryManagerBean</ejb-name>
					<ejb-class>com.wombat.empl.InventoryManagerBean</ejb-class>
					...
					<persistence-context-ref>
						<description>Persistence context for the inventory management application.</description>
						<persistence-context-ref-name>persistence/InventoryAppMgr</persistence-context-ref-name>
						<persistence-unit-name>../lib/inventory.jar#InventoryManagement</persistence-unit-name>
					</persistence-context-ref>
					...
				</session>
			</enterprise-beans>
			...
		 */

		section("CORE.11.11.2.1", RS.COMPLETED);
		section("CORE.11.11.3", RS.COMPLETED);
		section("CORE.11.11.4", RS.COMPLETED);
		section("CORE.11.11.5", RS.COMPLETED);
		section("CORE.11.12", RS.COMPLETED);
		/*
		 * The container must make the UserTransaction interface available to
		 * the enterprise beans that are allowed to use this interface either
		 * through injection using the Resource annotation or in JNDI under the
		 * name java:comp/UserTransaction, in addition to through the EJBContext
		 * interface.
		 */

		/*
		 * session and message-driven beans with bean-managed transaction
		 * demarcation
		 */

		/*
		 * The container must not make the UserTransaction interface available
		 * to the enterprise beans that are not allowed to use this interface
		 */

		/* javax.naming.NameNotFoundException */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					@Resource
					UserTransaction userTransaction;
				}
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					public void foo() throws NamingException {
						Context ctx = new InitialContext();
						UserTransaction userTransaction = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
					}
				}
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					SessionContext sessionContext;

					public void foo() throws NamingException {
						UserTransaction userTransaction = sessionContext.getUserTransaction();
					}
				}
			}
		});

		/*
		 * A UserTransaction object reference may also be declared in a
		 * deployment descriptor in the same way as a resource environment
		 * reference. Such a deployment descriptor entry may be used to specify
		 * injection of a UserTransaction object.
		 */

		section("CORE.11.12.1", RS.COMPLETED);
		section("CORE.11.12.2", RS.COMPLETED);

		section("CORE.11.13", RS.COMPLETED);
		/*
		 * Enterprise beans that need to make use of the CORBA ORB to perform
		 * certain operations can find an appropriate object implementing the
		 * ORB interface by requesting injection of an ORB object or by looking
		 * up the JNDI name java:comp/ORB. Any such reference to an ORB object
		 * is only valid within the bean instance that performed the lookup.
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					@Resource
					ORB orb;

					public void foo() throws InvalidName {
						POA poa = (POA) orb.resolve_initial_references("MyPOA");
					}
				}
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					public void foo() throws InvalidName, NamingException {
						Context ctx = new InitialContext();
						ORB orb = (ORB) ctx.lookup("java:comp/ORB");
						POA poa = (POA) orb.resolve_initial_references("MyPOA");
					}
				}
			}
		});

		/*
		 * The ORB instance available under the JNDI name java:comp/ORB may
		 * always be a shared instance.
		 */

		/*
		 * the ORB instance injected into an enterprise bean or declared via a
		 * deployment descriptor entry may also be a shared instance
		 */

		/*
		 * the application may set the shareable element of the Resource
		 * annotation to false, or may set the res-sharing-scope element in the
		 * deployment descriptor to Unshareable, to request a non-shared ORB
		 * instance
		 */

		section("CORE.11.13.1", RS.COMPLETED);
		section("CORE.11.13.2", RS.COMPLETED);
		section("CORE.11.14", RS.COMPLETED);

		/*
		 * The container must make the TimerService interface available either
		 * through injection using the Resource annotation or in JNDI under the
		 * name java:comp/TimerService, in addition to through the EJBContext
		 * interface. The authenticationType and shareable elements of the
		 * Resource annotation must not be specified.
		 */

		/*
		 * A TimerService object reference may also be declared in a deployment
		 * descriptor in the same way as a resource environment reference. Such
		 * a deployment descriptor entry may be used to specify injection of a
		 * TimerService object
		 */

		section("CORE.11.14.1", RS.COMPLETED);
		section("CORE.11.14.2", RS.COMPLETED);
		section("CORE.11.15", RS.COMPLETED);
		/*
		 * The container must make a component’s EJBContext interface available
		 * either through injection using the Resource annotation or in JNDI
		 * under the name java:comp/EJBContext. The authenticationType and
		 * shareable elements of the Resource annotation must not be specified.
		 * An EJBContext object reference may also be declared in a deployment
		 * descriptor in the same way as a resource environment reference. Such
		 * a deployment descriptor entry may be used to specify injection of an
		 * EJBContext object.
		 */

		section("CORE.11.15.1", RS.COMPLETED);
		section("CORE.11.15.2", RS.COMPLETED);

		SessionContext.class.getName();
		MessageDrivenContext.class.getName();

		section("CORE.11.16", RS.COMPLETED);
		section("CORE.11.17", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void dontRun() throws Exception {
				try {
					ejbContext.getEnvironment();
				} catch (RuntimeException ex) {
					// ejbContext.getEnvironment(); is depreacted
				}
			}
		});

		/*-
			...
			<env-entry>
				env-entry-name>ejb10-properties/foo</env-entry-name>
				<env-entry-type>java.lang.String</env-entry-type>
			</env-entry>
			<env-entry>
				<description>bar’s description</description>
				<env-entry-name>ejb10-properties/bar</env-entry-name>
				<env-entry-type>java.lang.String</env-entry-type>
				<env-entry-value>bar value</env-entry-value>
			</env-entry>
			...
		 */

		section("CORE.12", RS.COMPLETED);
		section("CORE.12.1", RS.COMPLETED);
		/* security roles */
		/* method permissions */
		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				ejbContext.getCallerPrincipal();
			}
		});

		/* security-identity */

		RunAs.class.isAnnotation();

		/* use-caller-identity : security-identity */
		/* run-as */

		section("CORE.12.2", RS.COMPLETED);
		section("CORE.12.2.1", RS.COMPLETED);

		/*
		 * The EJB architecture provides no programmatic interfaces for the
		 * invoking enterprise bean to control the principal passed to the
		 * invoked enterprise bean.
		 */
		/*
		 * The management of caller principals passed on inter-enterprise bean
		 * invocations (i.e. principal delegation) is set up by the Deployer and
		 * System Administrator in a container-specific way.
		 */

		section("CORE.12.2.2", RS.COMPLETED);
		section("CORE.12.2.3", RS.COMPLETED);

		/*
		 * the Bean Provider cannot rely on a specific principal for accessing
		 * the underlying OS resources, such as files
		 */

		section("CORE.12.2.4", RS.COMPLETED);
		section("CORE.12.2.5", RS.COMPLETED);

		/*
		 * security management should be enforced by the container in a manner
		 * that is transparent to the enterprise beans’ business methods
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				try {
					ejbContext.getCallerPrincipal();
					ejbContext.isCallerInRole(role);
				} catch (IllegalStateException ex) {
					// when no security context exists
				}
			}
		});

		section("CORE.12.2.5.1", RS.COMPLETED);
		section("CORE.12.2.5.2", RS.COMPLETED);
		section("CORE.12.2.5.3", RS.COMPLETED);

		RolesAllowed.class.isAnnotation();
		DeclareRoles.class.isAnnotation();

		/*- security-role-ref 
		 * - role-name
		 * - description
		 * */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@DeclareRoles({ "role1", "role2" })
				class MyThingy {
					@Resource
					SessionContext sessionContext;

					@SuppressWarnings("unused")
					public void foo() throws SearchException {
						if (!sessionContext.isCallerInRole("role1") || sessionContext.isCallerInRole("role1")) {
							throw new SearchException();
						}
					}
				}
			}
		});

		/*-
			<enterprise-beans>
				...
				<session>
					<ejb-name>AardvarkPayroll</ejb-name>
					<ejb-class>com.aardvark.payroll.PayrollBean</ejb-class>
					...
					<security-role-ref>
						<description>This security role should be assigned to the employees of the payroll department who are allowed to update employees’ salaries.</description>
						<role-name>payroll</role-name>
					</security-role-ref>
					...
				</session>
				...
			</enterprise-beans>
		 */

		section("CORE.12.3", RS.COMPLETED);
		section("CORE.12.3.1", RS.COMPLETED);

		/*
		 * A security role with the name “**” is defined by the Container, and
		 * is intended to be used by the Bean Provider, Application Assembler,
		 * or Deployer to indicate that the caller must log on or authenticate
		 * to invoke a method or to perform some processing requiring membership
		 * in this container role.
		 */

		/*-
			<assembly-descriptor>
				<security-role>
					<description>This role includes the employees of the enterprise who are allowed to access the employee self-service application. This role is allowed only to access his/her own information.</description>
					<role-name>employee</role-name>
				</security-role>
				<security-role>
					<description>This role includes the employees of the human resources department. The role is allowed to view and update all employee records.</description>
					<role-name>hr-department</role-name>
				</security-role>
				<security-role>
					<description>This role includes the employees of the payroll department. The role is allowed to view and update the payroll entry for any employee.</description>
					<role-name>payroll-department</role-name>
				</security-role>
				<security-role>
					<description>This role should be assigned to the personnel authorized to perform administrative functions for the employee self-service application. This role does not have direct access to sensitive employee and payroll information.</description>
					<role-name>admin</role-name>
				</security-role>
				...
			</assembly-descriptor>
		 */

		section("CORE.12.3.2", RS.COMPLETED);
		section("CORE.12.3.2.1", RS.COMPLETED);

		RolesAllowed.class.isAnnotation();
		PermitAll.class.isAnnotation();
		DenyAll.class.isAnnotation();

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@RolesAllowed("admin")
				class MyThingy {
					public void foo() {

					}

					public void bar() {

					}
				}
				class MySuperThingy extends MyThingy {
					@Override
					@RolesAllowed("RH")
					public void foo() {
						// HR
					};

					// bar : admin
					public void baz() {
						// unspecified

					}
				}
			}

		});

		section("CORE.12.3.2.2", RS.COMPLETED);

		/*- method-permission
		 * - ejb-name
		 * - method-name
		 * - method-params */

		/* exclude-list */

		/*-
			<method>
				<ejb-name>EJBNAME</ejb-name>
				<method-name>*</method-name>
			</method>
			<method>
				<ejb-name>EJBNAME</ejb-name>
				<method-name>METHOD</method-name>
			</method>
			<method>
				<ejb-name>EJBNAME</ejb-name>
				<method-name>METHOD</method-name>
				<method-params>
					<method-param>PARAMETER_1</method-param>
					...
					<method-param>PARAMETER_N</method-param>
				</method-params>
			</method>
		 */

		/* method-intf */

		/*-
			<method-permission>
				<role-name>employee</role-name>
				<method>
					<ejb-name>EmployeeService</ejb-name>
					<method-name>*</method-name>
				</method>
			</method-permission>
			<method-permission>
				<role-name>employee</role-name>
				<method>
					<ejb-name>AardvarkPayroll</ejb-name>
					<method-name>findByPrimaryKey</method-name>
				</method>
				<method>
					<ejb-name>AardvarkPayroll</ejb-name>
					<method-name>getEmployeeInfo</method-name>
				</method>
				<method>
					<ejb-name>AardvarkPayroll</ejb-name>
					<method-name>updateEmployeeInfo</method-name>
				</method>
			</method-permission>
			<method-permission>
				<role-name>payroll-department</role-name>
				<method>
					<ejb-name>AardvarkPayroll</ejb-name>
					<method-name>findByPrimaryKey</method-name>
				</method>
				<method>
					<ejb-name>AardvarkPayroll</ejb-name>
					<method-name>getEmployeeInfo</method-name>
				</method>
				<method>
					<ejb-name>AardvarkPayroll</ejb-name>
					<method-name>updateEmployeeInfo</method-name>
				</method>
				<method>
					<ejb-name>AardvarkPayroll</ejb-name>
					<method-name>updateSalary</method-name>
				</method>
			</method-permission>
			<method-permission>
				<role-name>admin</role-name>
				<method>
					<ejb-name>EmployeeServiceAdmin</ejb-name>
					<method-name>*</method-name>
				</method>
			</method-permission>
			...
		 */

		section("CORE.12.3.2.3", RS.COMPLETED);

		/* security-role-ref */
		/* security-role */
		/* role-link */

		/*-
			<enterprise-beans>
				...
				<session>
					<ejb-name>AardvarkPayroll</ejb-name>
					<ejb-class>com.aardvark.payroll.PayrollBean</ejb-class>
					...
					<security-role-ref>
						<description>This role should be assigned to the employees of the payroll department. Members of this role have access to anyone’s payroll record. The role has been linked to the payroll-department role.</description>
						<role-name>payroll</role-name>
						<role-link>payroll-department</role-link>
					</security-role-ref>
					...
				</session>
				...
			</enterprise-beans>
		 */

		section("CORE.12.3.3", RS.COMPLETED);

		section("CORE.12.3.4", RS.COMPLETED);
		section("CORE.12.3.4", RS.COMPLETED);

		RunAs.class.isAnnotation();

		/*- security-identity
		 * - use-caller-identity
		 * - run-as
		 */

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@RunAs("admin")
				class MyThingy {

				}
			}
		});

		/*-
			<enterprise-beans>
				...
				<session>
					<ejb-name>EmployeeService</ejb-name>
					...
					<security-identity>
						<run-as>
							<role-name>admin</role-name>
						</run-as>
					</security-identity>
				...
				</session>
			...
			</enterprise-beans>
		 */

		section("CORE.12.4", RS.COMPLETED);
		section("CORE.12.4.1", RS.COMPLETED);

		section("CORE.12.4.2", RS.COMPLETED);
		section("CORE.12.4.3", RS.COMPLETED);
		section("CORE.12.4.4", RS.COMPLETED);
		section("CORE.12.4.5", RS.COMPLETED);
		section("CORE.12.5", RS.COMPLETED);

		/*
		 * A transactional client cannot change its principal association within
		 * a transaction
		 */

		/*
		 * A session bean’s client must not change its principal association for
		 * the duration of the communication with the session object.
		 */

		/*
		 * If transactional requests within a single transaction arrive from
		 * multiple clients, all requests within the same transaction must be
		 * associated with the same security context.
		 */

		section("CORE.12.6", RS.COMPLETED);
		section("CORE.12.6.1", RS.COMPLETED);

		section("CORE.12.6.2", RS.COMPLETED);

		/*
		 * The EJB container provides a security domain and one or more
		 * principal realms to the enterprise beans.
		 */

		/*
		 * The EJB architecture does not specify how an EJB server should
		 * implement a security domain, and does not define the scope of a
		 * security domain.
		 */

		section("CORE.12.6.3", RS.COMPLETED);

		/*
		 * The EJB Container Provider must provide the security mechanisms
		 * necessary to enforce the security policies set by the Deployer. The
		 * EJB specification does not specify the exact mechanisms that must be
		 * implemented and supported by the EJB server.
		 */

		section("CORE.12.6.4", RS.COMPLETED);
		section("CORE.12.6.5", RS.COMPLETED);
		section("CORE.12.6.6", RS.COMPLETED);
		section("CORE.12.6.7", RS.COMPLETED);
		section("CORE.12.6.8", RS.COMPLETED);

		/*
		 * The EJB specification does not define the “system” principal under
		 * which the JVM running an enterprise bean’s method executes.
		 */

		section("CORE.12.6.9", RS.COMPLETED);
		section("CORE.12.6.10", RS.COMPLETED);

		/* The EJB container may provide a security audit trail mechanism */

		section("CORE.12.7", RS.COMPLETED);
		section("CORE.12.7.1", RS.COMPLETED);
		section("CORE.12.7.2", RS.COMPLETED);
		section("CORE.12.7.3", RS.COMPLETED);

		section("CORE.13", RS.COMPLETED);
		section("CORE.13.1", RS.COMPLETED);
		section("CORE.13.2", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				class MyTimer {
					@Timeout
					public void timeout() {

					}
				}
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				class MyTimer implements TimedObject {
					@Override
					public void ejbTimeout(Timer timer) {

					}
				}
			}
		});

		Schedule.class.isAnnotation();

		/* Timers cannot be created for stateful session beans. */

		/*
		 * The timeout callback method invocation for a timer that is created
		 * for a stateless session bean or a message-driven bean may be called
		 * on any bean instance in the pooled state.
		 */

		/*
		 * The timeout callback method for a programmatically created persistent
		 * timer will be invoked on the JVM on which the timer was created or on
		 * another JVM instance across which the container is distributed.
		 */

		/*
		 * The timeout callback method for a programmatically created
		 * non-persistent timer will be invoked on the JVM on which the timer
		 * was created.
		 */

		/*
		 * The timeout callback method for a programmatically created timer is
		 * invoked on a single JVM instance regardless of the number of JVMs
		 * across which the container is distributed.
		 */

		/* persistent timer */

		/*
		 * For each automatically-created persistent timer, the container
		 * creates a single persistent timer, regardless of the number of JVMs
		 * across which the container is distributed. For automatically-created
		 * non-persistent timers, the container creates a new non-persistent
		 * timer during application initialization for each JVM across which the
		 * container is distributed.
		 */

		/*
		 * In the event of a container crash or container shutdown, the timeout
		 * callback method for a persistent timer that has not been cancelled
		 * will be invoked on a new JVM when the container is reCOMPLETED or on
		 * another JVM instance across which the container is distributed. This
		 * rule applies to both programmatically or automatically created
		 * persistent timers.
		 */

		/* A timer is cancelled by calling its cancel method. */

		timer.cancel();

		/*
		 * Invocations of the timeout callback methods and the methods of the
		 * Timer Service to programmatically create timers and to cancel timers
		 * are typically made within a transaction.
		 */

		section("CORE.13.2.1", RS.COMPLETED);

		/* calendar-based syntax that is modeled after the UNIX cron facility */

		section("CORE.13.2.1.1", RS.COMPLETED);

		/*-
		 * - second : 0..59
		 * - minute : 0..59
		 * - hour : 0..23
		 * - dayOfMonth : 1..31 ; -7..-1 ; "1st", "2nd", "3rd", "5th", "Last" ; "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
		 * - month : 1..12 ; "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
		 * - dayOfWeek : 0..7 ; "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
		 * - year
		 */

		section("CORE.13.2.1.2", RS.COMPLETED);

		/* single value, wildcard, list, range, increments, */

		/*-
		 * - 10
		 * - Sep
		 * - *
		 * - 10,20,30
		 * - Mon, Wed, Fri
		 * - 0-10,30,40
		 * - 1-10
		 * - Fri-Mon
		 * - 27-3
		 * - * / 5
		 * - 30/10
		 * - * / 14
		 */

		/*
		 * Time zones are specified as an ID String[91]. The set of required
		 * time zone IDs is defined by the Zone Name(TZ) column of the public
		 * domain zoneinfo database [35].
		 */

		section("CORE.13.2.1.3", RS.COMPLETED);

		/*- default values
		 * - second : 0
		 * - minute : 0
		 * - hour : 0
		 * - dayOfMonth : *
		 * - month : *
		 * - dayOfWeek : *
		 * - year : *
		 */

		/*
		 * If the dayOfMonth attribute has a non-wildcard value and the
		 * dayOfWeek attribute has a non-wildcard value, then the timer expires
		 * when the current day matches the dayOfMonth attribute or the
		 * dayOfWeek attribute
		 */

		/* string constants are case insensitive */

		/*
		 * “5th” is the highest ordinal number allowed as the value for the
		 * dayOfMonth
		 */

		/*
		 * The increments syntax is only supported within the second, minute,
		 * and hour attributes.
		 */
		section("CORE.13.2.1.4", RS.COMPLETED);

		/*-
		 * - dayOfWeek="Mon"
		 * - minute="15", hour="3", dayOfWeek="Mon-Fri"
		 * - minute="15", hour="3", timezone="America/New_York"
		 * - minute="*", hour="*"
		 * - second="30", hour="12", dayOfWeek="Mon,Wed,Fri"
		 * - minute="* / 5", hour="*"
		 * - hour="14", dayOfMonth="Last Thu", month="Nov"
		 * - hour="1", dayOfMonth="-1"
		 * - hour="12/2", dayOfMonth="2nd Tue"
		 */

		section("CORE.13.2.2", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					@Schedule(hour = "1", dayOfMonth = "1", info = "titi")
					public void foo(Timer t) {
						t.getInfo();
					}

					@Schedules({ @Schedule(hour = "1"), @Schedule(month = "1") })
					public void bar() {
					}
				}
			}
		});

		section("CORE.13.2.3", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyThingy {
					@Schedule(hour = "1", persistent = false)
					public void foo() {
					}
				}
			}
		});

		section("CORE.13.2.4", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				timer = timerService.createTimer(duration, info);
				timer = timerService.createTimer(date, info);
				timer = timerService.createSingleActionTimer(duration, timerConfig);
				timer = timerService.createSingleActionTimer(date, timerConfig);
				timer = timerService.createTimer(initialDuration, intervalDuration, info);
				timer = timerService.createTimer(initialExpiration, intervalDuration, info);
				timer = timerService.createIntervalTimer(initialDuration, intervalDuration, timerConfig);
				timer = timerService.createIntervalTimer(initialExpiration, intervalDuration, timerConfig);
				timer = timerService.createCalendarTimer(scheduleExpression);
				timer = timerService.createCalendarTimer(scheduleExpression, timerConfig);
				timers = timerService.getTimers();
				timers = timerService.getAllTimers();
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				timerConfig.setPersistent(false);
				timerConfig.setInfo(info);
			}
		});

		/*
		 * The getTimers method returns active timers associated with the bean.
		 * These include all active persistent timers regardless of the number
		 * of JVMs across which the container is distributed, and active
		 * non-persistent timers created in the same JVM as the executing
		 * method. Timers returned by this method include both the
		 * programmatically-created timers and the automatically-created timers.
		 */

		/*
		 * The getAllTimers method returns active timers associated with the
		 * beans in the same module in which the caller bean is packaged. These
		 * include all active persistent timers regardless of the number of JVMs
		 * across which the container is distributed, and active non-persistent
		 * timers created in the same JVM as the executing method. Timers
		 * returned by this method include both the programmatically-created
		 * timers and the automatically-created timers.
		 */

		section("CORE.13.2.4.1", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				scheduleExpression = new ScheduleExpression().dayOfWeek("Sat").hour(1);
				timer = timerService.createCalendarTimer(scheduleExpression);
			}
		});

		section("CORE.13.2.5", RS.COMPLETED);

		/*
		 * timeout callback methods for timers that are programmatically created
		 * via a TimerServicetimer creation method
		 */

		/*
		 * timeout callback methods for timers that are automatically created
		 * via the Schedule annotation or the deployment descriptor
		 */

		section("CORE.13.2.5.1", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyTimer {
					@Timeout
					public void myTimeout() {
					}
				}

			}
		});

		section("CORE.13.2.5.2", RS.COMPLETED);

		section("CORE.13.2.5.3", RS.COMPLETED);
		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyTimer {
					@Timeout
					public void myTimeout() {
					}
				}

			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				@SuppressWarnings("unused")
				class MyTimer {
					@Timeout
					public void myTimeout(Timeout t) {
					}
				}

			}
		});

		/* Timeout callback methods must not throw application exceptions. */

		/*
		 * The time at which a timeout callback method is called may therefore
		 * not correspond exactly to the time specified at timer creation.
		 */

		/*
		 * the Bean Provider must be prepared to handle timeout callbacks that
		 * are out of sequence
		 */

		/*
		 * The Bean Provider must be prepared to handle extraneous calls to a
		 * timeout callback method in the event that a timer expiration is
		 * outstanding when a call to the cancellation method has been made.
		 */

		/* a timeout callback method has no client security context */

		/*
		 * If the bean invokes the getNextTimeout or getTimeRemaining method on
		 * the timer associated with a timeout callback while within the timeout
		 * callback, and there are no future timeouts for this calendar-based
		 * timer, the NoMoreTimeoutsException must be thrown.
		 */

		section("CORE.13.2.6", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				timer.cancel();
				timeRemaining = timer.getTimeRemaining();
				nextTimeout = timer.getNextTimeout();
				scheduleExpression = timer.getSchedule();
				timerHandle = timer.getHandle();
				info = timer.getInfo();
				persistent = timer.isPersistent();
				isCalendarTimer = timer.isCalendarTimer();
			}
		});

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				timer = timerHandle.getTimer();
			}
		});

		section("CORE.13.2.7", RS.COMPLETED);

		dontRun(new NotRunnable() {
			@Override
			public void dontRun() throws Exception {
				timer.equals(timer);
			}
		});

		section("CORE.13.2.8", RS.COMPLETED);

		/*
		 * An enterprise bean typically creates a timer within the scope of a
		 * transaction. If the transaction is then rolled back, the timer
		 * creation is rolled back.
		 */

		/*
		 * A timer is typically cancelled within a transaction. If the
		 * transaction is rolled back, the container rescinds the timer
		 * cancellation.
		 */

		/*
		 * A timeout callback method on a bean with container-managed
		 * transactions must have transaction attribute REQUIRED or REQUIRES_NEW
		 */

		section("CORE.13.3", RS.COMPLETED);
		section("CORE.13.3.1", RS.COMPLETED);
		section("CORE.13.3.2", RS.COMPLETED);

		/* A TimerHandle is intended to be storable in persistent storage. */

		section("CORE.13.4", RS.COMPLETED);
		section("CORE.13.4.1", RS.COMPLETED);
		section("CORE.13.4.2", RS.COMPLETED);
		section("CORE.13.4.3", RS.COMPLETED);
		section("CORE.13.4.4", RS.COMPLETED);

		section("CORE.14", RS.STARTED);
		section("CORE.14.1", RS.UNTOUCHED);
		section("CORE.14.2", RS.UNTOUCHED);
		section("CORE.14.3", RS.UNTOUCHED);
		section("CORE.14.4", RS.UNTOUCHED);
		section("CORE.14.5", RS.UNTOUCHED);

		section("CORE.15", RS.UNTOUCHED);
		section("CORE.15.1", RS.UNTOUCHED);
		section("CORE.15.2", RS.UNTOUCHED);
		section("CORE.15.3", RS.UNTOUCHED);
		section("CORE.15.4", RS.UNTOUCHED);
		section("CORE.15.4.1", RS.UNTOUCHED);
		section("CORE.15.4.2", RS.UNTOUCHED);
		section("CORE.15.4.3", RS.UNTOUCHED);
		section("CORE.15.4.4", RS.UNTOUCHED);
		section("CORE.15.4.5", RS.UNTOUCHED);
		section("CORE.15.5", RS.UNTOUCHED);
		section("CORE.15.5.1", RS.UNTOUCHED);
		section("CORE.15.5.2", RS.UNTOUCHED);
		section("CORE.15.6", RS.UNTOUCHED);
		section("CORE.15.7", RS.UNTOUCHED);
		section("CORE.15.8", RS.UNTOUCHED);

		section("CORE.16", RS.UNTOUCHED);
		section("CORE.16.1", RS.UNTOUCHED);
		section("CORE.16.1.1", RS.UNTOUCHED);
		section("CORE.16.1.2", RS.UNTOUCHED);
		section("CORE.16.2", RS.UNTOUCHED);
		section("CORE.16.2.1", RS.UNTOUCHED);
		section("CORE.16.2.2", RS.UNTOUCHED);
		section("CORE.16.3", RS.UNTOUCHED);
		section("CORE.16.3.1", RS.UNTOUCHED);
		section("CORE.16.3.2", RS.UNTOUCHED);
		section("CORE.16.3.3", RS.UNTOUCHED);
		section("CORE.16.3.4", RS.UNTOUCHED);
		section("CORE.16.3.5", RS.UNTOUCHED);
		section("CORE.16.3.6", RS.UNTOUCHED);
		section("CORE.16.3.7", RS.UNTOUCHED);

		section("CORE.17", RS.UNTOUCHED);
		section("CORE.17.1", RS.UNTOUCHED);
		section("CORE.17.2", RS.UNTOUCHED);
		section("CORE.17.3", RS.UNTOUCHED);
		section("CORE.17.4", RS.UNTOUCHED);
		section("CORE.17.4.1", RS.UNTOUCHED);
		section("CORE.17.4.2", RS.UNTOUCHED);
		section("CORE.17.4.3", RS.UNTOUCHED);
		section("CORE.17.5", RS.UNTOUCHED);
		section("CORE.17.5.1", RS.UNTOUCHED);
		section("CORE.17.5.2", RS.UNTOUCHED);

		section("CORE.18", RS.UNTOUCHED);
		section("CORE.18.1", RS.UNTOUCHED);
		section("CORE.18.2", RS.UNTOUCHED);
		section("CORE.18.2.1", RS.UNTOUCHED);
		section("CORE.18.2.2", RS.UNTOUCHED);
		section("CORE.18.2.2.1", RS.UNTOUCHED);
		section("CORE.18.2.2.2", RS.UNTOUCHED);
		section("CORE.18.2.2.3", RS.UNTOUCHED);
		section("CORE.18.2.3", RS.UNTOUCHED);
		section("CORE.18.2.4", RS.UNTOUCHED);
		section("CORE.18.3", RS.UNTOUCHED);
		section("CORE.18.3.1", RS.UNTOUCHED);
		section("CORE.18.3.2", RS.UNTOUCHED);
		section("CORE.18.3.3", RS.UNTOUCHED);
		section("CORE.18.3.4", RS.UNTOUCHED);

		section("CORE.19", RS.UNTOUCHED);
		section("CORE.19.1", RS.UNTOUCHED);
		section("CORE.19.1.1", RS.UNTOUCHED);
		section("CORE.19.1.2", RS.UNTOUCHED);
		section("CORE.19.2", RS.UNTOUCHED);
		section("CORE.19.3", RS.UNTOUCHED);
		section("CORE.19.4", RS.UNTOUCHED);
		section("CORE.19.5", RS.UNTOUCHED);
		section("CORE.19.6", RS.UNTOUCHED);

		section("CORE.20", RS.UNTOUCHED);

		// - end of outline

		section("OPTIONAL", RS.UNTOUCHED);
	}

}
