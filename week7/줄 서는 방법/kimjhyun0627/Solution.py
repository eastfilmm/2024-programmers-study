from itertools import permutations

def solution(n, k):

    answer = []

    nums = [ii for ii in range(1, n+1)]
    while n != 0:
        num = factorial(n-1)
        idx = int(k // num)
        k %= num
        if k == 0:
            answer.append(nums.pop(idx-1))
        else:
            answer.append(nums.pop(idx))
        n -= 1

    return answer

def factorial(n):
    if n < 1:
        return 1
    else:
        return n * factorial(n-1)
