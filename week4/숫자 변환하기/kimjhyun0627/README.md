  # 문제 풀이

## 문제 해설


***DP***

1. dp를 생성해 dp[x] = 0으로 바꾼다.
2. 반복문을 돌며 세 가지 계산에 대해 최소값을 계산해 dp에 입력한다.
3. dp[y] 값을 구한다.


아래는 시간복잡도 초과로 실패한 단순 재귀코드
```python
import math

def cal(x,y,n):
    if x == y:
        return 0
    if x > y:
        return math.inf

    best = min([cal(x+n, y, n), cal(x*2, y, n), cal(x*3, y, n)])
    return best + 1

def solution(x, y, n):
    
    answer = cal(x,y,n)

    return answer if answer != math.inf else -1
``` 

## 시간 복잡도
$$O(y)$$

