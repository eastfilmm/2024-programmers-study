class Solution {
    class Dfs {
        boolean[] visited;
        boolean[][] graph;
        int start;
        int result;
        
        Dfs(boolean[][] graph, int start) {
            this.visited = new boolean[graph.length];
            this.graph = graph;
            this.start = start;
            this.result = Integer.MAX_VALUE;
            helper(start);
        }
        
        private int helper(int node) {
            visited[node] = true;
            int child = 1;
            for (int i = 0; i < graph.length; i++) {
                if (graph[node][i] && !visited[i]) {
                    child += helper(i);
                }
            }
            result = Math.min(result, Math.abs(child - (graph.length - child)));
            return child;
        }
    }
    
    public int solution(int n, int[][] wires) {
        boolean[][] graph = new boolean[n][n];
        for (int[] edge: wires) {
            edge[0] -= 1;
            edge[1] -= 1;
        } 
        for (int[] edge: wires) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        } 
        return new Dfs(graph, 0).result;
    }
}