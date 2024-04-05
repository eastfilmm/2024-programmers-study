def solution(h1, m1, s1, h2, m2, s2):
    
    answer = 0
    
    start = h1 * 3600 + m1 * 60 + s1
    end = h2 * 3600 + m2 * 60 + s2
    if start == 0 or start == 12 * 3600:
        answer += 1
        
    while start < end:
        
        h = start / 120 % 360
        m = start / 10 % 360
        s = start * 6 % 360
        
        nh = 360 if (start + 1) / 120 % 360 == 0 else (start + 1) / 120 % 360
        nm = 360 if (start + 1) / 10 % 360 == 0 else (start + 1) / 10 % 360
        ns = 360 if (start + 1) * 6 % 360 == 0 else (start + 1) * 6 % 360
        
        if s < h and ns >= nh:
            answer += 1
        if s < m and ns >= nm:
            answer += 1
        if ns == nh and nh == nm:
            answer -= 1
        
        start += 1
    
    return answer
