'''
Word Frequencies: Design a method to find the frequency of occurrences of any given word in a
book. What if we were running this algorithm multiple times?

O(n)
'''

string = 'abcd abc add axd abc abc abbccc'
word = 'abc'
memo = {}
def word_frequency(string,word):
    if word in memo:
        return memo[word]
    words,cnt = string.split(' '),0
    for w in words:
        if word == w:
            cnt += 1
    memo[word] = cnt
    return cnt

print(word_frequency(string,word))
print(memo)
