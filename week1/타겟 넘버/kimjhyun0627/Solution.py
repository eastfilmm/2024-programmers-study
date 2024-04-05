def solution(numbers, target):
    answer = binary(numbers, 0, target)
    return answer

def binary(numbers, sum, target):
    if not numbers:
        return 1 if sum == target else 0
    return binary(numbers[1:], sum+numbers[0], target) + binary(numbers[1:], sum-numbers[0], target)