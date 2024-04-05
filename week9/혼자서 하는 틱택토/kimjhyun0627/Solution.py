def solution(board):

    answer = 1
    
    o = sum([b.count('O') for b in board])
    x = sum([b.count('X') for b in board])
    if 0 <= o - x <= 1:
        vertical_board = [board[0][ii]+board[1][ii]+board[2][ii] for ii in range(3)]
        wo, wx = 0, 0
        for ii, jj in zip(board, vertical_board):
            if 'OOO' in [ii, jj]:
                wo += 1
            if 'XXX' in [ii, jj]:
                wx += 1
        
        diagonal_board = [board[0][0]+board[1][1]+board[2][2], board[0][2]+board[1][1]+board[2][0]]
        wo += diagonal_board.count('OOO')
        wx += diagonal_board.count('XXX')
        
        if wo and wx:
            answer = 0
        if wo and wx == 0 and o == x:
            answer = 0
        if wx and wo == 0 and o != x:
            answer = 0
    else:
        answer = 0
        
    return answer
