import heapq

def solution(N, road, K):

    dist_map = [10**9 for _ in range(N+1)]
    dist_map[1] = 0
    graph = [[] for _ in range(N+1)]

    for start, end, dist in road:
        graph[start].append([end, dist])
        graph[end].append([start, dist])
    
    heap = []
    heapq.heappush(heap, (1, 0))
    while heap:
        cur, dist = heapq.heappop(heap)
        if dist_map[cur] >= dist:
            for next, c in graph[cur]:
                total = dist + c
                if total < dist_map[next]:
                    dist_map[next] = total
                    heapq.heappush(heap, (next, total))
    
    answer = 0
    for d in dist_map[1:]:
        if d <= K:
            answer += 1
    return answer
