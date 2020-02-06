#Note: 
#
#This project needs JavaFX. It is included in Java 10 so this is our recommended version. 
#
#If Java 10 is not your "default" Java you can run "make RUN_JAVA=/Library/Java/JavaVirtualMachines/jdk-10.0.2.jdk/Contents/Home/bin/java RUN_JAVAC=/Library/Java/JavaVirtualMachines/jdk-10.0.2.jdk/Contents/Home/bin/javac"
#
#If you insist on using Java 11, JavaFX has to be installed manually.



SRCFILES = eu/lightest/gtpl/datatype/*.java eu/lightest/gtpl/formats/*.java eu/lightest/gtpl/gtpl/*.java eu/lightest/gtpl/parser/*.java eu/lightest/gtpl/GTPL.java

RUN_JAVA = java
RUN_JAVAC = javac

all:
	make GTPL.class
	$(RUN_JAVA) -cp antlr4-runtime-4.7.1.jar:build eu.lightest.gtpl.GTPL

GTPL.class:	
	$(RUN_JAVAC)  -d build $(SRCFILES) 

clean:	
	$(RM)  build/eu/lightest/gtpl/datatype/*.class build/eu/lightest/gtpl/formats/*.class build/eu/lightest/gtpl/gtpl/*.class build/eu/lightest/gtpl/parser/*.class eu/lightest/gtpl/GTPL.class
