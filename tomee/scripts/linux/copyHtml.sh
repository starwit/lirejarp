#!/bin/bash
#properties:  

source env.properties
cd $WEBSOURCEDIR
cp -rf ./* $WEBTARGETDIR

#rsync -av --progress "$WEBSOURCEDIR" "$WEBTARGETDIR" --exclude="$WEBSOURCEDIR/WEB-INF"

