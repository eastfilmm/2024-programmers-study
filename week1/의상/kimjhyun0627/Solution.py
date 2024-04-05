from functools import reduce

def solution(clothes):
    lst = [c[1] for c in clothes]
    classification = set(lst)
    counts = [lst.count(c)+1 for c in classification]

    answer = reduce(lambda x,y : x*y, counts) - 1
    return answer