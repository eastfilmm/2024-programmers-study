class Solution {
    int answer = 0;

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
    
    public void dfs(int row, int n, int[] visited) {
        if (row >= n) {
            answer += 1;
            return ;
        }
        
        for (int col = 0; col < n; col++) {
            if (visited[col] <= 0) {
                visited[col] = row + 1;
                if (validate(visited, col)) {
                    dfs(row + 1, n, visited);
                }
                visited[col] = 0;
            }
        }
    }
    
    public int solution(int n) {
        dfs(0, n, new int[n]);
        return answer;
    }
}