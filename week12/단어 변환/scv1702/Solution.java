import java.util.*;

class Solution {
    class Pair {
        String word;
        int depth;
        
        Pair(String w, int d) {
            this.word = w;
            this.depth = d;
        }
    }
    
    public int diff(String w1, String w2) {
        int result = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                result += 1;
            }
        }
        return result;
    }
    
    public List<String> getOneDiffWords(String[] words, String w) {
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if (diff(word, w) == 1) {
                result.add(word);
            }
        }
        return result;
    }
    
    public int solution(String begin, String target, String[] words) {
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        graph.put(begin, getOneDiffWords(words, begin));
        for (String word: words) {
            graph.put(word, getOneDiffWords(words, word));
        }
        
        visited.add(begin);
        queue.offer(new Pair(begin, 0));
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.word.equals(target)) {
                return pair.depth;
            }
            for (String next: graph.get(pair.word)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(new Pair(next, pair.depth + 1));
                }
            }
        }
        
        return 0;
    }
}