import re

def solution(str1, str2):
    str1 = re.sub(r"[^a-z^A-Z]", "-", str1).upper()
    str2 = re.sub(r"[^a-z^A-Z]", "-", str2).upper()
    lst1 = [i for i in [str1[i:i+2] for i in range(len(str1)-1)] if '-' not in i]
    lst2 = [i for i in [str2[i:i+2] for i in range(len(str2)-1)] if '-' not in i]

    intersection = []
    tmp = lst1.copy()
    for i in lst2:
        if i in tmp:
            tmp.remove(i)
            intersection.append(i)

    union = lst1.copy()
    tmp = lst1.copy()
    for i in lst2:
        union.append(i) if i not in tmp else tmp.remove(i)

    answer = int(len(intersection)/len(union)*65536)
    return answer