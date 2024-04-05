# 문제 풀이

## 문제 해설

`(행, 열, 방향)`을 정점이라고 생각하고 시작 정점부터 다시 되돌아올 때까지 그래프를 탐색한다. 정점을 방문할 때마다 방문 표시를 해 다음 탐색 때 같은 경로의 싸이클을 탐색하는 것을 방지한다. `(행, 열, 방향)`으로 이루어진 한 정점은 하나의 싸이클 경로에만 속하기 때문이다.

또 조심할 점은 빛이 격자의 끝을 넘어갈 경우, 반대쪽 끝으로 다시 돌아오는 경우이다. 이는 모듈러 연산을 통해 다음과 같이 구현할 수 있다.

```java
public Node nextNode(char[][] graph) {
    int n = graph.length;
    int m = graph[0].length;
    
    int ni = i + dirs[dir][0];
    int nj = j + dirs[dir][1];
    int nd = dir;

    if (ni >= 0) {
        ni %= n;
    } else {
        ni = (n + ni) % n;
    }
    
    if (nj >= 0) {
        nj %= m;
    } else {
        nj = (m + nj) % m;
    }
    
    if (graph[ni][nj] == 'L') {
        nd = (dirs.length + nd - 1) % dirs.length;
    } else if (graph[ni][nj] == 'R') {
        nd = (nd + 1) % dirs.length;
    }
    
    return new Node(ni, nj, nd);
}
```

## 시간 복잡도

행 크기를 $N$, 열 크기를 $M$이라고 할 때 전체 정점 개수는 $4\times N \times M$이다. 각 정점의 방문 횟수가 상수이기 때문에, 전체 시간 복잡도는 $O(4\times N \times M)$이다.