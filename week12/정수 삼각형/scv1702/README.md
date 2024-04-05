# 문제 풀이

## 문제 해설

`triangle`의 길이를 $n$이라고 하겠다.

### 1. Subproblem

$dp(i, j)$: `triangle[i][j]`까지 거쳐간 숫자의 최대값

### 2. Relation

$dp(i, j) = max(dp(i-1, j-1), dp(i-1, j)) + triangle[i][j]$

### 3. Topology

`for i in range(1, n)`

### 4. Base

$dp(0, 0) = triangle[0][0]$

### 5. Original Problem

$max(dp(n-1, 0), ..., dp(n-1, n-1))$

### 6. Time Complexity

$O(n^2)$