def solution(n):
    
    if n == 1:
        return 1
    elif n == 2:
        return 2
    
    mem = [0 for _ in range(n+1)]
    mem[1] = 1
    mem[2] = 2
    
    for ii in range(3, n+1):
        mem[ii] = (mem[ii-1] + mem[ii-2]) % 10000000007

    return mem[-1]