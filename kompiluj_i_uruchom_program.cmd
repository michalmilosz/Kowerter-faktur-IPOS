 @ECHO OFF

set path="C:\Program Files\Java\jdk-11.0.1\bin";
TITLE My_conventer

javac -d class ./src/*.java

set CLASSPATH=.\class

java EfektKoncowy

PAUSE