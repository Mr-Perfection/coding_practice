"""
Find all possible combinations of given digits

"""
"""
Find all possible combinations of given digits

No repeating permutation.
1234

output:
1234
1243
1324
1432
...

Time: O(n^2)
"""

def find_combo(digits):
    # initializaitons
    # convert digits to s to list
    ds,combos = list(str(digits)),[]
    combo = ds[:]

    # call helper method
    find_combo_helper(len(ds),combos,combo,0)
    # return all possible digits
    return combos

def find_combo_helper(length, result, combo,index):
    # if combo length is equal to digits
    if index >= length-1:
        # check if it is in the result list
        temp = ''.join(combo[:])
        print(temp)
        if temp not in result:
            # if not, add combo to result
            result.append(temp)
        return
    # iterate i through all digits
    for i in range(index,length):
        # swap combo[index] and combo[i]
        combo[index],combo[i] = combo[i],combo[index]
        # recurse
        find_combo_helper(length,result,combo,i+1)
        # swap back
        combo[i],combo[index] = combo[index],combo[i]

print(find_combo(1234))
