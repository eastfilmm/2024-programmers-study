import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);
        dp[x] = 0;
        for(int i = x + 1; i < y + 1; i++){
            if(i / 2.0 % 1 == 0.0 && dp[i/2] != -1){
                // System.out.println("devided 2.0 " + i);
                if(dp[i] == -1){
                    dp[i] = dp[i/2] + 1;
                }
                else{ 
                    dp[i] = Math.min(dp[i/2] + 1, dp[i]);
                }
            }
            if(i / 3.0 % 1 == 0.0 && dp[i/3] != -1){
                // System.out.println("devided 3.0 " + i);
                if(dp[i] == -1){
                    dp[i] = dp[i/3] + 1;
                }
                else{ 
                    dp[i] = Math.min(dp[i/3] + 1, dp[i]);
                }
            }
            if( i - n > 0 && dp[i-n] != -1){
                // System.out.println("mins n " + i);
                if(dp[i] == -1){
                    dp[i] = dp[i- n] + 1;
                }
                else{ 
                    dp[i] = Math.min(dp[i- n] + 1, dp[i]);
                }
            }
        }
        
        return dp[y];
    }
}