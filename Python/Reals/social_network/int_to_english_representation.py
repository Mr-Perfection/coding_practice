"""
Given an integer, return its english representation.

123 -> One Hundred Twenty Three
43 -> Fourty Three

{10: "ten"}
{20: "twenty"}
...
{1: "one"}
0-999
"""
# given x integer x = 987
def convert_to_english(x):
    table = {1:'One',2:'Two',3:'Three',4:'Four'.. 9:'Nine',10:'Ten',..90:'Ninety'}
    table = {3: 'Thousand', 5:'Ten Thousand'}
    # check if x > 99
    string = []
    while x > 0:
        string.append(x%10) # [7,8,9]
        x / 10
    if len(string) == 1:
        print(table[string[0]])
    if len(string) == 2:
        print(table[string[1]*10] + table[string[0]])
    if len(string) > 2:
        print(table[string[2]]+ 'Hundred' + table[string[1]*10] + table[string[0]])




"""
Given an integer, return its english representation.



123 -> One Hundred Twenty Three
43 -> Fourty Three

111234, count = 5

max int value = 2,147,483,647
points =        3   2   1   0

Time: O(n^2), n = length of the value
space: O(n)
"""
def create_points(value):
    result,rev = [],value[::-1]
    while rev:
        result.append(rev[:3])
        rev = rev[3:]
    return result
def convert_digits_to_english(answer, char_array):
    tens = {1:'Ten',2:'Twenty',3:'Thirty',4:'Forty',5:'Fifty',6:'Sixty',
            7:'Seventy',8:'Eighty',9:'Ninty'}
    ones = {1:'One',2:'Two',3:'Three',4:'Four',5:'Five',6:'Six',
            7:'Seven',8:'Eight',9:'Nine'}
    while char_array:
        c = char_array.pop()
        if len(char_array) == 2:
            answer.append(ones[int(c)] + ' ' + 'Hundred')
        elif len(char_array) == 1:
            answer.append(tens[int(c)])
        else:
            answer.append(ones[int(c)])
        #print(answer)

def convert_to_english(value):
    # initializations
    neg = False
    points = []
    int_values = []
    results = []
    # check negative or positive
    if value < 0:
        neg = True
    # convert integer value to char array
    int_values = str(value)
    # create a dictionary that correspond to this:
    # 0 : ''
    # 1 : 'Thousand'
    # 2 : 'Million'
    # 3 : 'Billion'
    table = {0:'', 1:'Thousand', 2:'Million', 3:'Billion'}
    # count all the points as described above ex) 543 = 0
    # create an list of points. Each point contains three digits
    points = create_points(int_values)
    # iterate point through points
    for i in range(len(points)-1,-1,-1):
        # 1st digit: hundred, 2nd digit: ten, 3rd digit: one
        result = []
        cs = list(points[i])
        convert_digits_to_english(result,cs)
        s = ' '.join(result) + ' ' + table[i]
        results.append(s)
    return ' '.join(results)

string = '1234'
print(create_points(string))
convert_digits_to_english([],['1','2','3'])
print(convert_to_english(1234))
