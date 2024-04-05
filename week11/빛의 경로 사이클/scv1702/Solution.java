import java.util.*;

class Node {
    static final int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    
    int i;
    int j;
    int dir;
    
    Node(int i, int j, int dir) {
        this.i = i;
        this.j = j;
        this.dir = dir;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;
        return this.i == node.i && 
            this.j == node.j && 
            this.dir == node.dir;   
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(i, j, dir);
    }
    
    public Node nextNode(char[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        
        int ni = i + dirs[dir][0];
        int nj = j + dirs[dir][1];
        int nd = dir;
        
        if (ni >= 0) {
            ni %= n;
        } else {
            ni = (n + ni) % n;
        }
        
        if (nj >= 0) {
            nj %= m;
        } else {
            nj = (m + nj) % m;
        }
        
        if (graph[ni][nj] == 'L') {
            nd = (dirs.length + nd - 1) % dirs.length;
        } else if (graph[ni][nj] == 'R') {
            nd = (nd + 1) % dirs.length;
        }
        
        return new Node(ni, nj, nd);
    }
}

class Solution {
    Set<Node> checked = new HashSet<>();
    List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        char[][] graph = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = grid[i].charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int dir = 0; dir < Node.dirs.length; dir++) {
                    Node start = new Node(i, j, dir);
                    if (!checked.contains(start)) {
                        checked.add(start);
                        Node next = start.nextNode(graph);
                        int depth = 1;
                        while (!next.equals(start)) {
                            checked.add(next);
                            next = next.nextNode(graph);
                            depth += 1;
                        }
                        answer.add(depth);
                    }
                }
            }
        }
        
        return answer.stream()
            .sorted()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}