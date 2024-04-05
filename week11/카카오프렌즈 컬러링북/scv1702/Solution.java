class Solution {
    static int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int sizeOfOneArea = 0;
    
    boolean[][] visited;
    
    public boolean checkBoundary(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    
    public void dfs(int[][] picture, int i, int j, int color) {
        int m = picture.length;
        int n = picture[0].length;
        
        if (!checkBoundary(i, j, m, n)) {
            return ;
        }
        
        if (picture[i][j] == color && !visited[i][j]) {
            sizeOfOneArea += 1;
            visited[i][j] = true;
            for (int[] dir: dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                dfs(picture, ni, nj, color);
            }
        }
    }
        
        
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    sizeOfOneArea = 0;
                    dfs(picture, i, j, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                    numberOfArea += 1;
                }
            }
        }
        return new int[] { numberOfArea, maxSizeOfOneArea };
    }
}