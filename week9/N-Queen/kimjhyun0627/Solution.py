def solution(n):

    def is_safe(b, row, ii):
        if ii in b[:row]:
            return False
        for jj in range(1, row+1):
            if ii - jj >= 0 and row - jj >= 0:
                if b[row-jj] == ii - jj:
                    return False
            if ii + jj < len(b) and row - jj >= 0:
                if b[row-jj] == ii + jj:
                    return False
        return True
    
    def queen(b, row):
        if row == len(b):
            return 1
        ans = 0
        for ii in range(len(b)):
            if is_safe(b, row, ii):
                b[row] = ii
                ans += queen(b, row+1)
                b[row] = -1
        return ans

    board = [-1 for _ in range(n)]
    answer = queen(board, 0)

    return answer
