import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{numbers[0], 0});
        for(int i = 1; i < numbers.length; i++){
            int[] current = stack.peek();
            while(!stack.isEmpty() && current[0] < numbers[i]){
                answer[current[1]] = numbers[i];
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                current = stack.peek();
            }
            stack.add(new int[]{numbers[i], i});
        }
        while(!stack.isEmpty()){
            int[] current = stack.pop();
            answer[current[1]] = -1;
        }
        return answer;
    }
}