import java.util.*;

class Solution {

    public long solution(int[] weights) {
        Map<Double, Long> map = new HashMap<>();
        long answer = 0;

        Arrays.sort(weights);
        
        for (int weight: weights) {
            Double w = Double.valueOf(weight);
            if (map.containsKey(w)) {
                answer += map.get(w);
            }
            if (map.containsKey(w * 0.5)) {
                answer += map.get(w * 0.5);
            }
            if (map.containsKey(w * (2.0/3.0))) {
                answer += map.get(w * (2.0/3.0));
            }
            if (map.containsKey(w * 0.75)) {
                answer += map.get(w * 0.75);
            }
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }
        
        return answer;
    }
}