from calculadora import Calculadora


class Main:

    c = Calculadora(20, 10)

    print(f"""
    Adição: {c.somar()}
    Subtração: {c.sub()}
    Multiplicação: {c.mult()}
    Divisão: {c.div()}

    """)
