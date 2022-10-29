
dataUser <- as.numeric(readline("Insira um valor"))
dataUser2 <- as.numeric(readline("Insira um valor"))

if (dataUser > dataUser2 ) { 
  print(paste("É maior: ", dataUser, sep=""))
} else if (dataUser2 > dataUser){
  print(paste(" É maior: ", dataUser2, sep=""))
}else { 
  print("Mesmo valor ")
}