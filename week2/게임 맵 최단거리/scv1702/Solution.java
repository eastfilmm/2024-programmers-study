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