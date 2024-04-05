# 문제 풀이

## 문제 해설
본 문제는 종류 별로 의상들이 주어지고, 종류 별로 최대 1개씩 전체로 봤을 때 최소 1개의 의상을 선택하는 경우의 수를 구하는 문제다. 이때 조심할 점은 종류 별로 최대 1개씩 이므로 선택하지 않은 종류가 있을 수 있다는 것이다. 그러므로 각 종류마다 의상 개수를 구하고, 선택을 하지 않는다는 `NULL` 원소를 1씩 더한 후 모두 곱한 뒤 아무 의상도 선택하지 않는 경우의 수인 1을 빼면 정답이 된다.

## 시간 복잡도

각 종류마다 의상의 개수를 구하는 코드는 `O(len(clothes))`, 정답을 구하는 코드는 `O(의상 종류 개수)`이다. 이때 전체 의상 개수인 `len(clothes)`는 항상 의상 종류 개수보다 크거나 같으므로, 전체 시간 복잡도는 `O(len(clothes))`이다.

```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe: clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1);
        }
        int answer = 1;
        for (String category: map.keySet()) {
            answer *= map.get(category);
        }
        answer -= 1;
        return answer;
    }
}
```