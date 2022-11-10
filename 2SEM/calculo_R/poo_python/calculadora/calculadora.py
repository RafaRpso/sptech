class Calculadora:

    def __init__(self, a, b):  # construtor
        self.a = a
        self.b = b

    def somar(self):
        return self.a + self.b

    def sub(self):
        return self.a - self.b

    def mult(self):
        return self.a * self.b

    def div(self):
        return self.a / self.b
