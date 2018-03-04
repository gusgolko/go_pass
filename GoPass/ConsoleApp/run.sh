#!/bin/bash

#################################
## Author: Kosara Golemshinska ##
##### Modified: 2018-03-04 ######
#################################

javac ~/go_pass/GoPass/ConsoleApp/src/Generator.java
javac ~/go_pass/GoPass/ConsoleApp/src/Main.java

cd ~/go_pass/GoPass/ConsoleApp

java -cp . src/Main
