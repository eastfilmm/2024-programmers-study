def solution(n, computers):
    
    visited = [False for _ in range(n)]
    answer = 0
    network = []
    
    for ii in range(n):
        if not visited[ii]:
            visited[ii] = True
            network.append(ii)
            while network:
                node = network.pop()
                for jj in range(n):
                    if computers[node][jj] == 1 and not visited[jj]:
                        visited[jj] = True
                        network.append(jj)
            answer += 1

    return answer
