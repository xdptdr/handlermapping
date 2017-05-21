package com.github.xdptdr.jee7;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.security.Identity;
import java.security.Principal;
import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import javax.ejb.AccessTimeout;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.BeforeCompletion;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.ConcurrentAccessException;
import javax.ejb.ConcurrentAccessTimeoutException;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.ejb.NoSuchEJBException;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.SessionSynchronization;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.transaction.UserTransaction;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.handler.MessageContext;

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

		section("CORE.9", RS.UNTOUCHED);
		section("CORE.9.1", RS.UNTOUCHED);
		section("CORE.9.1.1", RS.UNTOUCHED);
		section("CORE.9.1.2", RS.UNTOUCHED);
		section("CORE.9.2", RS.UNTOUCHED);
		section("CORE.9.2.1", RS.UNTOUCHED);
		section("CORE.9.2.2", RS.UNTOUCHED);
		section("CORE.9.3", RS.UNTOUCHED);
		section("CORE.9.3.1", RS.UNTOUCHED);
		section("CORE.9.3.2", RS.UNTOUCHED);
		section("CORE.9.3.3", RS.UNTOUCHED);
		section("CORE.9.3.4", RS.UNTOUCHED);
		section("CORE.9.3.5", RS.UNTOUCHED);
		section("CORE.9.3.6", RS.UNTOUCHED);
		section("CORE.9.3.7", RS.UNTOUCHED);
		section("CORE.9.3.8", RS.UNTOUCHED);
		section("CORE.9.3.9", RS.UNTOUCHED);
		section("CORE.9.3.10", RS.UNTOUCHED);
		section("CORE.9.4", RS.UNTOUCHED);
		section("CORE.9.4.1", RS.UNTOUCHED);
		section("CORE.9.4.2", RS.UNTOUCHED);
		section("CORE.9.4.2.1", RS.UNTOUCHED);
		section("CORE.9.4.2.2", RS.UNTOUCHED);
		section("CORE.9.4.2.3", RS.UNTOUCHED);
		section("CORE.9.5", RS.UNTOUCHED);

		// - end of outline
		
		section("CORE.10", RS.UNTOUCHED);
		section("CORE.11", RS.UNTOUCHED);
		section("CORE.12", RS.UNTOUCHED);
		section("CORE.13", RS.UNTOUCHED);
		section("CORE.14", RS.UNTOUCHED);
		section("CORE.15", RS.UNTOUCHED);
		section("CORE.16", RS.UNTOUCHED);
		section("CORE.17", RS.UNTOUCHED);
		section("CORE.18", RS.UNTOUCHED);
		section("CORE.19", RS.UNTOUCHED);
		section("CORE.20", RS.UNTOUCHED);
		section("OPTIONAL", RS.UNTOUCHED);
	}

}
