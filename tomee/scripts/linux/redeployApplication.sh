#!/bin/bash 
# source the properties:  
source env.properties

echo "delete $WARTARGETDIR/$applicationName and $WARTARGETDIR/${applicationName}.war"
rm -rf "$WARTARGETDIR/$applicationName"
rm  -f "$WARTARGETDIR/${applicationName}.war"
echo copy "$WARFILE to $WARTARGETDIR"
cp -u "$WARFILE" "$WARTARGETDIR"
