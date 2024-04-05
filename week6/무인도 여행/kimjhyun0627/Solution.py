def solution(maps):

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    visited = [[False] * len(maps[0]) for _ in range(len(maps))]

    answer = []
    for ii in range(len(maps)):
        for jj in range(len(maps[0])):
            if maps[ii][jj] != 'X' and not visited[ii][jj]:
                days = 0
                queue = [(jj, ii)]

                while queue:
                    x, y = queue.pop()
                    if visited[y][x]:
                        continue
                    visited[y][x] = True
                    days += int(maps[y][x])
                    
                    for kk in range(4):
                        nx, ny = x + dx[kk], y + dy[kk]
                        if -1 < nx < len(maps[0]) and -1 < ny < len(maps) and maps[ny][nx] != 'X' and not visited[ny][nx]:
                            queue.append((nx, ny))
                
                answer.append(days)

    return sorted(answer) if answer else [-1]
