"""
Deck of Cards: Design the data structures for a generic deck of cards.
Explain how you would subclass the data structures to implement blackjack.
"""
from random import randrange

class DeckOfCards:
    spade,heart,clover,diagmond = range(4)
    def __init__(self):
        self.suits = [[Card(i+1,j) for i in range(13)] for j in range(4)]

class Card:
    def __init__(self,value,suit):
        self.value = value
        self.suit = suit
        self.name = 'number' if self.value < 11 else 'face'

class Hand:
    total = 0
    def __init__(self):
        self.hand = []
    def get_card(self,card):
        self.hand.append(card)
        self.total += card.value
        if self.total > 21:
            print("busted!")
        else:
            print("you have",self.total,"value")
    
class BlackJack(DeckOfCards):
    next_card = None
    def __init__(self):
        super().__init__()
        
    def shuffle(self):
        s = randrange(0,len(self.suits))
        c = randrange(0,len(self.suits[s]))
        self.next_card = self.suits[s][c]
        self.suits[s].remove(self.next_card)
        if not(self.suits[s]):
            self.suits = [x for x in self.suits if x]
            
    def deal(self,hand):
        self.shuffle()
        hand.get_card(self.next_card)
        self.shuffle()

bj = BlackJack()
hand = Hand()
bj.deal(hand)
print(hand.total,hand.hand[0].suit)
# print(bj.suits)
