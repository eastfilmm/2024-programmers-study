# 문제 풀이

## 문제 해설

본 문제는 DP 문제다. 

### 1. Subproblem

자연수가 $x$를 $i$로 변환하는데 필요한 최소 연산 횟수 $dp(i)$

### 2. Relation

$dp(i) = min(dp(i-n), dp(i / 2), dp(i / 3)) + 1$

다만, $i-n$, $i/2$, $i/3$ 모두 $x$에서부터 연산들을 적용해 만들 수 있는 수 이어야 한다.

### 3. Topology

$i$를 $x+1$부터 $y$까지 반복한다.

### 4. Base

$dp(x) = 0$이다.

### 5. Original problem

자연수가 $x$를 $y$로 변환하는데 필요한 최소 연산 횟수 $dp(y)$

### 6. Time complexity

$i$를 $x+1$부터 $y$까지 반복하면서 $dp(i) = min(dp(i-n), dp(i / 2), dp(i / 3)) + 1$를 계산하니 $O(y-x)$이다.