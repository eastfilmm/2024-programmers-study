class Solution {
    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        int[][] mem = new int[n][m];
        
        for (int[] puddle: puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;    
        }
        
        for (int i = 0; i < n && map[i][0] != -1; i++) {
            mem[i][0] = 1;
        }
        
        for (int j = 0; j < m && map[0][j] != -1; j++) {
            mem[0][j] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] == -1) {
                    mem[i][j] = 0;
                } else {
                    mem[i][j] = (mem[i-1][j] + mem[i][j-1]) % MOD;
                }
            }
        }
        
        return mem[n-1][m-1] % MOD;
    }
}