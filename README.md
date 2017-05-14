# manybranches (MBeanExporter)

Instructions : create a tomcat server with the following jvm arguments :

* `-Dcom.sun.management.jmxremote`
* `-Dcom.sun.management.jmxremote.port=8181`
* `-Dcom.sun.management.jmxremote.authenticate=false`
* `-Dcom.sun.management.jmxremote.ssl=false`

Launch jconsole and connect it to localhost:8181