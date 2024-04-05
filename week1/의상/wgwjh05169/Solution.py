def solution(clothes):
    closet = {}
    for v, k in clothes:
        if closet.get(k, 0):
            closet[k] += 1
        else:
            closet[k] = 2

    ans = 1
    for v in closet.values():
        ans *= v

    return ans - 1