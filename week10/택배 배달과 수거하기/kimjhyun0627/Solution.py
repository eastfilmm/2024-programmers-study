def solution(cap:int, n:int, deliveries:list, pickups:list):
    
    deliveries = deliveries[::-1]
    pickups = pickups[::-1]
    answer = 0
    
    d, p = 0, 0
    for ii in range(n):
        d += deliveries[ii]
        p += pickups[ii]
        
        while d > 0 or p > 0:
            d -= cap
            p -= cap
            answer += (n - ii) * 2
            
    return answer
