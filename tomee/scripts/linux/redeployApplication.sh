#!/bin/bash 
# source the properties:  
source env.properties
echo "delete $tomeeWebappDir/$applicationName and $tomeeWebappDir/$warName"
rm -rf "$tomeeWebappDir/$applicationName"
#rm  -f "$tomeeWebappDir/$warName"
echo copy "$projectDir/$applicationName/$warDir/$warName to $tomeeWebappDir"
cp -u "$projectDir/$applicationName/$warDir/$warName" "$tomeeWebappDir/$warName"
