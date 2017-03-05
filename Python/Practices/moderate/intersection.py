"""
Intersection: Given two straight line segments (represented as a start point and an end point),
compute the point of intersection, if any.
"""

def intersection(start1,end1,start2,end2):
    # edge cases: check if params are null

    # slopes y-y1/x-x1 = m
    m1 = (end1[1] - start1[1]) / (end1[0] - start1[0])
    m2 = (end2[1] - start2[1]) / (end2[0] - start2[0])

    if start1 == start2:
        return start1

    if m1 == m2:
        return None
    # intersection m1(x-x1) +y1 = m2(x-x2) + y2
    # m1*x - m1*x1 = m2*x-m2*x2 + y2 - y1
    # (m1-m2)*x = m1*x1-m2*x2 + y2 - y1
    x = (((m1*start1[0])-(m2*start2[0]))+start2[1]-start1[1])/(m1-m2)
    y = m1*(x-start1[0])+start1[1]
    return (x,y)


start1,end1,start2,end2 = (1,2),(4,6),(3,3),(1,1)
print(intersection(start1,end1,start2,end2))
