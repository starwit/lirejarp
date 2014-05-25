#!/bin/bash
# source the properties:  
source env.properties
echo copy "$projectDir/$applicationName/$webApp to $tomeeWebappDir/$applicationName"
cp -rf "$projectDir/$applicationName/$webApp" "$tomeeWebappDir/$applicationName"
