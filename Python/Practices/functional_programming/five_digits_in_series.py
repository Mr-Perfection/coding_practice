def solution(number):
    if len(number) <= 5:
        return int(number)
    digits = list(number)
    top = 0
    for i in range(0,len(digits)):
        if i + 5 <= len(digits):
            top = max(top,int(''.join(digits[i:i+5])))
    return top

def solution(dd):
    return max(int(dd[i:i+5]) for i in range(len(dd) - 4))
