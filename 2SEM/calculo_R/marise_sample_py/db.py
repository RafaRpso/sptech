import pymysql


db = pymysql.connect(user='aluno', passwd='sptech',
                     host='localhost',
                     db='webCrowler')

cursor = db.cursor()


def insert(component, data, date):
    query = f'INSERT INTO {component} VALUES (null, {data}, "{date}") '

    cursor.execute(query)

    db.commit()
