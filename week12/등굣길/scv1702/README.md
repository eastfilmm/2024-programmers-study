# 문제 풀이

## 문제 해설

오른쪽과 아래쪽으로만 이동할 수 있기 때문에, 좌표 $(j ,i)$에 오는 방법은 $(j-1, i)$에서 오거나 $(j, i-1)$에서 오는 방법 밖에 없다. 그러므로 $(j, i)$까지 가는 경우의 수는 $(j-1, i)$까지 가는 경우의 수와 $(j, i-1)$까지 가는 경우의 수의 합과 같다.

### 1. Subproblem

$dp(j, i)$: $(1, 1)$부터 $(j, i)$까지 올 수 있는 최단 경로 개수

### 2. Relation

$(j, i)$가 물이 잠기지 않았으면 $dp(j, i) = dp(j-1, i) + dp(j, i-1)$

$(j, i)$가 물에 잠겼으면 $dp(j, i) = 0$

### 3. Topology

```python
for j in range(m):
    for i in range(n):
```

### 4. Base

$dp(1, 1) = 1$

### 5. Original Problem

$dp(m, n)$

### 6. Time Complexity

$O(m \times n)$