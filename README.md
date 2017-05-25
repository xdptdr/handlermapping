# manybranches (EJB-Timer)

EJB Timer example

This branch features two EJB no-view session beans and a servlet.

TimerSingleton is a singleton session bean, which creates a timer in its @PostConstruct method. The timer simply increments an instance counter every second.

TimerStateless is a stateless session bean. Since timers cannot be created in the @PostConstruct method of stateless session beans, this bean has an additional createTimer method.

The timer of the TimerStateless bean also increments an instance variable counter, which is very bad practice indeed.

There is no stateful session bean here since timers cannot be run on stateful session beans. 

TimerServlet is a servlet that references the two beans, and invokes the createTimer method in its init method. It is set to autoload on startup so that the createTimer is invoked as soon as the project is deployed.

The servlet only dumps the values of the two timers, using the getCounter() function of each bean.

It can be observed that the TimerSingleton bean instanciation is delayed until the first request, as can be told by the difference of value between the two counters.

Note : this project includes maven commands to start/deploy/shutdown/clean wildfly, so it should be self contained.

Instruction:

* git clone https://github.com/xdptdr/manybranches.git -b EJB-Timers
* mvn initialize -P start-wildfly
* mvn verify -P deploy-wildfly
* go to http://localhost:8080/manybranches-ejbwar-1.0/
* mvn initialize -P shutdown-wildfly



