library(ggplot2)
library(dplyr)


df <- read.csv("~/Documentos/ativ-calc-intgr/dataset.csv", header = TRUE, sep = ",")
count_homens_casados <- 0
count_mulheres_casadas <- 0

homens_casados <- df[(df$Gender == "Male") & (df$Married == "Yes"), ]

mulheres_casadas <- df[(df$Gender == "Female") & (df$Married == "Yes"), ]

for (i in homens_casados) {
    count_homens_casados <- count_homens_casados + 1
}
for (i in mulheres_casadas) {
    count_mulheres_casadas <- count_mulheres_casadas + 1
}


plot(count_homens_casados, count_mulheres_casadas)
