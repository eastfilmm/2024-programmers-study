import java.util.*;

class Solution {
    static final int START = 0;
    static final int DONUT = 1;
    static final int STICK = 2;
    static final int EIGHT = 3;
    
    int[] answer = new int[4];
    List<List<Integer>> incoming;
    List<List<Integer>> outgoing;
    boolean[] visited;
    int cycle = 0;
    
    public void dfs(int start, int node) {
        visited[node] = true;
        for (int next: outgoing.get(node)) {
            if (visited[next]) {
                cycle += 1;
            } else {
                dfs(start, next);
            }
        }
    }
    
    public int[] solution(int[][] edges) {
        // 최대 정점 번호 탐색
        int N = 0;
        for (int[] edge: edges) {
            N = Math.max(N, Math.max(edge[0], edge[1]));
        
            
        // 그래프 구성
        incoming = new ArrayList<>();
        outgoing = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            incoming.add(new ArrayList<>());
            outgoing.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            outgoing.get(u).add(v);
            incoming.get(v).add(u);
        }
        
        // 시작 정점 탐색
        for (int i = 1; i <= N; i++) {
            if (outgoing.get(i).size() >= 2 && incoming.get(i).size() == 0) {
                answer[START] = i;
                break;
            }
        }
        
        // 그래프 개수 계산
        for (int i: outgoing.get(answer[START])) {
            cycle = 0;
            dfs(i, i);
            if (cycle == 0) {
                answer[STICK] += 1;
            } else if (cycle == 1) {
                answer[DONUT] += 1;
            } else if (cycle == 2) {
                answer[EIGHT] += 1;
            }
        }
        
        return answer;
    }
}