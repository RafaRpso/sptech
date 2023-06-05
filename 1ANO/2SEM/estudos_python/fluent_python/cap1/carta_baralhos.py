import collections
from random import choice
# tupla nomeada, card tem rank e tipos
class FrenchDeck:

    ranks = [str(n) for n in range(2, 11)] + list('JQKA') 
    suits = 'spades diamonds clubs hearts'.split()

    def __init__(self):  # inicializa
        self._cards = [Card(rank, suit) for suit in self.suits
                       for rank in self.ranks]

    def __len__(self):  # pega tamanho
        return len(self._cards)

    def __getitem__(self, position):  # recebe item
        return self._cards[position]


