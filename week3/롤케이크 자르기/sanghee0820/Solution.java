import java.util.*;
class Solution {
    public int solution(int[] toppings) {
        int[] left = getLeft(toppings);
        int[] right = getRight(toppings);
        int answer = 0;
        for(int i = 0; i < toppings.length - 1; i++){
            if(left[i] == right[i + 1]){
                answer++;
            }
        }
        return answer;
    }
    
    private int[] getLeft(int[] toppings){
        int total = 0;
        int[] left = new int[toppings.length];
        boolean[] visited = new boolean[10000];
        for(int i = 0; i < toppings.length; i++){
            int topping = toppings[i];
            if(!visited[topping - 1]){
                visited[topping - 1] = true;
                left[i] = ++total;
                continue;
            }
            left[i] = total;
        }
        return left;
    }
    
    private int[] getRight(int[] toppings){
        int total = 0;
        int[] right = new int[toppings.length];
        boolean[] visited = new boolean[10000];
        for(int i = toppings.length - 1; i > -1; i--){
            int topping = toppings[i];
            if(!visited[topping - 1]){
                visited[topping - 1] = true;
                right[i] = ++total;
                continue;
            }
            right[i] = total;
        }
        return right;
    }
}