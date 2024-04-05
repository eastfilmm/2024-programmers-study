def solution(arr1, arr2):
    answer = []
    m = len(arr1)
    n = len(arr2[0])
    k = len(arr1[0])
    for i in range(m):
        ans = []
        for p in range(n):
            res = 0
            for j in range(k):
                res += arr1[i][j] * arr2[j][p]
            ans.append(res)
        answer.append(ans)        
    return answer