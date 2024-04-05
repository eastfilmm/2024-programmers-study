import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for (int i = x + 1; i <= y; i++) {
            int temp = Integer.MAX_VALUE;
            if (i - n >= x) {
                temp = Math.min(temp, dp[i - n]);
            }
            if (i % 2 == 0 && i / 2 >= x) {
                temp = Math.min(temp, dp[i / 2]);
            }
            if (i % 3 == 0 && i / 3 >= x) {
                temp = Math.min(temp, dp[i / 3]);
            }
            if (temp < Integer.MAX_VALUE) {
                dp[i] = temp + 1;
            }
        }
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}