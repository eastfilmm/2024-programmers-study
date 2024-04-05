import re
from itertools import permutations

def solution(expression):

    answer = 0
    perm = permutations(['+', '-', '*'])

    for pe in perm:

        operands = [int(s) for s in re.split('[+*-]', expression)]
        operators = [c for c in expression if c in '+*-']
        for p in pe:
            while p in operators:

                idx = operators.index(p)

                if p == '*':
                    v = operands[idx] * operands[idx+1]
                elif p == '+':
                    v = operands[idx] + operands[idx+1]
                else:
                    v = operands[idx] - operands[idx+1]

                operands[idx] = v
                operands.pop(idx+1)
                operators.pop(idx)

        if abs(operands[0]) > answer:
            answer = abs(operands[0])

    return answer