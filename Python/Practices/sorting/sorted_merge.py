"""
Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
end to hold B. Write a method to merge B into A in sorted order.

a = [1,2,4,6,None,None]
b = [3,5]

result = [1,2,3,4,5,6]

O(n) n is length of A

"""

def sorted_merge(A,B):
    if len(A) == 0 or len(B) == 0:
        return nil
    n,m = len(A) - A.count(0),len(B)
    indexA,indexB = n-1,m-1
    i = merged_index = n+m-1

    while indexB >= 0:
        if indexA >= 0 and A[indexA] > B[indexB]:
            A[i] = A[indexA]
            indexA -= 1
        else:
            A[i] = B[indexB]
            indexB -= 1
        i -= 1



a = [1,2,4,6,0,0]
b = [3,5]
print(len(a) - a.count(0))
sorted_merge(a,b)
print(a)
