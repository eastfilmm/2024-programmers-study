def solution(grid):

    width = len(grid[0])
    height = len(grid)
    visited = [[[0] * 4 for _ in range(width)] for __ in range(height)]

    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]
    
    answer = []
    
    for ii in range(height):
        for jj in range(width):
            for kk in range(4):
                if visited[ii][jj][kk] == 0:
                    
                    queue = [(ii, jj, kk)]
                    while queue:
                        
                        i, j, k = queue.pop()
                        ni = (height + i + dr[k]) % height
                        nj = (width + j + dc[k]) % width
                        nk = k
                        
                        if grid[ni][nj] == "L":
                            nk = (k + 3) % 4
                        if grid[ni][nj] == "R":
                            nk = (k + 1) % 4
                            
                        if visited[ni][nj][nk]:
                            answer.append(visited[i][j][k])
                        else:
                            visited[ni][nj][nk] = visited[i][j][k] + 1
                            queue.append((ni, nj, nk))
                            
    answer.sort()
    
    return answer
