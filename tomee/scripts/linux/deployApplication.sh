#!/bin/bash

INSTANCE_PATH=$1 # where runs tomee
PACKAGE_PATH=$2 # where to find stuff to deploy
DEPLOY_PATH=$INSTANCE_PATH/webapps

# delete webapps/war file
rm -f $INSTANCE_PATH/webapps/lirejarp.war
rm -rf $INSTANCE_PATH/webapps/lirejarp

# copy new war file
cp $PACKAGE_PATH $DEPLOY_PATH

# start tomee
#nohup $INSTANCE_PATH/bin/startup.sh &> $INSTANCE_PATH/logs/nohup.log