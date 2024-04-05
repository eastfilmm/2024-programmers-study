# 문제 풀이

## 문제 해설

본 문제는 전형적인 넓이 우선 탐색(BFS) 문제이다. 그래프가 주어지고 각 정점 간 가중치가 존재하지 않을 때(또는 모두 동일할 때) 넓이 우선 탐색을 이용하면 정점 간 최단 거리를 계산할 수 있다.

## 시간 복잡도

넓이 우선 탐색의 시간 복잡도는 그래프를 표현한 자료 구조가 인접 행렬인지 인접 리스트인지에 따라 다르다. 그래프 `g`의 정점 개수를 $N$, 간선의 개수를 $E$라고 하자. 넓이 우선 탐색에서 모든 정점은 큐에 단 한 번씩 들어가게 되고, 큐에서 나온 정점은 인접한 정점을 탐색하게 되는데 이 인접한 정점을 탐색하는 과정이 그래프의 표현 방식에 따라 다르다. 

정점 `node`와 인접한 정점을 찾기 위해선 인접 행렬의 경우 `g[node][:N]`을 모두 탐색해야 되기 때문에 $O(N)$이 걸린다. 이를 모든 정점 $N$개에 대해 수행하기 때문에 전체 시간 복잡도는 $O(N^2)$이 된다.

인접 리스트의 경우 `g[node]` 만을 탐색하면 되는데, 넓이 우선 탐색이 종료됐을 때의 관점으로 생각해보면 그래프의 각 정점을 단 한 번씩 방문하고 각 간선 또한 단 한 번씩 탐색되므로 전체 시간 복잡도는 $O(N+E)$이 된다. 

본 문제에서 주어진 `maps`의 경우 방향 변화량에 대한 배열 `dirs`를 사용하면 인접 리스트와 같은 방법으로 넓이 우선 탐색을 할 수 있다.

```java
import java.util.*;

class Solution {
    class Pair {
        int r;
        int c;
        int d;
        
        Pair(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    
    private boolean checkBoundary(int r, int c, int[][] maps) {
        return r >= 0 && r < maps.length && c >= 0 && c < maps[0].length;
    }
    
    public int solution(int[][] maps) {
        Queue<Pair> queue = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = { 
            {0, 1}, 
            {1, 0}, 
            {-1, 0}, 
            {0, -1} 
        }; 
        int r = 0;
        int c = 0;
        
        queue.add(new Pair(r, c, 0));
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            r = pair.r;
            c = pair.c;
            if (r == n - 1 && c == m - 1) {
                return pair.d + 1;
            }
            for (int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (checkBoundary(nr, nc, maps) && !visited[nr][nc] && maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc, pair.d + 1));
                }
            }
        }
        
        return -1;
    }
}
```