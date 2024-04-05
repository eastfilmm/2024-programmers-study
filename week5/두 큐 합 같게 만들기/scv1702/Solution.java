// 다시 풀어볼 것
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long s1 = 0;
        long target = 0;

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            q1.add(queue1[i]);
            s1 += queue1[i];
            target += queue1[i];
        }
        
        for (int i = 0; i < n; i++) {
            q2.add(queue2[i]);
            target += queue2[i];
        }
        
        if (target % 2 != 0) {
            return -1;
        }
        
        target /= 2;
        
        for (int i = 0; i < 4 * n; i++) {
            if (s1 > target) {
                int temp = q1.poll();
                s1 -= temp;
                q2.offer(temp);
            } else if (s1 == target) {
                return i;
            } else if (s1 < target) {
                int temp = q2.poll();
                s1 += temp;
                q1.offer(temp);
            }
        }
 
        return -1;
    }
}