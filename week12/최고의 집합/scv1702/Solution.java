import java.util.*;

class Solution {
    
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int d = s / n;
        
        if (d < 1) {
            return new int[] { -1 };
        }
        
        Arrays.fill(answer, d);
        
        for (int i = n - 1; i >= n - s % n; i--) {
            answer[i] += 1;
        }

        return answer;
    }
}