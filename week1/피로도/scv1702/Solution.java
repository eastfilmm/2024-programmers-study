import java.util.*;

class Solution {
    boolean[] visited;
    int[] result;
    int answer = -1;
    
    public void permutation(int n, int depth, int[][] dungeons, int k) {
        int f = k;
        int d = 0;
        if (depth == n) {
            for (int i: result) {
                if (f < dungeons[i][0] || f <= 0) {
                    break;
                }
                f -= dungeons[i][1];
                d += 1;
            }
            answer = Math.max(answer, d);
            return ;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permutation(n, depth + 1, dungeons, k);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];
        result = new int[n];
        permutation(n, 0, dungeons, k);
        return answer;
    }
}