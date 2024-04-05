def solution(triangle):

    dp = [[0 for _ in t] for t in triangle]
    dp[0][0] = triangle[0][0]

    for ii in range(1, len(triangle)):
        for jj in range(ii+1):
            if jj == 0:
                dp[ii][jj] = dp[ii-1][jj] + triangle[ii][jj]
            elif jj == ii:
                dp[ii][jj] = dp[ii-1][jj-1] + triangle[ii][jj]
            else:
                dp[ii][jj] = max(dp[ii-1][jj-1], dp[ii-1][jj]) + triangle[ii][jj]

    answer = max(dp[-1])
    return answer
