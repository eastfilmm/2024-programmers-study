import heapq

def solution(operations):
    
    opr = [(o.split()[0], int(o.split()[1])) for o in operations]
    min_heap = []
    max_heap = []
    
    for o in opr:
        if o[0] == 'I':
            heapq.heappush(min_heap, o[1])
            heapq.heappush(max_heap, -o[1])
        if o[0] == 'D':
            if len(max_heap) > 0 and o[1] == 1:
                min_heap.remove(-heapq.heappop(max_heap))
            if len(min_heap) > 0 and o[1] == -1:
                max_heap.remove(-heapq.heappop(min_heap))
    
    if len(min_heap) == 0:
        return [0, 0]
            
    answer = [-heapq.heappop(max_heap), heapq.heappop(min_heap)]
    return answer
