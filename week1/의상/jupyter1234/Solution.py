def solution(clothes):
    answer = 0
    dict = {}
    size = len(clothes)
    for i in range(size):
        if clothes[i][1] in dict:
            dict[clothes[i][1]] += 1
        else:
            dict[clothes[i][1]] = 1
    #print(dict)  #	{'headgear': 2, 'eyewear': 1}
    temp = 1
    for v in dict.values():
         temp *= (v + 1)
    answer = temp-1
    return answer