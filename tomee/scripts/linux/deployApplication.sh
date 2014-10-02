#!/bin/bash

INSTANCE_PATH=$1 # where runs tomee
PACKAGE_PATH=$2 # where to find stuff to deploy
DEPLOY_PATH=$INSTANCE_PATH/webapps

# stop tomee
$INSTANCE_PATH/bin/shutdown.sh

sleep 6 # wait some time to let tomee finish shutdown

# delete webapps/war file
rm -f $INSTANCE_PATH/webapps/lirejarp.war
rm -rf $INSTANCE_PATH/webapps/lirejarp

# copy new war file
cp $PACKAGE_PATH $DEPLOY_PATH

# start tomee
$INSTANCE_PATH/bin/startup.sh