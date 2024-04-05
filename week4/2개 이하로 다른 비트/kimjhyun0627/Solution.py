def solution(numbers):
    
    answer = []
    for n in numbers:
        origin = n
        cnt = 0
        while n % 2 == 1:
            n //= 2
            cnt += 1
        answer.append(origin+2**(cnt-1) if cnt else origin+1)

    return answer
