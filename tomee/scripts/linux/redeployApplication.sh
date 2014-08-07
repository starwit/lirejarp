#!/bin/bash 
# source the properties:  
source env.properties

echo "delete $tomeeWebappDir/$applicationName and $tomeeWebappDir/$warName"
rm -rf "$WARTARGETDIR/lirejarp"
rm  -f "$WARTARGETDIR/lirejarp.war"
echo copy "$WARFILE to $tomeeWebappDir"
cp -u "$WARFILE" "$WARTARGETDIR"
