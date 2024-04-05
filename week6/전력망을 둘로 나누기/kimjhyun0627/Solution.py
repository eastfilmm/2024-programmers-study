def solution(n, wires):

    tree = {ii + 1 : {} for ii in range(n)}
    t = {ii + 1 : False for ii in range(n)}

    for w in wires:
        tree[w[0]][w[1]] = 0
        tree[w[1]][w[0]] = 0

    def dfs(start):

        t[start] = True
        k = 0
        for next in tree[start]:
            if not t[next]:
                x = dfs(next) + 1
                k += x
                tree[start][next] = x
        return k
    
    dfs(1)

    ans = 101
    for node in tree:
        for key in tree[node]:
            ans = min(abs((n - tree[node][key]) - tree[node][key]), ans)
    return ans
