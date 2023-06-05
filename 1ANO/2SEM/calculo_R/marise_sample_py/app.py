import component as comp
import db
import os
import time
import pandas as pd
from datetime import datetime

components = ['cpu', 'ram', 'disco', 'temp']


def work_in_sample(df):

    return df.agg({
        "cpu":  ['min', 'max', 'mean', 'var', 'std', 'mad'],
        "ram":  ['min', 'max', 'mean', 'var', 'std', 'mad'],
        "disco":  ['min', 'max', 'mean', 'var', 'std', 'mad'],
        "temp":  ['min', 'max', 'mean', 'var', 'std', 'mad'],

    }).round(2)


def create_sample():
    df = pd.read_csv('pop.csv', sep=';')
    print(df.head())

    for i in range(len(components)):
        df2 = df.sample(n=200, random_state=i, replace=True)
        df2 = work_in_sample(df2)
        df2.to_csv(f'sample{i+1}.csv', sep=';', encoding='utf-8')

    combined_csv = pd.concat(
        [pd.read_csv('sample1.csv'), pd.read_csv('sample2.csv'), pd.read_csv('sample3.csv'), pd.read_csv('sample4.csv')])
    combined_csv.to_csv("todas_samples.csv", index=False, encoding='utf-8')
    print('Finalizado')


def create_pop():
    loop = 2000
    data = {'cpu': [], 'ram': [], 'disco': [], 'temp': []}

    for i in range(loop):
        print(f'{round(i/loop * 100,1)}% concluido')
        date = datetime.now().strftime(' %Y:%m:%d %H:%M:%S')

        try:
            os.system('clear')
        except:
            os.system('cls')

        for j in components:

            data[j].append(comp.index_comp(j))
            db.insert(j, data[j][-1], date)

    df = pd.DataFrame(data)
    df.to_csv('pop.csv', sep=';', encoding='utf-8', index=False)


create_pop()
create_sample()
