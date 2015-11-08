# tomee

This is a subproject for the **LireJarp** architecture pattern. It provides a TomEE based runtime environment that can be used with 
maven commands only. It is based mainly on tomee-maven-plugin which can download, package and run a TomEE instance. This project 
demonstrate its usage plus it provides profiles with different flavors of TomEE configurations such as dev and production. This makes it 
easy to provide tailored environments for developers in a project as well as a delivery for staging or production environments. 
Project's pom.xml contains multiple profiles and for every profile a set of configuration files is stored in folder *src/main*.

## Usage ##
The following list shows most important commands. See plugin's documentation for a comprehensive list.
* ```mvn tomee:build``` downloads all components, builds TomEE and creates a zipped archive
* ```mvn tomee:start``` 
* ```mvn tomee:stop```

**References**

1. TomEE project page https://tomee.apache.org/
2. TomEE Maven plugin http://tomee.apache.org/tomee-maven-plugin.html