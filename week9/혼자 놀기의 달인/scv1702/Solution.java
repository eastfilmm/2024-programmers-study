import java.util.*;

class Solution {
    public int play(int[] cards, boolean[] visited, int start) {
        int count = 0;
        int i = start;
        while (!visited[i]) {
            visited[i] = true;
            count += 1;
            i = cards[i] - 1;
        }
        return count;
    }
    
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        for (int start = 0; start < n; start++) {
            boolean[] visited = new boolean[n];
            int one = play(cards, visited, start);
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int two = play(cards, Arrays.copyOf(visited, n), i);
                    answer = Math.max(answer, one * two);
                }
            }
        }
        return answer;
    }
}