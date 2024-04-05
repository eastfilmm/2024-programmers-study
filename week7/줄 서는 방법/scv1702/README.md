# 문제 풀이

## 문제 해설

처음에 순열을 단순히 계산하면 될 줄 알았는데, `k`가 매우 크기 때문에 불가능했다. 따라서 패턴을 분석해야 한다.

문제와 같이 `n = 3`, `k = 5`라고 가정하자. 다음과 같은 전체 순열이 있다.

```
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
```

이제 이 순열에서 `k` 번째 순열을 구해야 한다. 정답을 `result` 배열이라고 하자. 먼저 `result[0]`부터 구해보자. 순열은 사전 순이기 때문에 순열의 맨 앞자리가 1인 경우가 모두 나온 다음 맨 앞 자리가 2인 경우고 나오고, 2인 경우가 모두 나오면 3이 나오는 패턴이다. 그렇다면 각 경우마다 몇 개의 순열이 있을까? 바로 `factorial(n-1)`만큼 있다.

그렇다면 `k`가 주어졌을 때 `k / factorial(n-1)`을 통해 `result[0]`을 구할 수 있고, 그 다음은 같은 방법으로 재귀적으로 구하면 될 것 같다.

먼저 `nums` 리스트와 `factorial`을 선언한다. `nums` 리스트에는 `range(1, n+1)`이 들어가있다. `factorial`의 초기값은 `n!`이다.

```java
List<Integer> nums = new ArrayList<>();
long factorial = 1L;

for (int i = 1; i <= n; i++) {
    nums.add(i);
    factorial *= i;
}
```

`result` 배열은 정답 배열을 말하고, `idx`는 `result` 배열에 순서대로 기록하기 위한 인덱스다.

```java
int[] result = new int[n];
int idx = 0;

k--;
while (idx < n) {
    factorial /= n - idx;
    result[idx++] = nums.remove((int) (k / factorial));
    k %= factorial;
}
```

맨 아래의 로직이 가장 중요하다. 먼저 `factorial /= n- idx`를 통해 `factorial(n-1)`을 구하고, `nums` 리스트에서 `k / factorial`에 위치한 원소를 제거한 뒤 정답으로 기록한다. `k / factorial`을 하는 이유는 위에서 설명한 이유와 같다. 그 다음 `result`의 원소를 구하기 위해서 `k %= factorial`을 한다.

맨 처음에 `k--`를 하는 이유는 `nums` 리스트의 인덱스를 계산하기 때문이다.(리스트의 시작 인덱스는 0이다.)

왜 `nums` 리스트를 사용하는지 궁금할 수 있는데, `range(1, n+1)` 중에서 `result`에 기록된 원소는 제거하고 기록되지 않은 원수들 중에서 정답을 구하기 위함이다.


## 시간 복잡도

리스트의 삭제 연산은 $O(N)$이다. 그러므로 전체 시간 복잡도는 $O(N^2)$이다.