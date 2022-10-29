import random


class Gerador:

    def __init__(self, size, simbols_numbers) -> None:
        self.__size = size
        self.caracteres = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                           "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
        self.simbols_n_arr = ['1', '2', '3', '4', '5',
                              '6', '7', '8', '9', '0', '!', '@', '#', '$']
        self.simbols_numbers = 3

    def create_pass(self):
        char = ''
        for i in range(0, self.__size - self.simbols_numbers):
            if self.isLower():
                char += self.caracteres[self.get_random_value(
                    self.caracteres)].lower()
            else:
                char += self.caracteres[self.get_random_value(self.caracteres)]

        for i in range(0, self.simbols_numbers):
            char += self.simbols_n_arr[self.get_random_value(
                self.simbols_n_arr)]
        return char

    def isLower(self):
        istruth = random.randint(0, 1)
        if istruth == 0:
            return False
        else:
            return True

    def get_random_value(self, arr):
        return random.randint(0, len(arr)-1)
