from itertools import permutations

def solution(numbers):

    answer = 0
    numbers = [n for n in numbers]
    permutation_nums = []
    for ii in range(1, len(numbers) + 1):
        permutation_nums += list(permutations(numbers, ii))

    all_nums = []
    for p in permutation_nums:
        all_nums.append(int(''.join(p)))
    all_nums = list(set(all_nums))

    for a in all_nums:
        if is_prime(a):
            answer += 1
    return answer

def is_prime(number:int):
    
    if number <= 1:
        return False
    for ii in range(2, int(number**0.5) + 1):
        if number % ii == 0:
            return False
    return True