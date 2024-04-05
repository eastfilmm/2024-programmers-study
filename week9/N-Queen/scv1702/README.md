# 문제 풀이

## 문제 해설

가로, 세로 길이가 $n$인 체스판에 $n$개의 퀸을 서로 공격할 수 없게 배치해야 한다. 퀸은 가로, 세로, 대각선으로 공격할 수 있기 때문에 해당 조건을 만족하기 위해선 무조건 체스판의 각 행에 퀸이 한 개씩 배치되어야 한다. 만약 한 행에 퀸이 2개씩 배치 된다면 서로 가로로 공격할 수 있기 때문이다. 그러므로 첫 번째 행부터 마지막 행까지, 해당 행의 모든 열에 퀸을 놓아보면서 해당 위치가 가능한지 판단한다. 

```java
static int[][] dirs = {
    {-1, -1}, // 왼쪽 대각선
    {-1, 0}, // 위
    {-1, 1} // 오른쪽 대각선
};

public boolean validate(boolean[][] visited, int i, int j) {
    int n = visited.length;
    for (int[] dir: dirs) {
        int ni = i + dir[0];
        int nj = j + dir[1];
        while (ni >= 0 && ni < n && nj >= 0 && nj < n) {
            if (visited[ni][nj]) {
                return false;
            }
            ni = ni + dir[0];
            nj = nj + dir[1];
        }
    }
    return true;
}
```

이는 위 코드와 같이 이전 행을 모두 탐색하면서 해당 위치에서 공격할 수 있는 퀸이 있는지 판단한다.

만약 가능하면 다음 행으로 넘어가면서 마지막 행까지 도착하게 되면 `anwer += 1`을 수행한다.

## 최적화

퀸은 각 행에 하나씩 배치되기 때문에 `visited` 배열을 2차원으로 둘 필요가 없다. `visited` 배열을 1차원으로 줄이고, 각 열마다 퀸이 위치한 행 번호를 저장한다. 그래서 새로운 퀸을 배치할 때마다 기존 퀸과 대각선에 위치한지 아닌지만 판단하면 된다. 대각선에 위치한다는 것은 행의 변화량과 열의 변화량이 같다는 것을 의미하기 때문에, 다음과 같이 판단할 수 있다.

```java
public boolean validate(int[] visited, int col) {
    for (int i = 0; i < visited.length; i++) {
        if (i != col && visited[i] > 0) {
            // 기존 퀸(visited[i])과 새로운 퀸(visited[col])이 대각선에 위치한 경우
            if (Math.abs(i - col) == Math.abs(visited[i] - visited[col])) {
                return false;
            }
        }
    }
    return true;
}
```

## 시간 복잡도

본 문제는 재귀 함수이니 재귀 함수의 시간 복잡도를 구하는 방식을 이용할 수 있다.
$$T(n) = O(n^2) + n \times T(n-1)$$
위 항에서 $O(n^2)$보다는 $n \times T(n-1)$의 영향이 크기 때문에 $O(n^2)$을 제외하고 생각해보면 $n \times (n-1) \times ... \times 1$이 $O(n!)$ 된다는 사실을 알 수 있다. 그러므로 전체 시간 복잡도는 $O(n!)$이다.