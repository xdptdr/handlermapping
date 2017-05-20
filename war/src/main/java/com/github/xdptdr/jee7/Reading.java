package com.github.xdptdr.jee7;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ConfigProperty;
import javax.resource.spi.Connector;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.resource.spi.work.Work;
import javax.resource.spi.work.WorkManager;

public class Reading {

	public static enum RS {
		UNTOUCHED, STARTED, COMPLETED
	}

	public static enum WIITC {
		UNDECIDED, DEFINITELY, UNLIKELY, DEFINITELY_NO
	}

	private String section;

	public void reading() throws ResourceException {

		BootstrapContext boostrapContext = i(BootstrapContext.class);
		WorkManager workManager = i(WorkManager.class);
		ManagedConnectionFactory managedConnectionFactory = i(ManagedConnectionFactory.class);
		ActivationSpec activationSpec = i(ActivationSpec.class);
		Work work = i(Work.class);
		ResourceAdapter resourceAdapter = i(ResourceAdapter.class);

		section("1.4", RS.COMPLETED, WIITC.UNDECIDED);

		/*
		 * JDBC 3.0 specifies the relationship of JDBC to the SPI specified in
		 * JCA.
		 */

		section("2.2.1", RS.COMPLETED, WIITC.UNDECIDED);

		/*
		 * JCA reduces the scope of the integration problem from m*n to m+n
		 */

		section("5", RS.COMPLETED, WIITC.UNDECIDED);
		section("5.3", RS.COMPLETED, WIITC.UNDECIDED);

		/* application server implements BootstrapContext and WorkManager */

		section("5.3.1", RS.COMPLETED, WIITC.DEFINITELY);

		/*
		 * implementation class name of the resource adapter is specified in the
		 * resource adapter deployment descriptor or trough the Connector
		 * annotation
		 */

		Connector.class.isAnnotation();

		/* a resource adapter must be a JavaBean */

		/* the resource adapter bean is created during deployment */

		/* bootstrapping a resource adapter involves calling its start method */

		resourceAdapter.start(boostrapContext);

		/*
		 * resource adapters are singleton beans, but may be replicated when
		 * using several jvms
		 */

		/*
		 * resource adapters must implement the equals method so that the
		 * container may distinguish between multiple instances of a resource
		 * adapter configured differently (my interpretation)
		 */

		resourceAdapter.equals(resourceAdapter);

		/*
		 * the BootstrapContext contains references to application servers
		 * facilities, such as the WorkManager
		 */

		boostrapContext.getWorkManager();
		boostrapContext.getTransactionSynchronizationRegistry();
		boostrapContext.getXATerminator();

		/*
		 * within the start method, a resource adapter may use the work manager,
		 * but should avoid using doWork
		 */

		/* the call to start should be fast */

		{ // within start
			workManager = boostrapContext.getWorkManager();
			workManager.doWork(work); // avoid
			workManager.scheduleWork(work); // prefer
			workManager.startWork(work); // prefer
		}

		/*
		 * a resource adapter may hold references to a ManagedConnectionFactory,
		 * an ActivationSpec, or other private objects
		 */

		/* ManagedConnectionFactory provides outbound connectivity */

		/* ActivationSpec provides inbound connectivity */

		/*
		 * A ResourceAdapter may hold references to several
		 * ManagedConnectionFactory and several ActivationSpec
		 */

		section("5.3.2", RS.COMPLETED, WIITC.DEFINITELY);

		/* ManagedConnectionFactory represents outbound connectivity */

		/*
		 * implementing ResourceAdapterAssociation allows a
		 * ManagedConnectionFactory instance to be linked to its ResourceAdapter
		 */

		{
			resourceAdapter = i(ResourceAdapter.class);
			managedConnectionFactory = i(ManagedConnectionFactory.class);
			((ResourceAdapterAssociation) managedConnectionFactory).setResourceAdapter(resourceAdapter);
		}

		/*
		 * setResourceAdapter must be called only once, the association must not
		 * change after
		 */

		section("5.3.3", RS.COMPLETED, WIITC.UNDECIDED);

		/* ActivationSpec represents outbound connectivity */

		{
			resourceAdapter = i(ResourceAdapter.class);
			activationSpec = i(ActivationSpec.class);
			activationSpec.setResourceAdapter(resourceAdapter);

		}

		section("5.3.4", RS.COMPLETED, WIITC.UNDECIDED);

		/*
		 * a resource adapter may shutdown because the it is being undeployed or
		 * because the application server is being shutdown
		 */

		section("5.3.4.1", RS.COMPLETED, WIITC.UNDECIDED);

		/* phase 1 includes deactivating all messages endpoints */

		/*
		 * there may be a delay because some applications may still be using the
		 * resource adapter at the time shutdown is requested
		 */

		section("5.3.4.2", RS.COMPLETED, WIITC.UNDECIDED);

		// phase 2 includes stopping the resource adapter
		{
			resourceAdapter.stop();
		}

		// exceptions during stopping are logged at best

		section("5.3.5", RS.COMPLETED, WIITC.UNDECIDED);

		{
			resourceAdapter = i(ResourceAdapter.class);
			resourceAdapter.start(boostrapContext);
			// ...
			resourceAdapter.stop();
		}

		section("5.3.6", RS.COMPLETED, WIITC.UNDECIDED);

		/*
		 * resource adapter specific objects should register them with the
		 * resource adapter
		 */

		{
			resourceAdapter = i(ResourceAdapter.class);

			managedConnectionFactory = i(ManagedConnectionFactory.class);
			((ResourceAdapterAssociation) managedConnectionFactory).setResourceAdapter(resourceAdapter);

			activationSpec = i(ActivationSpec.class);
			activationSpec.setResourceAdapter(resourceAdapter);

		}

		/*
		 * the resource adapter threads should periodically poll the resource
		 * adapter state, and use bounded blocking I/O
		 */

		section("5.3.7", RS.COMPLETED, WIITC.UNDECIDED);

		/* the resource adapter instance is created during deployment */

		/*
		 * ManagedConnectionFactory and ActivationSpec can be instantiated any
		 * time during the lifetime of the resource adapter
		 */

		section("5.3.7.3", RS.COMPLETED, WIITC.UNDECIDED);

		/*
		 * if a resource adapter and a managed connection factory both define
		 * the bean property P
		 * 
		 * and if P is defined on the resource adapter's configuration
		 * 
		 * then the managed connection factory will inherit the value specified
		 * on the resource adapter specification
		 */

		section("5.3.7.4", RS.COMPLETED, WIITC.UNDECIDED);

		/* above also applies to instances of ActivationSpec */

		section("5.3.7.5", RS.COMPLETED, WIITC.UNDECIDED);

		/*
		 * since resource adapters, managed connection factories and activation
		 * specifications are java beans, they can use the Bean Validation
		 * annotations
		 */

		section("5.3.7.6", RS.COMPLETED, WIITC.UNDECIDED);
		
		/* dynamic configuration properties : use config-property-supports-dynamicupdates in XML or the following: */
		
		i(ConfigProperty.class).supportsDynamicUpdates();
		
		/* JavaBean Validation should be performed each time a dynamic resource property is modified */
		
		/* application servers are not required to support dynamic resource adapter configuration */
		
		/* confidential properties can be indicated with config-property-confidential in XML or the follownig: */
		
		i(ConfigProperty.class).confidential();
		
		
		section("5.3.7.7", RS.COMPLETED, WIITC.UNDECIDED);
		
		

		section("5.3.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("5.3.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.4.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.1.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.3.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.3.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.4.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.4.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.4.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.5.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.6.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.8.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.8.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.8.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.8.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.8.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.9.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.9.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.10", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.10.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("6.10.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.3.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.2.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.3.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.6.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.7.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.7.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.7.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.8.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.8.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.8.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.8.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.9.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.9.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.9.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.10", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.10.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.10.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.10.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.11", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.11.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.11.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.11.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.12", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.12.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.13", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.14", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.15", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.15.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.15.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.15.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.16", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.16.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.16.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.16.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("7.16.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.5.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.5.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.6.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.6.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.6.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.6.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("8.6.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.8.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.8.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.1.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("9.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.3.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.3.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.3.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.10", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.11", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.11.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.11.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("10.3.11.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.4.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.6.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.6.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("11.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("12", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("12.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("12.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.2.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.2.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.4.9.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.5.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.7.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.7.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.7.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.7.1.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.7.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.7.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.7.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.8.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.8.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.8.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.8.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.8.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("13.8.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("14", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("14.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("14.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("14.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("14.3.0.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.4.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.4.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.4.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.4.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("15.4.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.4.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("16.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.5.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.5.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.5.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.2.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.2.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.2.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.2.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.6.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.7.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.7.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.7.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.9.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.9.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10.1.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10.1.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.10.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.1.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.11.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.12", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.12.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.12.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.12.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.12.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("17.12.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.4.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.4.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.7.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.8", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("18.9.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("19", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("19.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("19.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("19.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("19.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("19.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("19.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.2.0.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.2.0.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.2.0.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.2.0.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.4.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.4.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.4.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.4.2.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.4.2.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.5.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.5.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.5.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.5.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.1.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.6.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("20.7", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("21", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("21.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("21.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("21.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("21.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("21.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("21.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("21.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("22", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("22.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("22.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("22.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("22.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("22.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("23", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("23.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("23.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("23.1.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("23.1.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("23.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("23.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("23.2.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.A", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.A.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.A.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.A.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.B", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.B.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.B.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.B.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.B.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.1.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.1.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.1.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.2.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.2.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.C.3.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.3.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.3.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.3.2.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.3.2.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.3.2.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.4.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.5.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.5.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.5.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.5.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.D.5.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.E", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.F", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.F.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.F.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.F.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.F.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.F.5", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.G", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.G.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.G.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.G.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.G.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.H", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.H.1", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.H.2", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.H.3", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.H.4", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.I", RS.UNTOUCHED, WIITC.UNDECIDED);
		section("24.I.1", RS.UNTOUCHED, WIITC.UNDECIDED);

	}

	private <T> T i(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public String getSection() {
		return section;
	}

	private void section(String section, RS readingStatus, WIITC wouldIncludeInTeachingCourse) {
		this.section = section;
	}
}
