def solution(numbers, target):
    tree = [0]
    for i in range(len(numbers)):
        length = len(tree)
        for p in range(2 ** i - 1, length):
            tree.append(tree[p] - numbers[i])
            tree.append(tree[p] + numbers[i])

    ans = 0
    for i in range(2 ** (len(numbers)) - 1, len(tree)):
        if tree[i] == target:
            ans += 1

    return ans