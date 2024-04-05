# 문제 풀이

## 문제 해설

문제 조건을 모두 읽어보면 어렵다고 생각할 수 있지만, 주어진 그래프는 항상 조건을 만족하기 때문에 예외 케이스는 생각하지 않아도 된다.

본 문제는 주어진 그래프에서 시작 정점을 찾은 뒤 시작 정점과 인접한 그래프에 대해서 각 그래프가 어떤 조건을 만족하는지 판단을 하면 된다.

### 1. 시작 정점 탐색

시작 정점은 incoming edge와 outgoing edge의 개수를 보고 판단할 수 있다. 항상 도넛 모양 그래프, 막대 모양 그래프, 8자 모양 그래프의 수의 합은 2 이상이기 때문에 시작 정점의 outgoing edge는 2 이상이어야 한다. 또한 시작 정점에는 incoming edge가 없기 때문에 다음과 같은 코드를 통해 시작 정점을 탐색할 수 있다.

```java
for (int i = 1; i <= N; i++) {
    if (outgoing.get(i).size() >= 2 && incoming.get(i).size() == 0) {
        answer[START] = i;
        break;
    }
}
```

문제 조건 상 최대 정점 개수가 $10^6$이기 때문에 인접 행렬로 그래프를 구현할 수 없어, outgoing edge에 대한 인접 리스트와 incoming edge에 대한 인접 리스트를 각각 계산해두었다.

### 2. 그래프 개수 계산

이제 시작 정점에 인접한 그래프들이 각각 어떤 조건을 만족하는지 판단하고 개수를 계산하면 된다. 항상 도넛 모양 그래프는 cycle이 1개, 막대 모양 그래프는 cycle이 0개, 8자 모양 그래프는 cycle이 2개이다. 그러므로 DFS를 통해 각 그래프의 cycle 개수를 계산하면 문제를 해결할 수 있다.

```java
public void dfs(int start, int node) {
    visited[node] = true;
    for (int next: outgoing.get(node)) {
        if (visited[next]) {
            cycle += 1;
        } else {
            dfs(start, next);
        }
    }
}

...

for (int i: outgoing.get(answer[START])) {
    cycle = 0;
    dfs(i, i);
    if (cycle == 0) {
        answer[STICK] += 1;
    } else if (cycle == 1) {
        answer[DONUT] += 1;
    } else if (cycle == 2) {
        answer[EIGHT] += 1;
    }
}
```

DFS 탐색 중 다음 정점이 이미 방문한 정점인 경우 `cycle + 1`을 수행한다.

## 시간 복잡도

각 정점의 방문 횟수가 상수이기 때문에, 최대 정점 개수를 $N$이라고 할 때 전체 시간 복잡도는 $O(N)$이다. 