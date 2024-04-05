class Solution {  
    int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int[][] dp = new int[n+1][m];
        
        for (int i = 0; i < m; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        
        return answer;
    }
}