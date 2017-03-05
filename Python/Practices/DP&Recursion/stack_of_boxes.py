"""
Stack of Boxes: You have a stack of n boxes, with widths Wi' heights hi' and depths di.
The boxes cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly larger than the box above it in width, height, and depth. Implement a method to compute the height of the tallest possible stack.
The height of a stack is the sum of the heights of each box.
"""
class Box:
    def __init__(self,w,h,d):
        self.width = w
        self.height = h
        self.depth = d

# [(1,2,3),(5,10,15),(4,9,14)]
#     2        10        10+9
#    [2,0,0]  [2,10,0]  [2,10,19]

def create_stack(boxes,index,cache):
    cache[index] = boxes[index][1]
    for i in range(index-1,-1,-1):
        if boxes[i+1][0] < boxes[i][0] and\
           boxes[i+1][1] < boxes[i][1] and\
           boxes[i+1][2] < boxes[i][2]:
            cache[i] = cache[i+1] + boxes[i][1]
        else:
            cache[i] = boxes[i][1]
    return cache[index]

def stack_of_boxes(boxes):
    #initializaitons
    cache = [0 for i in range(len(boxes))]
    max_height = 0
    # for i length-1...0
    for i in range(len(boxes)-1,-1,-1):
        # if cache[i] == 0
        if cache[i] == 0:
            cache[i] = create_stack(boxes,i,cache)
        max_height = max(max_height,cache[i])
    return max_height

test = [(1,2,3),(5,10,15),(4,9,14),(3,7,10)]
print(test)
print(stack_of_boxes(test))
