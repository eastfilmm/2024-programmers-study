class Solution {
    char[] friends = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
    char[] result = new char[friends.length];
    boolean[] visited = new boolean[friends.length];
    
    int answer = 0;
    
    public int indexOf(char friend) {
        for (int i = 0; i < friends.length; i++) {
            if (result[i] == friend) {
                return i;
            }
        }
        return -1;
    }
    
    public void permutation(int depth, String[] data) {
        if (depth >= friends.length) {
            for (String condition: data) {
                int src = indexOf(condition.charAt(0));
                int des = indexOf(condition.charAt(2));
                char opcode = condition.charAt(3);
                int operand = condition.charAt(4) - '0';
                int distance = Math.abs(src - des) - 1;
                if (opcode == '=') {
                    if (distance != operand) {
                        return ;
                    }
                } else if (opcode == '<') {
                    if (distance >= operand) {
                        return ;
                    }
                } else if (opcode == '>') {
                    if (distance <= operand) {
                        return ;
                    }
                }
            }
            answer += 1;
            return ;
        }
        
        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                result[depth] = friends[i];
                visited[i] = true;
                permutation(depth + 1, data);
                visited[i] = false;
            }
        }    
    }
    
    public int solution(int n, String[] data) {
        permutation(0, data);
        return answer;
    }
}