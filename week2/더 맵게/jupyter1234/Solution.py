import heapq
def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    min_s = heapq.heappop(scoville)
    while (min_s < K):
        answer += 1
        if not scoville:
            return -1
        second_s = heapq.heappop(scoville)
        new_s = min_s + second_s * 2
        heapq.heappush(scoville,new_s)
        min_s = heapq.heappop(scoville)
    return answer