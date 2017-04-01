def sorted_matrix_search(matrix,target):
    i = 0
    while i < len(matrix):
        result = binary_search(matrix,i,target)
        if result:
            return result
        i += 1
    return None

def binary_search(matrix,index,value):
    left,right = 0, len(matrix[index])-1

    while left <= right:

        mid = int((left+right) / 2)
        if value == matrix[index][mid]:
            return (index,mid)
        if value < matrix[index][mid]:
            right = mid - 1
        else:
            left = mid + 1
    return None

matrix = [[15,20,70],[20,40,80],[35,55,90]]

print(sorted_matrix_search(matrix,80))

# O(m * log(n))
