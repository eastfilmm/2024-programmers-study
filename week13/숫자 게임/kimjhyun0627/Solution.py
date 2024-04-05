import heapq

def solution(A, B):

    A = [-a for a in A]
    B = [-b for b in B]
    heapq.heapify(A)
    heapq.heapify(B)
    answer = 0
    
    while A:
        max_A = heapq.heappop(A)
        max_B = heapq.heappop(B)
        if -max_A < -max_B:
            answer += 1
        else:
            heapq.heappush(B, max_B)
    
    return answer
