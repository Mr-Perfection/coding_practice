

'''
matrix =
a b c d
d a e g
r g m n
g k z y

words = [bark, bag, car, cag]
'''

matrix = [['a','b','c','d'],['d','a','e','g'],['r','g','m','n'],['g','k','z','y']]
words = ['bark','bag','car','cag']

def find_words(matrix,words):
    valid_words = []
    visited = [[False] * len(matrix[0])] * len(matrix)
    for row in range(len(matrix)):
        for col in range(len(matrix[0])):
            search_word(matrix, visited, row, col, '', words, valid_words)
    return valid_words

def is_word(word, words):
    for w in words:
        if w == word:
            return True

    return False

def search_word(matrix, visited, row, col, word,words, result):
    m,n = len(matrix),len(matrix[0])

    visited[row][col] = True
    word += matrix[row][col]

    print(word)
    if is_word(word,words):
        result.append(word)

    for i in range(row-1,row+2):
        if i >= m: continue
        for j in range(col-1,col+2):
            if j >= n: continue
            if i >= 0 and j >= 0 and not(visited[i][j]):
                search_word(matrix, visited, i, j, word, words, result)

    word = word[:len(word)-1]
    visited[row][col] = False





print(find_words(matrix,words))
