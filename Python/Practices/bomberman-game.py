"""
https://www.hackerrank.com/challenges/bomber-man

"""

#def create_map()
class Cell:
    def __init__(self,state,time):
        self.state = state
        self.time  = time
        self.detonated = False
    def update(self,current_time):
        #print("bomb time is:",self.time,self.state)
        if self.state == 'O':
            self.time += 1
            if self.time == 3:
                self.detonated = True
                self.state = '.'
        else:
            if current_time % 2 == 0:
                self.state = 'O'
                self.time = 1

    def damaged(self):
        if self.state == 'O':
            self.state = '.'

def damage_nearby(map,i,j):

    if i > 0:
        map[i-1][j].damaged()

    if i < len(map)-1:
        if map[i+1][j].time != 2:
            map[i+1][j].damaged()

    if j > 0:
        map[i][j-1].damaged()

    if j < len(map[0])-1:
        #print("["+str(i)+"]","["+str(j)+"]","is", map[i][j+1].time)
        if map[i][j+1].time != 2:
            map[i][j+1].damaged()
    #print("count is:",count)

def update_map(map,t):
    for i in range(len(map)):
        for j in range(len(map[0])):
            map[i][j].update(t)
            if map[i][j].detonated:
                #print("detonated",i,j)
                damage_nearby(map,i,j)
                map[i][j].detonated = False
            #print(map[i][j].state,end=' ')
        #print('\n')
    #print('\n\n')

if __name__ == "__main__":
    map,results = [],[]
    # get rows, columns, and time from the first line
    R,C,t = list(int(x) for x in input().split(' '))

    if t % 2 == 0:
        for i in range(R):
            print('O'*C)
    else:
        for i in range(R):
            sub = list(Cell(s,0) for s in list(input()))
            map.append(sub)
        #print(map)
        for i in range(t):
            update_map(map,i+1)
        results = '\n'.join(list(''.join(list(col.state for col in cols)) for cols in map))
        print(results)






    # solution
r, c, n = map(int, raw_input().strip().split())
if n % 2 == 0:
    for i in xrange(r):
        print 'O'*c
else:
    grid = [raw_input() for i in xrange(r)]
    n /= 2
    for it in xrange(min(n, (n + 1) % 2 + 1)):
        ngrid = [['O']*c for i in xrange(r)]
        def setgrid(i, j, ch):
            if 0 <= i < r and 0 <= j < c:
                ngrid[i][j] = ch
        for i in xrange(r):
            for j in xrange(c):
                if grid[i][j] == 'O':
                    setgrid(i, j, '.')
                    setgrid(i+1, j, '.')
                    setgrid(i-1, j, '.')
                    setgrid(i, j+1, '.')
                    setgrid(i, j-1, '.')

        grid = ngrid

for row in grid:
    print ''.join(row)
