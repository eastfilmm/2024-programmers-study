import java.util.*;

class Solution {
    class Element {
        int index;
        int value;
        int time;
        
        Element(int index, int value, int time) {
            this.index = index;
            this.value = value;
            this.time = time;
        }
        
        @Override
        public String toString() {
            return String.format("index={%d}, value={%d}, time={%d}", index, value, time);
        }
    }
    
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Element> stack = new Stack<>();
        int time = 1;
        for (int i = 0; i < n; i++) {
            time += 1;
            while (!stack.isEmpty() && stack.peek().value > prices[i]) {
                Element e = stack.pop();
                answer[e.index] = time - e.time;
            }
            stack.push(new Element(i, prices[i], time));
        }
        
        while (!stack.isEmpty()) {
            Element e = stack.pop();
            answer[e.index] = time - e.time;
        }
        
        return answer;
    }
}