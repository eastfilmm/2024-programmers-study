import java.util.*;
import static java.util.Comparator.comparing;

class Solution {
    class Pair {
        int distance;
        int node;
        
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        
        int getDistance() {
            return this.distance;
        }
        
        @Override
        public String toString() {
            return String.format("node = %d, distance = %d", node, distance);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int[][] graph = new int[N][N];
        int[] distances = new int[N];
        Arrays.stream(graph).forEach(g -> Arrays.fill(g, Integer.MAX_VALUE));
        Arrays.fill(distances, Integer.MAX_VALUE);
        for (int[] r: road) {
            int u = r[0] - 1;
            int v = r[1] - 1;
            int e = r[2];
            graph[u][v] = Math.min(graph[u][v], e);
            graph[v][u] = Math.min(graph[v][u], e);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(comparing(Pair::getDistance));
        pq.offer(new Pair(0, 0));
        distances[0] = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int distance = pair.distance;
            if (distances[node] < distance) continue;
            for (int i = 0; i < N; i++) {
                if (graph[node][i] < Integer.MAX_VALUE) {
                    int nextDistance = distance + graph[node][i];
                    if (nextDistance < distances[i]) {
                        distances[i] = nextDistance;
                        pq.offer(new Pair(i, distances[i]));
                    }
                }
            }
        }
        int answer = (int) Arrays.stream(distances).filter(d -> d <= K).count();
        return answer;
    }
}