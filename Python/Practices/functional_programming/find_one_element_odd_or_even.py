def find_outlier(integers):
    odds = sum([1 for integer in integers if integer % 2 != 0])
    if odds != 1:
        for integer in integers:
            if integer % 2 == 0:
                return integer
    else:
        for integer in integers:
            if integer % 2 != 0:
                return integer
    return -1

def find_outlier(integers):
    odds = [x for x in integers if x % 2 != 0]
    evens = [x for x in integers if x % 2 == 0]
    return len(odds) > len(evens) ? evens[0] : odds[0]
