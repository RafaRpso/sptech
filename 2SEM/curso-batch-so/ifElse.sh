#!bin/bash 

which java | grep  ~/.sdkman/candidates/java/current/bin/java
if [$? = 0 ]  
	then echo "Java não instalado " 
	else echo "Java  instalado " 
	
fi 
	
