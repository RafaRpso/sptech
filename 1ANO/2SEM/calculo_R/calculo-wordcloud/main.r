library(tm)
library(wordcloud,wordcloud2)
library(RColorBrewer)

main.function <- function() { 


    dash_n <- rep("dashboard_não_aparece",60)
    dashboard_travado <- rep("dashboard_travado",160)
    temp_el <- rep("temperatuda_elevada", 120)
    CPU_consumo_elevado <- rep("CPU_consumo_elevado", 80)
    app_slow <- rep("aplicação_lenta", 100)
    up_slow <- rep("uploado_lento", 60)
    download_lento <- rep("download_lento", 20)
    memoria_cheia <- rep("memoria_cheia", 20)
    alerta_dispara <- rep("alerta_dispara", 20)
    dados_incorretos <- rep("dados_incorretos", 20)
    disco_consumo_elevado <- rep("disco_consumo_elevado", 20)
    usuario_nao_pode_ser_cadastrado <- rep("usuario_nao_pode_ser_cadastrado", 40)
    maq_n_cadastra <- rep("maquina_nao_poder_ser_cadastrada", 20)
    login_nao_funciona <- rep("login_nao_funciona", 20)

    df <- c(dash_n, dashboard_travado, temp_el, CPU_consumo_elevado,
            app_slow, up_slow, download_lento, memoria_cheia, alerta_dispara, dados_incorretos,
            disco_consumo_elevado, usuario_nao_pode_ser_cadastrado, maq_n_cadastra,
            login_nao_funciona)

    datasample <- sample(df, 350)

    dcs1<-Corpus(VectorSource(datasample))

    dtm<-TermDocumentMatrix(dcs1)


    matdc1<- as.matrix(dtm)

    words<-sort(rowSums(matdc1),decreasing=TRUE)

    df<-data.frame(word=names(words),freq=words)

    df1= df[ df$freq> 1.0,]

    wordcloud(words= df1$word, freq= df$freq, min.freq = 3,max.words = 250,random.order = FALSE, rot.per=0.65,colors=brewer.pal(7, "Dark2"), scale = c(7,2))

} 

main() 