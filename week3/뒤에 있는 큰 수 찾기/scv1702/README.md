# 문제 풀이

## 문제 해설

다시 한 번 풀어볼 것!

본 문제는 정수 배열 `numbers`가 주어지고, 어떤 인덱스 `i`에 대해 `numbers[i+1:]` 중 `numbers[i]`보다 크면서 `numbers[i]`와 가장 가까운 수, 즉 뒷 큰수를 찾는 문제다. 처음에는 문제를 읽고 난 후 2중 `for` 문을 이용한 완전 탐색을 생각해봤지만 데이터의 크기가 $10^6$이므로 완전 탐색은 불가능하다.

`numbers[i]`의 뒷 큰수를 찾는다고 생각하지 말고, `numbers[i]`가 `numbers[0:i]` 중 어떤 수들에게 뒷 큰수가 되는지 찾는다고 생각해보자. 그러기 위해선 `numbers[0:i]` 중에서 뒷 큰수를 찾지 못한 수들을 기억해놔야지 시간 복잡도를 줄일 수 있을 것이다. 그런데 뒷 큰수를 찾지 못한 수들을 모아보면, 이들은 점차 감소하는 형태이다. 만약 `numbers[j]`가 `numberse[j+1]`보다 크다면 `numbers[j]`의 뒷 큰수는 `numbers[j+1]`이 되기 때문이다. 이때 `numbers[i]`가 주어지게 된다면, 이들 중 `numbers[i]`보다 작은 수들을 찾으면 된다.

지금까지 해야할 행위를 정리해보자. 뒷 큰수를 찾지 못한 수들을 기억해놔야하고, `numbers[i]`가 주어지면 이들 중 `numbers[i]`보다 작은 수들을 찾아야 한다. 그런데 이들은 점차 감소하는 형태이기 때문에 데이터의 입출력이 한 쪽 방향에서만 발생하게 된다. 이러한 경우에는 스택이 가장 적합하다.

스택에는 인덱스를 저장하자. 스택에 가장 먼저 들어온 인덱스의 원소가 가장 값이 크고 점점 감소하는 형태이다. 이때 `numbers[i]`가 `numbers[stack.peek()]` 보다 큰 경우, `numbers[i]`가 뒷 큰수가 되지 않을 때까지 스택에서 인덱스를 빼면 된다.

마지막에 스택에 남아 있는 인덱스들은 뒷 큰수를 찾지 못한 원소들의 인덱스이기 때문에 -1을 넣어준다.

## 시간 복잡도

`numbers[i]`는 스택에 최대 한 번 `push()` 되거나 `pop()` 되기 때문에, 전체 시간 복잡도는 $O(N)$이다. `numbers[i]`가 `pop()` 됐다가 다시 `push()` 되는 경우는 발생하지 않는다.

```java
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
    
        stack.push(0);
        
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}
```