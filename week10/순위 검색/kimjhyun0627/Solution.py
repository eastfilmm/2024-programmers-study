# 효율성 0점
def solution(info, query):
    
    info_list = []
    for i in info:
        info_list.append(i.split())
        
    query_list = []
    for q in query:
        query_list.append([i for i in q.split() if i != 'and'])
    
    answer = []
    
    for q in query_list:

        tmp = info_list.copy()
        for ii in range(len(q)-1):
            if q[ii] == '-':
                continue
            tmp = [t for t in tmp if t[ii] == q[ii]]
        
        tmp = [t for t in tmp.copy() if int(t[-1]) >= int(q[-1])]
        
        answer.append(len(tmp))
        
    return answer

#효율성 코드
from collections import defaultdict
from itertools import product
from bisect import bisect_left

def solution(info, query):
    
    info = [tuple(i.split(" ")) for i in info]
    queries = [tuple(r for r in q.split(" ") if r != 'and') for q in query]

    scores = defaultdict(list)
    for i in info:
        for record in product(*tuple(('-', e) for e in i[:-1])):
            scores[record].append(int(i[-1]))
    for record in scores:
        scores[record].sort()

    output = []
    for query in queries:
        record, score = query[:-1], int(query[-1])
        output.append(len(scores[record]) - bisect_left(scores[record], score))
    return output