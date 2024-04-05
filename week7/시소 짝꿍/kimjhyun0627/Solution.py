from collections import Counter

def solution(weights):

    answer = 0
    counter = Counter(weights)

    for ii in range(1001):
        answer += counter[ii] * (counter[ii] - 1) // 2
        answer += counter[ii] * counter[ii * 2]
        answer += counter[ii] * counter[ii * 3 / 2]
        answer += counter[ii] * counter[ii * 4 / 3]

    return answer