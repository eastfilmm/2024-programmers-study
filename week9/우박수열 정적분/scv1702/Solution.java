import java.util.*;

class Solution {
    public int[] collatz(int k) {
        List<Integer> result = new ArrayList<>();
        while (k > 1) {
            result.add(k);
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = 3*k + 1;
            }
        }
        result.add(1);
        return result.stream().mapToInt(i -> Integer.valueOf(i)).toArray();
    }
    
    public double integreal(int[] graph, int a, int b) {
        double result = 0f;
        if (a >= graph.length + b) {
            return -1f;
        }
        for (int x = a + 1; x < graph.length + b; x++) {
            result += ((double) (graph[x] + graph[x-1]) / 2f);
        }
        return result;
    }
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int answerIdx = 0;
        int[] graph = collatz(k);
        for (int[] range: ranges) {
            int a = range[0];
            int b = range[1];
            answer[answerIdx++] = integreal(graph, a, b);
        }
        return answer;
    }
}