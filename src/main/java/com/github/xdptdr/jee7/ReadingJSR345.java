package com.github.xdptdr.jee7;

import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.NoSuchEJBException;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.enterprise.inject.Vetoed;
import javax.xml.ws.WebServiceRef;

public class ReadingJSR345 extends Reading {

	private Future<Object> future;
	private boolean mayInterruptIfRunning;
	private SessionContext sessionContext;

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

		section("CORE.2.4", RS.UNTOUCHED);

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

		section("CORE.4", RS.STARTED);
		section("CORE.4.1", RS.UNTOUCHED);
		section("CORE.4.2", RS.UNTOUCHED);
		section("CORE.4.2.1", RS.UNTOUCHED);
		section("CORE.4.2.2", RS.UNTOUCHED);
		section("CORE.4.3", RS.UNTOUCHED);
		section("CORE.4.3.1", RS.UNTOUCHED);
		section("CORE.4.3.2", RS.UNTOUCHED);
		section("CORE.4.3.3", RS.UNTOUCHED);
		section("CORE.4.3.3.1", RS.UNTOUCHED);
		section("CORE.4.3.4", RS.UNTOUCHED);
		section("CORE.4.3.5", RS.UNTOUCHED);
		section("CORE.4.3.6", RS.UNTOUCHED);
		section("CORE.4.3.7", RS.UNTOUCHED);
		section("CORE.4.3.8", RS.UNTOUCHED);
		section("CORE.4.3.9", RS.UNTOUCHED);
		section("CORE.4.3.9.1", RS.UNTOUCHED);
		section("CORE.4.3.9.2", RS.UNTOUCHED);
		section("CORE.4.3.10", RS.UNTOUCHED);
		section("CORE.4.3.11", RS.UNTOUCHED);
		section("CORE.4.3.12", RS.UNTOUCHED);
		section("CORE.4.3.13", RS.UNTOUCHED);
		section("CORE.4.3.13.1", RS.UNTOUCHED);
		section("CORE.4.3.14", RS.UNTOUCHED);
		section("CORE.4.4", RS.UNTOUCHED);
		section("CORE.4.4.1", RS.UNTOUCHED);
		section("CORE.4.4.1.1", RS.UNTOUCHED);
		section("CORE.4.4.1.2", RS.UNTOUCHED);
		section("CORE.4.4.2", RS.UNTOUCHED);
		section("CORE.4.4.2.1", RS.UNTOUCHED);
		section("CORE.4.4.2.2", RS.UNTOUCHED);
		section("CORE.4.5", RS.UNTOUCHED);
		section("CORE.4.5.1", RS.UNTOUCHED);
		section("CORE.4.5.2", RS.UNTOUCHED);
		section("CORE.4.5.2.1", RS.UNTOUCHED);
		section("CORE.4.5.2.2", RS.UNTOUCHED);
		section("CORE.4.5.3", RS.UNTOUCHED);
		section("CORE.4.5.4", RS.UNTOUCHED);
		section("CORE.4.5.5", RS.UNTOUCHED);
		section("CORE.4.6", RS.UNTOUCHED);
		section("CORE.4.6.1", RS.UNTOUCHED);
		section("CORE.4.6.2", RS.UNTOUCHED);
		section("CORE.4.6.3", RS.UNTOUCHED);
		section("CORE.4.6.4", RS.UNTOUCHED);
		section("CORE.4.6.5", RS.UNTOUCHED);
		section("CORE.4.6.6", RS.UNTOUCHED);
		section("CORE.4.6.7", RS.UNTOUCHED);
		section("CORE.4.7", RS.UNTOUCHED);
		section("CORE.4.7.1", RS.UNTOUCHED);
		section("CORE.4.7.2", RS.UNTOUCHED);
		section("CORE.4.7.3", RS.UNTOUCHED);
		section("CORE.4.8", RS.UNTOUCHED);
		section("CORE.4.8.1", RS.UNTOUCHED);
		section("CORE.4.8.2", RS.UNTOUCHED);
		section("CORE.4.8.3", RS.UNTOUCHED);
		section("CORE.4.8.4", RS.UNTOUCHED);
		section("CORE.4.8.5", RS.UNTOUCHED);
		section("CORE.4.8.5.1", RS.UNTOUCHED);
		section("CORE.4.8.5.2", RS.UNTOUCHED);
		section("CORE.4.8.5.3", RS.UNTOUCHED);
		section("CORE.4.8.5.4", RS.UNTOUCHED);
		section("CORE.4.8.5.5", RS.UNTOUCHED);
		section("CORE.4.8.6", RS.UNTOUCHED);
		section("CORE.4.9", RS.UNTOUCHED);
		section("CORE.4.9.1", RS.UNTOUCHED);
		section("CORE.4.9.2", RS.UNTOUCHED);
		section("CORE.4.9.3", RS.UNTOUCHED);
		section("CORE.4.9.4", RS.UNTOUCHED);
		section("CORE.4.9.5", RS.UNTOUCHED);
		section("CORE.4.9.6", RS.UNTOUCHED);
		section("CORE.4.9.7", RS.UNTOUCHED);
		section("CORE.4.9.8", RS.UNTOUCHED);
		section("CORE.4.9.9", RS.UNTOUCHED);
		section("CORE.4.9.10", RS.UNTOUCHED);
		section("CORE.4.9.11", RS.UNTOUCHED);
		section("CORE.4.9.12", RS.UNTOUCHED);
		section("CORE.4.9.13", RS.UNTOUCHED);
		section("CORE.4.10", RS.UNTOUCHED);
		section("CORE.4.10.1", RS.UNTOUCHED);
		section("CORE.4.10.2", RS.UNTOUCHED);
		section("CORE.4.10.3", RS.UNTOUCHED);
		section("CORE.4.10.4", RS.UNTOUCHED);
		section("CORE.4.10.5", RS.UNTOUCHED);
		section("CORE.4.10.6", RS.UNTOUCHED);
		section("CORE.4.10.7", RS.UNTOUCHED);
		section("CORE.4.10.8", RS.UNTOUCHED);
		section("CORE.4.10.9", RS.UNTOUCHED);
		section("CORE.4.10.10", RS.UNTOUCHED);
		section("CORE.4.10.11", RS.UNTOUCHED);
		section("CORE.4.10.12", RS.UNTOUCHED);
		section("CORE.4.10.13", RS.UNTOUCHED);
		section("CORE.4.10.14", RS.UNTOUCHED);
		section("CORE.4.10.15", RS.UNTOUCHED);
		section("CORE.4.10.16", RS.UNTOUCHED);

		// - end of outline

		section("CORE.5", RS.UNTOUCHED);
		section("CORE.6", RS.UNTOUCHED);
		section("CORE.7", RS.UNTOUCHED);
		section("CORE.8", RS.UNTOUCHED);
		section("CORE.9", RS.UNTOUCHED);
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
