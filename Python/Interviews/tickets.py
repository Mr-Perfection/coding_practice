# Given an array of tickets(start, destination)
# [('SF', 'NY'), ('SJ', 'Chicago'), ('Chicago', 'LA'), ('NY', 'SJ')]
# Find the order of which the tickets were used by this person
# Assume no loops

# SF NY SF

# result:
# SF -> NY -> SJ -> Chicago -> LA

"""
tickets = {}
tickets["SF"] = "NY"
tickets["SF"] = "NY"

"""
ds = [('SJ', 'Chicago'), ('NY', 'SF'),  ('LA','Chicago'), ('NY', 'SJ')]

"""
NY -> SF
NY -> SJ -> Chicago
LA -> Chicago
"""
tickets = {}
for d in ds:
    tickets[d[0]] = d[1]

def get_start(tickets):
    # {'SJ': 'Chicago', 'NY': 'SJ', 'Chicago': 'LA', 'SF': 'NY'}
    values = set()
    for city in tickets:
        values.add(tickets[city])
    for city in tickets:
        if city not in values:
            arr.append(city)
    return arr
    # [('SF', 'NY'), ('SJ', 'Chicago'), ('Chicago', 'LA'), ('NY', 'SJ')]
        
def dfs(tickets, start):
    result = [start]
    stack = [tickets[start]]
    while stack:
        v = stack.pop()
        result.append(v)
        if v not in tickets:
            return result
        stack.append(tickets[v])

    return float("inf")
print(tickets)
start = get_start(tickets)
print(start)

print(dfs(tickets, start))

# time: O(n)
# space: O(2n) = O(n)





"""My Solution"""

"""
tickets = {}
tickets["SF"] = "NY"
tickets["SF"] = "NY"

"""
ds = [('SJ', 'Chicago'), ('NY', 'SF'),  ('LA','Chicago'), ('NY', 'SJ')]

"""
NY -> SF
NY -> SJ -> Chicago
LA -> Chicago
"""

"""
Tickets:
    SJ:[Chicago,NY]
    NY:[SF,SJ]
    LA:[Chicago]
    Chicago:[SJ,LA]
    SF:[NY]
    LA->chicago->SJ->NY->SF
    SF->NY->SJ->Chicago->LA
    
    - LA and SF are the start points (one that has only one value)
    
"""
from collections import defaultdict

tickets = defaultdict(list)
for d in ds:
    tickets[d[0]].append((d[1]))
for d in ds:
    tickets[d[1]].append((d[0]))

def get_start_city(tickets):
    for key in tickets:
        if len(tickets[key]) == 1:
            return key
    return None
    

def dfs(tickets, start):
    result = []
    visited = set([start])
    stack = [start]
    while stack:
        key = stack.pop()
        result.append(key)
        for city in tickets[key]:
            if city not in visited:
                visited.add(city)
                stack.append(city)
    return result

print(tickets)
start = get_start_city(tickets)
print(start)
print(dfs(tickets, start))

# time: O(n)
# space: O(2n) = O(n)