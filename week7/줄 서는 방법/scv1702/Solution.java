import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        List<Integer> nums = new ArrayList<>();
        long factorial = 1L;
        
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            factorial *= i;
        }
        
        int[] result = new int[n];
        int idx = 0;
        
        k--;
        while (idx < n) {
            factorial /= n - idx;
            result[idx++] = nums.remove((int) (k / factorial));
            k %= factorial;
        }
        
        return result;
    }
}