// 다시 풀어볼 것
import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] d = { 4, 1, 2 };
        
        while (n > 0) {
            answer.append(d[n % 3]);
            if (n % 3 == 0) {
                n = n / 3 - 1;
            } else {
                n = n / 3;
            }
        }
        
        return answer.reverse().toString();
    }
}