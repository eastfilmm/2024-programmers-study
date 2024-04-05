import java.util.*;

class Solution {
    public int solution(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % mod;
        }
        return dp[n] % mod;
    }
}