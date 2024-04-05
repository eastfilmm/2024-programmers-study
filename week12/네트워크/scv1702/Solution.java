class Solution {
    
    public void dfs(int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        
        for (int next = 0; next < graph.length; next++) {
            if (!visited[next] && graph[node][next] == 1) {
                dfs(next, graph, visited);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(node, computers, visited);
                answer += 1;
            }
        }
        return answer;
    }
}