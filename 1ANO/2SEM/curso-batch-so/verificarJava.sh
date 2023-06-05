#!bin/usr/

which java | grep /usr/bin/java
which java | grep ~/.sdkman/candidates/java/current/bin/java

{ #try 
	sudo dnf install -y openjdk11-jre-headless
} ||  { #catch
	sudo apt install -y openjdk11-jre-headless
} 
