def solution(k, d):

    answer = 0

    for ii in range(0, d+1, k):
        x = d**2 - ii**2
        cnt = x**0.5 // k + 1
        answer += cnt
        
    return int(answer)
