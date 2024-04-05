import java.util.*;

class Solution {
    public int convertTime(String time) {
        int[] splited = Arrays.stream(time.split(":"))
            .mapToInt(Integer::parseInt)
            .toArray();
        return splited[0] * 60 + splited[1];
    }
    
    public void clean(PriorityQueue<Integer> pq, int e) {
        if (pq.isEmpty()) {
            return ;
        }
        if (pq.peek() > e) {
            return ;
        }
        pq.poll();
    }
    
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int i = 0; i < book_time.length; i++) {
            String[] t = book_time[i];
            times[i][0] = convertTime(t[0]);
            times[i][1] = convertTime(t[1]) + 10;
        }
        Arrays.sort(times, (t1, t2) -> t1[0] - t2[0]);
        for (int[] time: times) {
            clean(rooms, time[0]);
            rooms.offer(time[1]);
        }
        return rooms.size();
    }
}