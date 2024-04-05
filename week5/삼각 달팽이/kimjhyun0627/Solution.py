def solution(n):
    
    answer = [[0 for _ in range(i)] for i in range(1, n+1)]
    x, y = -1, 0
    num = 1

    for ii in range(n):
        for jj in range(ii, n):
            if ii % 3 == 0:
                x += 1
            elif ii % 3 == 1:
                y += 1
            else:
                x -= 1
                y -= 1
            answer[x][y] = num
            num += 1
    
    return sum(answer, [])
