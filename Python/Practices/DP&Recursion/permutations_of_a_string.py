"""
Permutations without Dups: Write a method to compute all permutations of a string of unique characters.

abc
acb
bac
bca
cab
cba
"""
def permute_without_dups(S):
    # initializations
    arr,solution,p,index = S[:],[],[],0
    # generate permutations and add them to the list
    create_permutations(arr,solution,p)
    # return a list of all permuted strings
    return solution

def create_permutations(S,solution,p):
    # base case: if length of p is same as S, then terminate the recursion
    if len(S) == len(p):
        # add p to the solution
        temp = p[:]
        solution.append(temp)
        #print(solution)
        return
    # get the candidates = S - p to eliminate the duplicates
    cs = list(set(S)-set(p))
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

xs = [1,2,3,4]
ys = [1,3]
#print([x for x in xs if x not in ys or ys.remove(x)])
#print(list(set(xs)-set(ys)))
print(permute_without_dups(xs))

# time: n * n!
# space: n * n!
