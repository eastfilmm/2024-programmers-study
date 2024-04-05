# 문제 풀이

## 문제 해설

그룹의 점수는 시작 상자 번호에 따라 달라진다. 그러므로 첫 번째 그룹의 시작 상자 번호와 두 번째 그룹의 시작 상자 번호의 모든 경우의 수를 탐색한 뒤 가장 높은 점수를 반환한다. 이때 첫 번째 그룹의 점수를 구한 뒤 두 번째 그룹의 점수를 구할 때 열린 상자의 상태를 유지해야한다. 상자의 상태를 저장하는 배열을 `visited`라고 할 때, 두 번째 그룹의 점수를 구할 때 이를 복사해주었다.

## 시간 복잡도

`cards`의 길이를 $n$이라고 하자. 한 번 게임을 수행하는 함수를 `play()`라고 할 때 이 함수의 시간 복잡도는 $O(n)$이다. 그러므로 전체 시간 복잡도는 아래의 `for` 문에 따라 $O(n^3)$이다.

```java
for (int start = 0; start < n; start++) {
    boolean[] visited = new boolean[n]; 
    int one = play(cards, visited, start);
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            int two = play(cards, Arrays.copyOf(visited, n), i);
            answer = Math.max(answer, one * two);
        }
    }
}
```