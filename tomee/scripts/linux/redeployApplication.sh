#!/bin/bash 
# source the properties:  
source env.properties

echo "delete $tomeeWebappDir/$applicationName and $tomeeWebappDir/$warName"
rm -rf "$WARTARGETDIR/lirejarp"
rm  -f "$WARFILE"
echo copy "$WARFILE to $tomeeWebappDir"
cp -u "$projectDir/$applicationName/$warDir/$warName" "$WARTARGETDIR"
