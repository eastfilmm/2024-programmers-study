# 문제 풀이

## 문제 해설

본 문제는 철수와 동생이 서로 공평하게 먹을 수 있도록 롤케이크를 자르는 모든 경우의 수를 구하는 문제다. 이때 '공평하다'는 토핑의 종류 개수가 동일한 것을 말한다.

`topping`의 길이를 $N$이라고 할 때 롤케이크를 자르는 모든 경우의 수는 $O(N)$이다. 그러므로 각 경우의 수에 대해서 해당 경우의 수가 공평한지 아닌지 $O(1)$에 판단할 수 있다면 문제는 모두 해결한 것이라고 볼 수 있다.

필자는 자르는 위치를 `i`라고 할 때 철수의 롤케이크를 `topping[:i]`라고 하고, 동생의 롤케이크를 `topping[i:]`라고 정했다. 그리고 `ob`는 철수 롤케이크의 각 토핑에 대한 개수를 저장하고, `yb`는 동생의 것을 저장한다. 이때 토핑의 개수가 0이 되면 해시맵에서 삭제함으로써 해시맵의 크기가 토핑의 종류 개수가 되도록 유지하였다.

그래서 `for i in range(n)`을 하면서 모든 롤케이크를 자르는 경우에 대해서 탐색을 진행함으로써 문제를 해결했다.

## 시간 복잡도

해시맵의 `put()`과 `get()`, `size()`는 모두 $O(1)$이기 때문에 전체 시간 복잡도는 $O(N)$이다.

```java
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> ob = new HashMap<>(); // 철수
        Map<Integer, Integer> yb = new HashMap<>(); // 동생
        int answer = 0;
        int n = topping.length;
        
        for (int i = 0; i < n; i++) {
            yb.put(topping[i], yb.getOrDefault(topping[i], 0) + 1);
        }
        
        // 철수: topping[:i]
        // 동생: topping[i:]
        for (int i = 0; i < n; i++) {
            ob.put(topping[i], ob.getOrDefault(topping[i], 0) + 1);
            if (yb.containsKey(topping[i]) && yb.get(topping[i]) > 0) {
                yb.put(topping[i], yb.get(topping[i]) - 1);
                if (yb.get(topping[i]) <= 0) {
                    yb.remove(topping[i]);
                }
            }
            if (ob.size() == yb.size()) {
                answer += 1;
            }
        }
        
        return answer;
    }
}
```