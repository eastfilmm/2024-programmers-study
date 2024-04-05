import heapq

def solution(n, works):
    
    if sum(works) < n:
        return 0
    
    works = [w * -1 for w in works]
    heapq.heapify(works)
    
    for _ in range(n):
        cur = heapq.heappop(works)
        post = cur + 1
        heapq.heappush(works, post)
    
    answer = sum([w ** 2 for w in works])
    return answer
