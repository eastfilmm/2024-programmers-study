import java.util.*;

class Solution {
    // n: 퇴근까지 남은 시간
    // works: 각 일에 대한 작업량
    // demi는 1시간 동안 작업량 1만큼 처리 가능
    // 야근 피로도 = 남은 일의 작업량을 제곱
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work: works) {
            pq.offer(work);
        }
        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            int work = pq.poll();
            if (work - 1 > 0) {
                pq.offer(work - 1);
            }
        }
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (work * work);
        }
        return answer;
    }
}