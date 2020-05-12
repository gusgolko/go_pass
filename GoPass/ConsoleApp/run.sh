#!/bin/bash

#################################
## Author: Kosara Golemshinska ##
##### Modified: 2020-05-11 ######
#################################

# Check that the script is ran from the correct path.
echo
START_PATH=$(pwd)
START_BASE=$(basename "$START_PATH")
CHECK_PATH="ConsoleApp"
if [ "$START_BASE" != "$CHECK_PATH" ]
then
	echo "Please run the start script from /ConsoleApp. Exiting..."
	echo
	exit 1
fi

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
MAIN_PATH=$(pwd)
CLASS_LOC=${MAIN_PATH}/classes/
cd $CLASS_LOC

# Compile the files in the bytecode directory.
javac -d $CLASS_LOC ${MAIN_PATH}/ConsoleApp/src/*.java

# Run the app.
java -cp . src/Main