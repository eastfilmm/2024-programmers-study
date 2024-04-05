def solution(n):
    
    if n % 2:
        return 0
    elif n == 2:
        return 3
    
    mem = [0 for _ in range(n+1)]
    mem[2] = 3
    mem[4] = 11
    
    for ii in range(6, n+1, 2):
        mem[ii] = (3 * mem[ii-2] + 2 * sum(mem[1:ii-3]) + 2) % 1000000007

    print(mem)
    return mem[-1]
