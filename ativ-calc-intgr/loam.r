library(ggplot2)


df <- read.csv("dataset.csv", header = TRUE, sep = ",")

# homens casados
df[(df$Gender == "Male") & (df$Married == "Yes"), ]
