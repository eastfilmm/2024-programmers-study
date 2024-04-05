from itertools import combinations

def solution(relation):

    keys = []
    for ii in range(1, len(relation[0])+1):
        keys.extend(combinations(range(len(relation[0])), ii))
    
    unique = []
    for key in keys:
        tmp = [tuple([r[k] for k in key]) for r in relation]
        if len(set(tmp)) == len(relation):
            flag = True
            for u in unique:
                if set(u).issubset(set(key)):
                    flag = False
                    break
            if flag:
                unique.append(key)
        
    answer = len(unique)
    return answer

