def solution(n):

    def hanoi_tower(start, target, temp, N):
        if N == 1:
            return [[start, target]]
        return hanoi_tower(start, temp, target, N-1) + [[start, target]] + hanoi_tower(temp, target, start, N-1)

    return hanoi_tower(1, 3, 2, n)
