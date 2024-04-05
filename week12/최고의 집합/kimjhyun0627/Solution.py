def solution(n, s):
    
    if n > s:
        return [-1]
    
    q, r = divmod(s, n)
    answer = [q] * (n - r) + [q + 1] * r
    return answer
