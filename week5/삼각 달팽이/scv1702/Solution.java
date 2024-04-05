// 다시 풀어볼 것
import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        int LIMIT = n * (n + 1) / 2;
        int[][] dirs = {
            {1, 0}, {0, 1}, {-1, -1}
        };
        int[][] triangle = new int[n][n];
        
        List<Integer> answer = new ArrayList<>(LIMIT);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                triangle[i][j] = -1;
            }
        }
        
        if (n == 1) {
            answer.add(1);
            return answer;
        }
        
        int r = 0;
        int c = 0;
        int d = 0;
        int k = 1;
        
        while (triangle[r][c] < 0) {
            triangle[r][c] = k++;
            int nr = r + dirs[d][0];
            int nc = c + dirs[d][1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && triangle[nr][nc] < 0) {
                r = nr;
                c = nc;
            } else {
                d = (d + 1) % dirs.length;
                r = r + dirs[d][0];
                c = c + dirs[d][1];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (triangle[i][j] > 0) {
                    answer.add(triangle[i][j]);
                }
            }
        }
        
        return answer;
    }
}