Prequisites
============
- the tomee and lirejarp folders are checked out under the same root folder
- Maven (3.0.4) is installed and the "bin" folder is added to your "Path" environment-variable
- JRE (I used 1.7.0_45) is installed and the JAVA_HOME environment-variable is created

Build and start application
=============================
LireJarp can build by running "mvn package" in lirejarp folder. This will result in a war file located in folder 
target which can be used to deploy application manually. 
Alternatively in folder tomee "mvn tomee:build" will build a fully configured TomEE application server. Note
there are three profiles available (dev, dev_ldap, prod) which will build different flavours of TomEE. Every instance
will use lirejarp/target folder for webapps. So once TomEE is started with "mvn tomee:start" lirejarp.war will be deployed
automatically. This is also true if war file is build again.


Via Window batch-scripts
--------------------------
- Under Windows you can use the scripts in "tomee/scripts" folder:
	- reinstallTomee.bat to install tomee for development --> the tomee is installed under "tomee/target/apache-tomee"
	- buildApplication.bat
	- redeployApplication.bat
	- startTomee.bat
	- stopTomee.bat

Open application
---------------------
In your browser, go to http://localhost:8080/lirejarp/


License
===================
This project comes under the conditions of the Apache License. You can find the license in the root folder of this repository.

TODO list references to licenses of used libs.