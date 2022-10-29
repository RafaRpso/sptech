seed <- 36 

set.seed(seed) 
dados <- data.frame(Nome = c("Ana", "Maria", "Henrique", "Paula", "Felipe", 
                             "Carlos", "Cristiane"), Altura = sample(x = (150:190), size = 7, replace = TRUE)/100, 
                    Peso = sample(x = 48:100, size = 7, replace = TRUE))

dados$imc <- with(dados, Peso / Altura ** 2)

dados$recomendacao <- ifelse(dados$imc  > 25, "Sobrepeso", 
             ifelse(dados$imc  > 30, "Obeso",
                    ifelse(dados$imc  <18 , "Magro", "Ideal" )))
dados