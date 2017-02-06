input1 = '''Justin $5
Stephen $1
Stephen $6
John $1'''

class Person(object):
    def __init__(self, name, value):
        self.name = name
        self.value = value
    def __lt__(self, other):
        return self.value < other.value
    def __gt__(self, other):
        return self.value > other.value
    def __eq__(self, other):
        return self.value == other.value

def make_into_tuples(raw_string):
    lines = raw_string.split('\n')
    li = []

    di = {}
    for line in lines:
        name, value = line.split(' ')
        value = int(value[1:])

        if name not in di:
            di[name] = value
        else:
            di[name] += value

    return di

di = make_into_tuples(input1)

li = []
for key in di:
    li.append(Person(key, di[key]))

li.sort(reverse=True)

for item in li:
    print(item.name,'$'+ str(item.value))
