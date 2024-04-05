import java.util.*;

class Solution {    
    boolean[] visited = new boolean[3];
    String[] result = new String[3];
    String[] arr = { "+", "-", "*" };
    long answer = -1;
    
    public int compare(String o1, String o2) {
        int i1 = 0;
        int i2 = 0;
        
        for (int i = 0; i < 3; i++) {
            if (result[i].equals(o1)) {
                i1 = i;
            }
            if (result[i].equals(o2)) {
                i2 = i;
            }
        }
        
        return i1 - i2;
    }
    
    public long calculate(List<String> postfix) {
        Stack<Long> stack = new Stack<>();
        for (String s: postfix) {
            int idx = "+-*".indexOf(s); 
            switch (idx) {
                case 0:
                    stack.push(stack.pop() + stack.pop());
                    break;
                case 1:
                    stack.push((-1) * (stack.pop() - stack.pop()));
                    break;
                case 2:
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Long.parseLong(s));
                    break;
            }
        }
        return stack.pop();
    }
    
    public List<String> toPostfix(String expression) {
        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "+|-|*", true);
        
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if ("+-*".contains(t)) {
                while (!stack.isEmpty() && compare(stack.peek(), t) >= 0) {
                    postfix.add(stack.pop());
                }
                stack.push(t);
            } else {
                postfix.add(t);
            }
        }
        
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        
        return postfix;
    }

    public void helper(String expression, int depth) {
        if (depth >= 3) {
            List<String> postfix = toPostfix(expression);
            answer = Math.max(answer, Math.abs(calculate(postfix)));
            return ;
        }
        
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                helper(expression, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public long solution(String expression) {
        helper(expression, 0);
        return answer;
    }
}