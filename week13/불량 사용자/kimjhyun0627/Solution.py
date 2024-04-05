import re
from itertools import permutations

def solution(user_id, banned_id):
    
    banned_id = [b.replace("*", ".") for b in banned_id]
    perms = []

    for p in permutations(user_id, len(banned_id)):
        l = list(p)
        flag = True
        for ii in range(len(banned_id)):
            if re.match(banned_id[ii], l[ii]) and len(banned_id[ii]) == len(l[ii]):
                continue
            else:
                flag = False
                break
        if flag and sorted(l) not in perms:
            perms.append(sorted(l))

    answer = len(perms)
    return answer
