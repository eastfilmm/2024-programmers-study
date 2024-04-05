import java.util.*;

class Solution {
    public int modSum(int[][] data, int row) {
        int base = row + 1;
        int result = 0;
        for (int i = 0; i < data[0].length; i++) {
            result += data[row][i] % base;
        }
        return result;
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (a, b) -> {
            int base = col - 1;
            if (a[base] - b[base] != 0) {
                return a[base] - b[base];
            }
            return b[0] - a[0];
        });
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            answer ^= modSum(data, i);
        }
        return answer;
    }
}