import java.util.*;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Bfs {
    char[][] map;
    boolean[][] visited;
    static int[][] dirs = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    int result = -1;

    private Bfs(char[][] map, int source, int destination) {
        this.map = map;
        this.visited = new boolean[map.length][map[0].length];
        helper(source, destination);
    }

    private boolean isValidBoundary(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
    }

    private void helper(int source, int destination) {
        int n = map.length;
        int m = map[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(source, 0));
        visited[source / m][source % m] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int r = pair.node / m;
            int c = pair.node % m;
            if (r * m + c == destination) {
                result = pair.distance;
                return ;
            }
            for (int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (!isValidBoundary(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] != 'X') {
                    queue.offer(new Pair(nr * m + nc, pair.distance + 1));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static int minimumDistance(char[][] map, int source, int destination) {
        return new Bfs(map, source, destination).result;
    }
}

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        char[][] map = new char[n][m];
        
        int start = 0;
        int lever = 0;
        int exit = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    start = i * m + j;
                }
                if (map[i][j] == 'L') {
                    lever = i * m + j;
                }
                if (map[i][j] == 'E') {
                    exit = i * m + j;
                }
            }
        }
        
        int startToLever = Bfs.minimumDistance(map, start, lever);
        int leverToExit = Bfs.minimumDistance(map, lever, exit);
        
        return startToLever >= 0 && leverToExit >= 0 ? startToLever + leverToExit : -1;
    }
}