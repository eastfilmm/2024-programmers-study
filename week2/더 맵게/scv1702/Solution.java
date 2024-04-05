import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for (int s: scoville) {
            pq.add(s);
        }
        
        while (pq.size() >= 2 && pq.peek() < K) {
            int lowest = pq.poll();
            int second = pq.poll();
            pq.add(lowest + second * 2);
            answer += 1;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}