class Solution {
    int answer = 0;
    
    static int[][] dirs = {
        {-1, -1},
        {-1, 0},
        {-1, 1}
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
    
    public void dfs(int depth, int n, boolean[][] visited) {
        if (depth >= n) {
            answer += 1;
            return ;
        }
        
        for (int i = 0; i < n; i++) {
            if (validate(visited, depth, i)) {
                visited[depth][i] = true;
                dfs(depth + 1, n, visited);
                visited[depth][i] = false;
            }
        }
    }
    
    public int solution(int n) {
        dfs(0, n, new boolean[n][n]);
        return answer;
    }
}