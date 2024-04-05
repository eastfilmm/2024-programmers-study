def solution(x, y, n):
    
    dp = [float('inf')] * (y+1)
    dp[x] = 0

    for ii in range(x, y+1):
        if dp[ii] == float('inf'):
            continue
        if ii + n <= y:
            dp[ii+n] = min(dp[ii+n], dp[ii]+1)
        if ii * 2 <= y:
            dp[ii*2] = min(dp[ii*2], dp[ii]+1)
        if ii * 3 <= y:
            dp[ii*3] = min(dp[ii*3], dp[ii]+1)

    return -1 if dp[y] == float('inf') else dp[y]
