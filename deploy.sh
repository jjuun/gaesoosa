#!/bin/bash

#start script
cd /home/ubuntu/deploy/gaesoosa/
echo "git pull start"
git pull
if [ $? -ne 0 ]
then
    echo "git pull error"
    exit
fi
echo "gradlew build"
./gradlew build
if [ $? -ne 0 ]
then
    echo "gradle build fail"
    exit
fi
echo "application stop"
./starter.sh stop
if [ $? -ne 0 ]
then
    echo "application stop error"
    exit
fi
echo "application start"
./starter.sh start
if [ $? -ne 0 ]
then
    echo "application start error"
    exit
fi
echo "deploy end"
