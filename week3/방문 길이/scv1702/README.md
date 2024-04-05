# 문제 풀이

## 문제 해설

본 문제는 구현 문제로, 배열을 주어진 방향에 따라 탐색하는 문제이다. 이때 처음 가본 간선 개수만 세려야 하므로, `visited` 배열에 `(r, c)`에서 `(nr, nc)`로 가는 경우, 무방향 그래프이기 때문에 `visited[r * SIZE + c][nr * SIZE + nc]`와 `visited[nr * SIZE + nc][r * SIZE + c]`를 `true`로 해주었다.

## 시간 복잡도

전체 시간 복잡도는 주어진 방향들의 개수를 $N$이라고 할 때 $O(N)$이다.

```java
class Solution {
    private static final int SIZE = 11;
    private static final int[][] diff = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    
    class Point {
        int r = 0;
        int c = 0;
        
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public Point getNextPoint(char d, int r, int c) {
        String dirs = "UDRL";
        int i = dirs.indexOf(d);
        int nr = r + diff[i][0];
        int nc = c + diff[i][1];
        if (nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE) {
            return new Point(nr, nc);
        }
        return null;
    }
    
    public int solution(String dirs) {
        int answer = 0; 
        boolean[][] visited = new boolean[SIZE * SIZE][SIZE * SIZE];
        int r = 5;
        int c = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char d = dirs.charAt(i);
            Point np = getNextPoint(d, r, c);
            if (np == null) continue;
            int nr = np.r;
            int nc = np.c;
            if (!visited[r * SIZE + c][nr * SIZE + nc]) {
                answer += 1;
                visited[r * SIZE + c][nr * SIZE + nc] = true;
                visited[nr * SIZE + nc][r * SIZE + c] = true;
            }
            r = nr;
            c = nc;
        }
        return answer;
    }
}
```