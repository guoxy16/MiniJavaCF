build:
		javac *.java

test:
		javac *.java
		java Main < ../test/BinaryTree.java

tests:
		javac *.java
		java Main < ../test/SyntaxError.java

test1:
		javac *.java
		java Main < ../test/1stPassTestbed.java

test2:
		javac *.java
		java Main < ../test/2ndPassTestbed.java

testc:
		javac *.java
		java Main < ../test/CyclicInheritence.java

test3:
		javac *.java
		java Main < ../test/3rdPassTestbed.java

rig:
		javac MiniJava*.java
		java org.antlr.v4.runtime.misc.TestRig MiniJava goal -gui < ../test/BinaryTree.java -gui		

rig3:
		javac MiniJava*.java
		java org.antlr.v4.runtime.misc.TestRig MiniJava goal -gui < ../test/3rdPassTestbed.java -gui		

rigr:
		javac MiniJava*.java
		java org.antlr.v4.runtime.misc.TestRig MiniJava goal -gui < ../test/ErrorRecovery.java

irig:
		javac MiniJava*.java
		java org.antlr.v4.runtime.misc.TestRig MiniJava goal -gui

grammar:
		java -jar /usr/local/lib/antlr-4.5.3-complete.jar MiniJava.g4 -visitor
