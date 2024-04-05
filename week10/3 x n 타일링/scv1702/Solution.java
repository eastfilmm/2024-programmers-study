class Solution {
    static final long MOD = 1_000_000_007;
    
    public int solution(int n) {
        long[] dp = new long[n / 2 + 1];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= n / 2; i++) {
            dp[i] = (dp[i - 1] * 3) % MOD;
            for (int j = 1; j < i - 1; j++) {
                dp[i] += (dp[j] * 2) % MOD;
            }
            dp[i] = (dp[i] + 2) % MOD;
        }
        return (int) (dp[n / 2] % MOD);
    }
}