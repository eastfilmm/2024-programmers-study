ans = 0


def solution(k, dungeons):
    global ans

    visited = [False for _ in range(len(dungeons))]
    for i in range(len(dungeons)):
        dfs(visited.copy(), i, dungeons, k - dungeons[i][1], 1)

    return ans


def dfs(visited, v, dungeons, k, depth):
    global ans

    if depth > ans:
        ans = depth

    visited[v] = True
    for i in range(len(dungeons)):
        if not visited[i] and k >= dungeons[i][0]:
            dfs(visited.copy(), i, dungeons, k - dungeons[i][1], depth + 1)