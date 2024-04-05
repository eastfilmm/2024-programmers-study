import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            if (pq.size() > k) {
                int e = pq.poll();
                if (e > n) {
                    return i;
                }
                n -= e;
            }
        }
        return enemy.length;
    }
}