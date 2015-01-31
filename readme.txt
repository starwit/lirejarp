Prequisites
============
- the tomee and lirejarp folders are checked out under the same root folder
- Maven (3.0.4) is installed and the "bin" folder is added to your "Path" environment-variable
- JRE (I used 1.7.0_45) is installed and the JAVA_HOME environment-variable is created

Build and start application
=============================
Via Maven
----------
- Also you can execute followoing steps
	- reinstall tomee: goto "tomee"-folder and execute "mvn tomee:build"
	- build application: goto "lirejarp"-folder and execute "mvn clean install" the lirejarp.war-file is created under "lirejarp/business/target"
	- deploy application: copy lirejarp.war from "lirejarp/business/target" to "tomee/target/apache-tomee/webapps/lirejarp.war"
	- undeploy application: delete "tomee/target/apache-tomee/webapps/lirejarp.war" and "tomee/target/apache-tomee/webapps/lirejarp"
	- start tomee: goto tomee/target/apache-tomee/bin and execute "catalina.bat start"
	- stop tomee: goto tomee/target/apache-tomee/bin and execute "catalina.bat stop"

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

