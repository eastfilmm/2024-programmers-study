# 문제 풀이

## 문제 해설

본 문제는 최적화 문제로 땅따먹기의 최대 점수를 구하는 문제다. 완전 탐색으로도 풀 수 있겠지만, 행의 크기가 최대 $10^5$이기 때문에 완전 탐색으로는 불가능하다. 그래서 동적 프로그래밍으로 문제를 해결하고자 하였다.

필자는 **SRTBOT**이라는 기법을 이용해 동적 프로그래밍을 해결한다. SRTBOT은 문제를 Subproblem, Relation, Topology, Base, Original problem, Time complexity를 구하는 것으로 분해하는 기법이다. 자세한 설명은 [MIT의 알고리즘 강의](https://www.youtube.com/watch?v=r4-cftqTcdI&list=PLUl4u3cNGP63EdVPNLG3ToM6LaEUuStEY&index=23)를 참고하도록 하자. 

### 1. Subproblem

땅따먹기를 행 `i`까지 진행했을때, 마지막 열이 `j`인 경우의 최대 점수를 `dp[i][j]`라고 한다.

### 2. Relation

`dp[i][j]`는 `j`와 같은 열을 제외하고, `dp[i-1][0]`부터 `dp[i-1][3]` 중 `land[i][j]`을 더했을 때 가장 최대가 되는 값이다. 이를 식으로 표현하면 다음과 같다.

`dp[i][j] = Math.max([dp[i-1][k] + land[i][j] if k != j for k in range(4)])`

### 3. Topology

첫 번째 행 `i`부터 마지막 행 `n` 순서로 계산을 진행하면 된다.

### 4. Base

`dp[0][j] = land[0][j]`이다.

### 5. Original problem

마지막에 어떤 열을 밟아야지 점수가 가장 최대가 되는지 탐색하면 된다.

`answer = Math.max([dp[N-1][j] for j in range(4)])`

시간 복잡도는 아래에서 설명하겠다.

## 시간 복잡도

시간 복잡도는 `for` 문만 보면 쉽게 계산할 수 있다. $O(n\times m^2)$인데, $m^2=16$이므로 $O(n)$이라고 할 수 있다. 가능한 최선의 수행 시간(BCR)을 생각해보면, 적어도 `land`의 모든 점수는 탐색을 해봐야하기 때문에 $O(n)$보다 더 최적화 할 수 없음을 알 수 있다.

```java
class Solution {  
    int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int[][] dp = new int[n+1][m];
        
        for (int i = 0; i < m; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        
        return answer;
    }
}
```