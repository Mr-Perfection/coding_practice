"""
Permutations with Dups: Write a method to compute all permutations of a string whose charac-
ters are not necessarily unique. The list of permutations should not have duplicates.
"""
def permute_with_dups(S):
    # initializations
    arr,solution,p = S[:],[],[]
    # generate permutations and add them to the list
    create_permutations(arr,solution,p)
    # return a list of all permuted strings
    return solution

def create_permutations(S,solution,p):
    # base case: if length of p is same as S, then terminate the recursion
    if len(S) == len(p):
        # add p to the solution
        temp = ''.join(p[:])
        if temp in solution:
            return
        solution.append(temp)
        #print(solution)
        return
    # get the candidates = S - p to eliminate the duplicates
    temp = p[:]
    cs = [x for x in S if x not in temp or temp.remove(x) ]
    # iterate through the candidates
    for i in range(len(cs)):
        # get the candidate (pop)
        c = cs[i]
        # push to the p
        p.append(c)
        # recurse with new p
        create_permutations(S,solution,p)
        # pop the candidate from the p
        p.pop()

xs = ['a','b','a','b']
ys = [1,3]
#print([x for x in xs if x not in ys or ys.remove(x)])
#print(list(set(xs)-set(ys)))
print(permute_with_dups(xs))

# time: n * n!
# space: n * n!

    # if
