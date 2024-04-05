# 문제 풀이

## 문제 해설

본 문제는 가장 맵지 않은 음식의 스코빌 지수와 두 번째로 맵지 않은 음식의 스코빌 지수를 가져온 뒤 음식을 섞은 후 이를 반복하는 과정을 한다. 즉, 가장 맵지 않은 음식의 스코빌 지수와 두 번째로 맵지 않은 음식의 스코빌 지수를 계속해서 계산하는 과정을 거친다는 것인데 이때 가장 효과적인 자료 구조는 최소 힙이다. 원소 개수를 $N$이라고 할 때 최소 힙은 가장 작은 원소를 매번 $O(\log{N})$ 만에 구할 수 있다. 또한 최소 힙은 원소를 추가하는 것도 $O(\log{N})$안에 가능하기 때문에, 데이터가 계속해서 변화는 상황에서 최소 값을 구하고 싶은 경우 가장 적절한 자료 구조이다. 만약 데이터가 변하지 않는다면 정렬을 수행하는 것도 가능하다.

## 시간 복잡도

매번 원소 두 개를 제거한 뒤 하나로 합친 후 다시 추가를 하기 때문에 매 반복마다 데이터 크기가 1씩 감소한다. 그러므로 전체 시간 복잡도는 $O(\log{N}) + O(\log{N-1}) + O(\log{N-2}) + ... +O(\log{2})$라고 할 수 있다. 이는 다음과 같이 정리할 수 있다.

$$
\log{1} + \log{2} + ... \log{N} \leq \log{N} + \log{N} + ... + \log{N}
$$
$$
\log{1} + \log{2} + ... \log{N} \leq N \log{N}
$$

그러므로 전체 시간 복잡도는 $O(N\log{N})$이다.

```java
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for (int s: scoville) {
            pq.add(s);
        }
        
        while (pq.size() >= 2 && pq.peek() < K) {
            int lowest = pq.poll();
            int second = pq.poll();
            pq.add(lowest + second * 2);
            answer += 1;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}
```