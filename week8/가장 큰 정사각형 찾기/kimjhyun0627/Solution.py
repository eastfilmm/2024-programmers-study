def solution(board):

    col = len(board)
    row = len(board[0])
    
    for ii in range(1, col):
        for jj in range(1, row):
            if board[ii][jj] == 1:
                board[ii][jj] = min(board[ii-1][jj-1], board[ii-1][jj], board[ii][jj-1]) + 1
    
    answer = 0
    for i in range(col):
        temp = max(board[i])
        answer = max(answer, temp)
    
    return answer ** 2