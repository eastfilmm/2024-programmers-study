from collections import deque

def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)

    sum1 = sum(queue1)
    sum2 = sum(queue2)
    if (sum1 + sum2) % 2 == 1:
        return -1
    answer = 0
    while sum1 != sum2:
        if answer >= len(queue1) + len(queue2):
            return -1
        while queue2 and sum1 < sum2:
            tmp = queue2.popleft()
            queue1.append(tmp)
            answer += 1
            sum2 -= tmp
            sum1 += tmp

        while queue1 and sum1 > sum2:
            tmp = queue1.popleft()
            queue2.append(tmp)
            answer += 1
            sum1 -= tmp
            sum2 += tmp
    return answer
