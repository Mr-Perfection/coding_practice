def lcs(str1, str2):
    if not str1 or not str2:
        return ""
    x, xs, y, ys = str1[0], str1[1:], str2[0], str2[1:]
    if x == y:
        return x + lcs(xs, ys)
    else:
        return max(lcs(str1, ys), lcs(xs, str2), key=len)
def ascii_deletion_distance(str1, str2):
    sub = lcs(str1,str2)
    x,y,= sum([ord(c) for c in str1]),sum([ord(c) for c in str2])
    z = sum([ord(c) for c in sub])
    result = x + y - 2 * z
    return result

print(ascii_deletion_distance("at","cat"))