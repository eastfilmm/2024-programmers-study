def solution(m, n, board):

    board = [list(b) for b in board]
    tmp = set()
    answer = 0

    while True:
        for ii in range(m-1):
            for jj in range(n-1):
                t = board[ii][jj]
                if t == '-':
                    continue
                else:
                    if board[ii][jj+1] == t and board[ii+1][jj] == t and board[ii+1][jj+1] == t:
                        tmp.add((ii, jj))
                        tmp.add((ii, jj+1))
                        tmp.add((ii+1, jj))
                        tmp.add((ii+1, jj+1))

        if tmp:
            answer += len(tmp)
            for ii, jj in tmp:
                board[ii][jj] = '-'
            tmp = set()
        else:
            break

        while True:
            moved = 0
            for ii in range(m-1):
                for jj in range(n):
                    if board[ii][jj] != '-' and board[ii+1][jj] == '-':
                        board[ii][jj], board[ii+1][jj] = board[ii+1][jj], board[ii][jj]
                        moved = 1
            if moved == 0:
                break

    return answer
