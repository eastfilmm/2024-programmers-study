from collections import Counter

def solution(topping):

    dic = Counter(topping)
    brother = set()
    answer = 0
    for t in topping:
        dic[t] -= 1
        brother.add(t)
        if dic[t] == 0:
            dic.pop(t)
        if len(dic) == len(brother):
            answer += 1

    return answer