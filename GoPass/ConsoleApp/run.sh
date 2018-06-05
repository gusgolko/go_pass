#!/bin/bash

#################################
## Author: Kosara Golemshinska ##
##### Modified: 2018-06-05 ######
#################################

cd ~/go_pass/GoPass/

if [ ! -d classes ]
then
	mkdir classes
else
	rm classes -r
	mkdir classes
fi

javac -d ~/go_pass/GoPass/classes/ ~/go_pass/GoPass/ConsoleApp/src/*.java

cd ~/go_pass/GoPass/classes/

java -cp . src/Main
