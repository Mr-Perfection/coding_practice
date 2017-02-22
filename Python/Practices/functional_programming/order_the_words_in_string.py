
def order(S):
    words,table,result = S.split(' '),{},[]
    for word in words:
        for c in list(word):
            if c.isdigit():
                table[int(c)] = word
    for i in range(1,10):
        if i in table:
            result.append(table[i])
    return ' '.join(result)

def order(S):

    return ' '.join(sorted(S.split(' '), key=lambda x: sorted(x)))

S = "is2 Thi1s T4est 3a"
print(order("is2 Thi1s T4est 3a" ))
print(sorted(S.split(' '), key=lambda x: sorted(x)))
