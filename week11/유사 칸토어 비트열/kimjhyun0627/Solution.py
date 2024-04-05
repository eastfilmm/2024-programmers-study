def solution(n, l, r):
    
    answer = 0
    
    for ii in range(l-1, r):
        if check(ii):
            answer += 1
        
    return answer

def check(i):
    if i % 5 == 2:
        return False
    elif i < 5:
        return True
    return check(i//5)
