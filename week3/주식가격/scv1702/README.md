# 문제 풀이

## 문제 해설

본 문제는 뒤에 있는 큰 수 찾기와 아주 유사한 문제다. `prices[i]`가 주어졌을 때 `prices[i]`로 인해 하락한 주식들을 구해야하기 때문에 스택을 이용했다. 스택에 각 주식의 인덱스와 값, 스택에 들어갈 때 시간을 기록해두고 스택에서 주식이 빠질 때 현재 시간과 스택에 들어간 시간의 차이를 정답으로 기록했다.

## 시간 복잡도

모든 주식은 스택에 딱 한 번 들어가고, 딱 한 번 빠진다. 그러므로 `push()`에 $O(N)$, `pop()`에 $O(N)$이 소요되기 때문에 전체 시간 복잡도는 $O(N+N)=O(N)$이다.

```java
import java.util.*;

class Solution {
    class Element {
        int index;
        int value;
        int time;
        
        Element(int index, int value, int time) {
            this.index = index;
            this.value = value;
            this.time = time;
        }
        
        @Override
        public String toString() {
            return String.format("index={%d}, value={%d}, time={%d}", index, value, time);
        }
    }
    
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Element> stack = new Stack<>();
        int time = 1;
        
        for (int i = 0; i < n; i++) {
            time += 1;
            while (!stack.isEmpty() && stack.peek().value > prices[i]) {
                Element e = stack.pop();
                answer[e.index] = time - e.time;
            }
            stack.push(new Element(i, prices[i], time));
        }
        
        while (!stack.isEmpty()) {
            Element e = stack.pop();
            answer[e.index] = time - e.time;
        }
        
        return answer;
    }
}
```