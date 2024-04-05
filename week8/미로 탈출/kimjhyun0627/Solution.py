from collections import deque

def solution(maps):
    
    def bfs(start, end) -> int:

        visited = [[0 for _ in range(width)] for _ in range(height)]
        visited[start[0]][start[1]] = 1

        queue = deque()
        queue.append(start)
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or ny < 0 or nx >= height or ny >= width:
                    continue
                if maps[nx][ny] == 'X' or visited[nx][ny] != 0: 
                    continue

                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))

        return visited[end[0]][end[1]] - 1

    height = len(maps)
    width = len(maps[0])    
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    for ii in range(height):
        for jj in range(width):
            if maps[ii][jj] == 'S': start = (ii, jj)
            elif maps[ii][jj] == 'L': lever = (ii, jj)
            elif maps[ii][jj] == 'E': end = (ii, jj)

    time1 = bfs(start, lever)
    if time1 == -1:
        return -1
    time2 = bfs(lever, end)
    if time2 == -1:
        return -1
    
    return time1 + time2
