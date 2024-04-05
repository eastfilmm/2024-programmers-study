def solution(m: int, n: int, puddles: list) -> int:
    
    dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
    
    for ii in range(1, n+1):
        for jj in range(1, m+1):
            if ii == 1 and jj == 1:
                dp[ii][jj] = 1
                continue
            if [jj, ii] not in puddles:
                dp[ii][jj] = dp[ii-1][jj] + dp[ii][jj-1]

    answer = dp[n][m] % 1000000007
    return answer
