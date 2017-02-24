
# Find the missing term in an Arithmetic Progression

# O(n)
def find_missing(seq):
    # find the all differences between terms
    diffs = [seq[i+1]-seq[i] for i in range(len(seq)-1)]
    # get the index that has different diff
    #print(diffs)
    table = {}
    for diff in diffs:
        if diff not in table:
            table[diff] = 1
        else:
            table[diff] += 1
    for i in range(len(diffs)):
        if table[diffs[i]] == 1:
            if i < len(diffs)-1:
                return seq[i] + diffs[i+1]
            else:
                return seq[i] + diffs[i-1]
    return -1
