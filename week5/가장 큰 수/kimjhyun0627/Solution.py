def solution(numbers):
    
    numbers = [str(n) for n in numbers]
    numbers = sorted(numbers, reverse=True, key=lambda x: x*3)

    return str(int(''.join(numbers)))
