class Solution {
    private static final int SIZE = 11;
    private static final int[][] diff = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    
    class Point {
        int r = 0;
        int c = 0;
        
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public Point getNextPoint(char d, int r, int c) {
        String dirs = "UDRL";
        int i = dirs.indexOf(d);
        int nr = r + diff[i][0];
        int nc = c + diff[i][1];
        if (nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE) {
            return new Point(nr, nc);
        }
        return null;
    }
    
    public int solution(String dirs) {
        int answer = 0; 
        boolean[][] visited = new boolean[SIZE * SIZE][SIZE * SIZE];
        int r = 5;
        int c = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char d = dirs.charAt(i);
            Point np = getNextPoint(d, r, c);
            if (np == null) continue;
            int nr = np.r;
            int nc = np.c;
            if (!visited[r * SIZE + c][nr * SIZE + nc]) {
                answer += 1;
                visited[r * SIZE + c][nr * SIZE + nc] = true;
                visited[nr * SIZE + nc][r * SIZE + c] = true;
            }
            r = nr;
            c = nc;
        }
        return answer;
    }
}