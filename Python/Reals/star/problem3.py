# you can write to stdout for debugging purposes, e.g.
# print "this is a debug message"

def solution(A, B, M, X, Y):
    # write your code in Python 2.7
    """
    floors = [0 to M ]
    elevator:
        max capacity of X people
        weight limit of Y lbs
    N people gathered in floor[0] standing in a queue()
    k: a kth numbered person
    A[k] = weight, B[k] = target floor or dst ex)A[0] and B[0] => 0th person

    count total number of times that elavator stops

    ex1)
    floors = [] * 6 (o to M=5)
    elavator:
        X = 2, Y = 200
    People:
        A = [60,80,40]
        B = [2,3,5]
        queue = [(a1,b1)...(an,bn)]
        queue = [(60,2), (80,3),(40,5)]

    my approach#1:
    * stops = 0
    * while queue is not empty
        * people = X ex) X = 2
        * elevator = [], weight = 0
        * while queue and people > 0 and weight <= Y
            values = queue.pop()
            elevator.push(values)
            weight += values[0]
            people -= 1
        * while elavator is not empty
            * values = elavator.dequeue()
            * while elavator and elavator.first[1] == values[1]
                * elavator.dequeue()
            stops += 1
        * stops += 1
    Time: O(N * M)?
    Space: O(M + N)

    """
    # assumed that all the inputs are valid and exist
    stops = 0
    queue = []
    N,i = len(A),0

    # add to queue (A[i],B[i])...
    while i < N:
        queue.append((A[i],B[i]))
        i += 1

    # while queue is not empty
    while queue:
        # intializations
        # max capacity of people &  weight
        people,weight = X,Y
        elevator = []

        while queue and people and weight > 0:
            values = queue[0]
            weight -= values[0]
            if weight < 0: break
            elevator.append(values)
            queue.pop(0)
            people -= 1
        # making stops for people inside the elevator
        # keep checking the next passenger is also at the same target floor as current pass.
        # if true, let them exit from elevator
        while elevator:
            values = elevator.pop(0)
            while elevator and elevator[0][1] == values[1]:
                elevator.pop(0)
            stops += 1
        stops += 1 # ending at ground level
    return stops


# didnt get a full mark on this one...
# overall, i got 74%
