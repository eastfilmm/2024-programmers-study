import java.util.*;

class Solution {

    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] mem = new int[n][n];

        mem[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                mem[i][j] = mem[i-1][j];
                if (j - 1 >= 0) {
                    mem[i][j] = Math.max(mem[i][j], mem[i-1][j-1]);
                }
                mem[i][j] += triangle[i][j];
            }
        }

        return Arrays.stream(mem[n-1]).max().getAsInt();
    }
}