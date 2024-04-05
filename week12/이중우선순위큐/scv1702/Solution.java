import java.util.*;

class DoublePriorityQueue {

    private int size = 0;
    private Map<Integer, Integer> counts = new HashMap<>();
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    
    public void offer(int num) {
        min.offer(num);
        max.offer(num);
        counts.put(num, counts.getOrDefault(num, 0) + 1);
        size += 1;
    }
    
    public int pollMax() {
        int result = max.poll();
        while (counts.get(result) <= 0) {
            result = max.poll();
        }
        size -= 1;
        counts.put(result, counts.get(result) - 1);
        return result;
    }
    
    public int pollMin() {
        int result = min.poll();
        while (counts.get(result) <= 0) {
            result = min.poll();
        }
        size -= 1;
        counts.put(result, counts.get(result) - 1);
        return result;
    }

    public boolean isEmpty() {
        return size <= 0;
    }
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        DoublePriorityQueue dpq = new DoublePriorityQueue();
        
        for (String operation: operations) {
            String[] splited = operation.split(" ");
            String opcode = splited[0];
            
            if ("I".equals(opcode)) {
                dpq.offer(Integer.parseInt(splited[1]));
            } else if ("D".equals(opcode) && !dpq.isEmpty()) {
                if (splited[1].equals("1")) {
                    dpq.pollMax();
                } else {
                    dpq.pollMin();
                }
            }
        }
        
        if (!dpq.isEmpty()) {
            answer[0] = dpq.pollMax();
            answer[1] = dpq.pollMin();
        }
        
        return answer;
    }
}