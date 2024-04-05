def solution(n, stations, w):
    
    answer = 0
    radius = w * 2 + 1
    end = 1
    left = 0
    
    for s in stations:
        left = s - w - end
        if s - w > end:
            answer += left // radius if left % radius == 0 else left // radius + 1
        end = s + w + 1
        
    if end <= n:
        left = n + 1 - end
        answer += left // radius if left % radius == 0 else left // radius + 1
        
    return answer

print(solution(11, [4,11], 1))
print(solution(16, [9], 2))