def solution(numbers):

    answer = [-1 for _ in numbers]
    stack = []

    for ii in range(len(numbers)):
        while stack and numbers[stack[-1]] < numbers[ii]:
            answer[stack.pop()] = numbers[ii]
        stack.append(ii)

    return answer