def solution(prices):
    stack = []
    answer = [-1 for _ in prices]

    for ii in range(len(prices)):
        while stack and prices[stack[-1]] > prices[ii]:
            top = stack.pop()
            answer[top] = ii - top
        stack.append(ii)
     
    for ii in range(len(answer)):
        if answer[ii] == -1:
            answer[ii] += len(answer) - ii


    return answer