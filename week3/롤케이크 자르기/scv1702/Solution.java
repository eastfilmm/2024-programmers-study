import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> ob = new HashMap<>(); // 철수
        Map<Integer, Integer> yb = new HashMap<>(); // 동생
        int answer = 0;
        int n = topping.length;
        
        for (int i = 0; i < n; i++) {
            yb.put(topping[i], yb.getOrDefault(topping[i], 0) + 1);
        }
        
        // 철수: topping[:i]
        // 동생: topping[i:]
        for (int i = 0; i < n; i++) {
            ob.put(topping[i], ob.getOrDefault(topping[i], 0) + 1);
            if (yb.containsKey(topping[i]) && yb.get(topping[i]) > 0) {
                yb.put(topping[i], yb.get(topping[i]) - 1);
                if (yb.get(topping[i]) <= 0) {
                    yb.remove(topping[i]);
                }
            }
            if (ob.size() == yb.size()) {
                answer += 1;
            }
        }
        
        return answer;
    }
}