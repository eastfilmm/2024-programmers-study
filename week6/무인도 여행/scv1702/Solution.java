import java.util.*;

class Solution {
    static int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static int[][] graph;
    static int n;
    static int m;
    static int s;
    
    public void helper(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= m) {
            return ;
        }

        if (graph[r][c] == 0) {
            return ;
        }

        s += graph[r][c];
        graph[r][c] = 0;
        
        for (int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            helper(nr, nc);
        }
    }
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = c - '0';
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                helper(i, j);
                if (s > 0) {
                    answer.add(s);
                    s = 0;
                }
            }
        }
        if (answer.size() == 0) {
            answer.add(-1);
        }
        return answer.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }
}