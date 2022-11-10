# licenca rafael, nao pode copiar !!!!!


import pandas as pd
import numpy as np
from wordcloud import WordCloud, STOPWORDS
import matplotlib.pyplot as plt
from random import randint

messages = []
mock_messages = ["dashboard_não_aparece", "dashboard_travado", "temperatura_elevaada", "consumo_cpu_elevado", 'aplicação_lenta', "upload_lento", "download_lento",
                 'memória_cheia', 'alerta_dispara', 'dados_incorretos', 'disco_consumo_elevado', 'usuario_não_pode_ser_cadastrado', 'maquina_nao_pode_ser_cadastrada', 'login_não_funciona_']
mock_numbers = [60, 160, 120, 80, 100, 60, 20, 20, 20, 20, 20, 40, 20, 20]

comment_words = ''
stopwords = set(STOPWORDS)


def loop_range(message, loop):
    global comment_words
    for i in range(loop):
        messages.append(message.lower())


def sample(array, size):
    global comment_words
    new_arr = []
    for i in range(size):
        random_position = randint(0, len(array) - 1)
        new_arr.append(array[random_position])

        comment_words = comment_words + " " + array[random_position]
    return new_arr


def main():
    for i in range(len(mock_messages)):
        loop_range(mock_messages[i], mock_numbers[i])
    df = pd.DataFrame(messages,  columns=['Avisos'])

    df.to_csv('/home/rafaelraposo/Documentos/sptech/2SEM/calculo_R/calculo-wordcloud/avisos-slack.csv',
              sep=';', encoding='utf-8')

    sample(messages, 300)
    wordcloud()


def wordcloud():
    global comment_words
    wordcloud = WordCloud(width=800, height=800,
                          background_color='white',
                          stopwords=stopwords,
                          min_font_size=10).generate(comment_words)

    plt.figure(figsize=(8, 8), facecolor=None)
    plt.imshow(wordcloud)
    plt.axis("off")
    plt.tight_layout(pad=0)

    plt.show()


main()
