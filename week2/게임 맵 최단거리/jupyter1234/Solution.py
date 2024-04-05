from collections import deque
def solution(maps):
    # n : x(열) m: y(행)
    m = len(maps)
    n = len(maps[0])
    visited = [[False for _ in range(n)] for _ in range(m)]
    #상 하 좌 우
    move_col = [0,0,1,-1]
    move_row = [1,-1,0,0]
    
    q = deque()
    #(행,열)
    q.append((0,0))
    while (q):
        row,col = q.popleft()
        for i in range(4):
            d_row = row + move_row[i]
            d_col = col + move_col[i]
            
            if 0 <= d_row < m and 0<= d_col < n and visited[d_row][d_col] == False and maps[d_row][d_col] == 1:
                q.append((d_row,d_col))
                visited[d_row][d_col] == True
                maps[d_row][d_col] = maps[row][col] + 1
    answer = maps[m-1][n-1]
    if (maps[m-1][n-1] == 1):
        answer = -1
    return answer