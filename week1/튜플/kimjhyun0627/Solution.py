import re

def solution(s):
    splitted_list = re.split("[{,}]", s)
    tmp = []
    lst = []
    for i in splitted_list:
        if i:
            tmp.append(int(i))
        else:
            lst.append(tmp)
            tmp = []
    lst = [i for i in lst if i]
    sorted_lst = sorted(lst, key=lambda x:len(x))

    answer = []
    for index in sorted_lst:
        for i in index:
            if i not in answer:
                answer.append(i)
                 
    return answer