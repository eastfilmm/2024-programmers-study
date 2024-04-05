import java.util.*;

class Solution {
    String[] splited;
    String[] result;
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
  
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int toInteger(int d) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d; i++) {
            sb.append(result[i]);
        }
        return Integer.parseInt(sb.toString());
    }
    
    public void permutation(int n, int d, int depth) {
        if (depth >= d) {
            int number = toInteger(d);
            if (!set.contains(number) && isPrime(number)) {
                set.add(number);
            }
            return ;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result[depth] = splited[i];
                visited[i] = true;
                permutation(n, d, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        splited = numbers.split("");
        int n = splited.length;
        visited = new boolean[n];
        result = new String[n];
        for (int i = 1; i <= n; i++) {
            permutation(n, i, 0);
        }
        return set.size();
    }
}