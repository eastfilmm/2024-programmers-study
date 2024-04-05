def solution(order):

    stack = []
    cur = 0
    answer = 0
    for ii in range(1, len(order)+1):
        stack.append(ii)
        while stack and stack[-1] == order[cur]:
            stack.pop()
            cur += 1
            answer += 1
    
    return answer
