from heapq import heappush, heappop

def solution(n, k, enemy):

    answer = len(enemy)
    heapq = []

    for round, enem in enumerate(enemy):

        heappush(heapq, enem)
        if len(heapq) > k:
            n -= heappop(heapq)
        if n < 0:
            answer = round
            break
        
    return answer
