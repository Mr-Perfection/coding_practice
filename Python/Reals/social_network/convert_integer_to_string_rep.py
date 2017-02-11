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
