import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> belt = new Stack<>(); 
        int n = order.length;
        int box = 1;
        int orderIdx = 0;
        
        while (box <= n && orderIdx < n) {
            if (box != order[orderIdx]) {
                if (!belt.isEmpty() && belt.peek() == order[orderIdx]) {
                    belt.pop();
                    orderIdx++;
                } else {
                    belt.push(box);
                    box++;
                }
            } else {
                orderIdx++;
                box++;
            }
        }
        
        while (orderIdx < n 
            && !belt.isEmpty() 
            && belt.pop() == order[orderIdx]) {
            orderIdx++;
        }
        
        return orderIdx;
    }
}