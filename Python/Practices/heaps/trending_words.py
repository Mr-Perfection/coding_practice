"""
There is a big file of words which is dynamically changing.
We are continuously adding some words into it. How would you keep track of top 10 trending words at each moment?

Assumptions:
    - words are added every time and need to keep track of 10 trending words every time.
    - heap size is limited.
Components:

# if heap size is unlimited...
* TrendingWords
    - using hashmap to keep track of word counts and max_heap to keep track of top 10 trending words.
    - insert_word(word), O(log(n)):
        - map[word] = map[word]+1, O(1)
        - if capacity <= 11, heap.heappush((map[word],word))
        - else, heap.heappop(words) and heap.heappush((map[word],word)), removes the smallest value
    - top_10_trending(), O(log(n)):
        - ws = heapq.nlargest(10,words)

"""
import heapq

class Word:
    def __init__(self,word,count):
        self.word = word
        self.count = count

    def __cmp__(self, other):
        if self.count > other.count:
            return 1
        elif self.count < other.count:
            return -1
        else:
            return 0

class TrendingWords:
    def __init__(self,capacity,words=[]):
        self.words = {}
        self.trending_words = []
        self.capacity = capacity
        if words:
            for i in range(len(words)):
                self.insert_word(words[i])

    def insert_word(self,word):
        if word not in self.words:
            self.words[word] = 1
        else:
            self.words[word] += 1
            word.count += 1
        heapq.heappush(trending_words,Word())

        if self.capacity == 0:
            # remove the smallest value
            heapq.heappop(trending_words)
            # increments the capacity
            self.capacity += 1
        else: self.capacity -= 1

    def top_n_trending(self,n):
        if n >= capacity: raise ValueError('n should be less than capacity')
        return heapq.nlargest(n,trending_words)
