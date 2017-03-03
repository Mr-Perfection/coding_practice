""""Paint Fill: Implement the "paint fill" function that one might see on many image editing programs. That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color, nil in the surrounding area until the color changes from the original color."""

"""
[][] = [[],[],[]]
input: [[]],new color, a point (row,col of starting element)
(1,1)
1 46 123 32 1
2 31 23 123 43
42 2 32 11 112

"""

# bfs
def paint_filler(screen,new_color,start,visited):
    (row,col) = start
    if row >= len(screen) or col >= len(screen[0]) or\
       col < 0 or row < 0:
        return
    if visited[row][col] == True:
        return
    visited[row][col] = True
    screen[row][col] = new_color
    paint_filler(screen,new_color,(row-1,col),visited)
    paint_filler(screen,new_color,(row-1,col-1),visited)
    paint_filler(screen,new_color,(row-1,col+1),visited)
    paint_filler(screen,new_color,(row+1,col-1),visited)
    paint_filler(screen,new_color,(row+1,col),visited)
    paint_filler(screen,new_color,(row+1,col+1),visited)
    paint_filler(screen,new_color,(row,col+1),visited)
    paint_filler(screen,new_color,(row,col-1),visited)

def paint_fill(screen, new_color, start):
    visited = [[False for j in range(len(screen[0]))] for i in range(len(screen))]
    paint_filler(screen,new_color,start,visited)
    return screen
example = [[0,1,2,3],[0,1,2,3],[0,1,2,3],[0,1,2,3]]

print(example)
print(paint_fill(example,44,(1,2)))
