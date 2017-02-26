# design a hashmap
# 1) create a huge list that contains individual key-value pairs
# 2) create a list that contains linked-list nodes each has key and value and is indexed by  hasing algorithm


storage = []
# use hashing function
def hashing(input):
    return hash(str(input)) % len(storage)
def check_capacity(key,value):

def put(key,value):
    if check_capacity(key,value):
        pass
