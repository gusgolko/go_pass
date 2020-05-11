#!/bin/bash

#################################
## Author: Kosara Golemshinska ##
##### Modified: 2020-05-11 ######
#################################


cd ..

# Make a directory for the bytecode if one doesn't exist.
if [ ! -d classes ]
then
	mkdir classes
else
	rm classes -r
	mkdir classes
fi

# Set the path to the bytecode directory.
START_PATH=$(pwd)
CLASS_LOC=${START_PATH}/classes/
cd $CLASS_LOC

# Compile the files in the bytecode directory.
javac -d $CLASS_LOC ${START_PATH}/ConsoleApp/src/*.java

# Run the app.
java -cp . src/Main