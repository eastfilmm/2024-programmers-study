# 문제 풀이

## 문제 해설

본 문제는 피로도와 던전에 관한 정보가 주어질때, 주어진 피로도로 돌 수 있는 최대 던전 개수를 구하는 문제다. 이때 던전 개수가 1 이상 8 이하 이므로, `len(dungeons)`이 상당히 작은 것을 알 수 있다. 그러므로 던전을 도는 경우의 수를 모두 확인이 가능하기 때문에 쉽게 정답을 구할 수 있다. 던전을 도는 경우의 수는 최대 8!이므로, 약 1초 내에 계산이 가능하다. 참고로, 주어진 데이터의 크기가 11이 넘어가면 10^6을 넘어가므로 이와 같은 방법은 사용할 수 없다.

## 시간 복잡도

순열은 주어진 데이터의 크기가 `n`인 경우 `O(n!)`이기 때문에, 아래의 코드도 순열을 이용하기 때문에 마찬가지로 `O(n!)`이다.

```java
import java.util.*;

class Solution {
    boolean[] visited;
    int[] result;
    int answer = -1;
    
    public void permutation(int n, int depth, int[][] dungeons, int k) {
        int f = k;
        int d = 0;
        if (depth == n) {
            for (int i: result) {
                if (f < dungeons[i][0] || f <= 0) {
                    break;
                }
                f -= dungeons[i][1];
                d += 1;
            }
            answer = Math.max(answer, d);
            return ;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permutation(n, depth + 1, dungeons, k);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];
        result = new int[n];
        permutation(n, 0, dungeons, k);
        return answer;
    }
}
```