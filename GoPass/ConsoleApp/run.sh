#!/bin/bash

#################################
## Author: Kosara Golemshinska ##
##### Modified: 2018-03-06 ######
#################################

javac -d ~/go_pass/GoPass/classes/ ~/go_pass/GoPass/ConsoleApp/src/*.java

cd ~/go_pass/GoPass/classes/

java -cp . src/Main
