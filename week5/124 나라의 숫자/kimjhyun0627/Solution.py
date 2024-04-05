def solution(n):
    
    answer = []
    while n > 0:
        mod = n % 3
        if mod == 0:
            mod = 4
            n -= 1
        answer.append(str(mod))
        n //= 3

    return ''.join(answer[::-1])
