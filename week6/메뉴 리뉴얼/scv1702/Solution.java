import java.util.*;
import java.util.stream.*;

class Solution {
    class Combination {
        private List<String> result;
        private String selected;
        private int r;
        private char[] bukit;
        
        public Combination(String selected, int r) {
            this.selected = Stream.of(selected.split(""))
                    .sorted()
                    .collect(Collectors.joining());
            this.r = r;
            this.bukit = new char[r];
            this.result = new ArrayList<>();
            helper(0, 0);
        }
        
        private void helper(int depth, int next) {
            if (depth >= r) {
                result.add(String.valueOf(bukit));
                return ;
            }
            
            for (int i = next; i < selected.length(); i++) {
                bukit[depth] = selected.charAt(i);
                helper(depth + 1, i + 1);
            }
        }
        
        public List<String> getResult() {
            return this.result;
        }
    }
    
    // 가장 많이 주문한 단품 메뉴 조합 탐색
    public List<String> createCourse(String[] orders, int count) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        
        for (String order: orders) {
            Combination combination = new Combination(order, count);
            for (String course: combination.getResult()) {
                counts.put(course, counts.getOrDefault(course, 0) + 1);
            }
        }
        
        if (counts.entrySet().size() == 0) {
            return result;
        }
        
        int max = Collections.max(counts.entrySet(), (e1, e2) -> {
            return e1.getValue().compareTo(e2.getValue());
        }).getValue();
        
        if (max < 2) {
            return result;
        }
        
        for (String key: counts.keySet()) {
            if (counts.get(key) == max) {
                result.add(key);
            }
        }

        return result;
    }
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < course.length; i++) {
            List<String> c = createCourse(orders, course[i]);   
            if (c != null) {
                answer.addAll(c);
            } else {
                break;
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}