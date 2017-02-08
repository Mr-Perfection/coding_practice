
class Fib:
    """iterator that yields numbers in fib sequence"""
    def __init__(self,max):
        self.max = max

    def __iter__(self):
        self.a = 0
        self.b = 1
        return self

    def __next__(self):
        fib = self.a
        # stops iteration when it's done
        if fib > self.max:
            raise StopIteration
        self.a,self.b = self.b,self.a+self.b
        return fib

fib = Fib(19)
print(fib.__class__)
print(fib.__doc__)
print(fib.max)

for n in fib:
    print(n,end=' ')


class Points(object):
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    def __sub__(self, no):
        x = self.x - no.x
        y = self.y - no.y
        z = self.z - no.z
        return Points(x,y,z)
    def dot(self, no):
        return self.x*no.x+self.y*no.y+self.z*no.z

    def cross(self, no):
        x = self.y * no.z - self.z * no.y
        y = self.z * no.x - self.x * no.z
        z = self.x * no.y - self.y * no.x
        return Points(x,y,z)

    def absolute(self):
        return pow((self.x ** 2 + self.y ** 2 + self.z ** 2), 0.5)





#map and lambda function
#https://www.hackerrank.com/challenges/map-and-lambda-expression
cube = lambda x: x**3
class Fib:
    def __init__(self,max_count):
        self.max_count = max_count
        self.count = 0
    def __iter__(self):
        self.a = 0
        self.b = 1
        return self
    def __next__(self):
        fib,count = self.a,self.count
        if count >= self.max_count:
            raise StopIteration
        self.count+=1
        self.a,self.b = self.b,self.a+self.b
        return fib

def fibonacci(n):
    # return a list of fibonacci numbers
    return list(x for x in Fib(n))
    #return list(map(lambda x: x**3,nums))
