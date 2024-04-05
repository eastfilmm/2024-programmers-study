import java.util.*;

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    // 원판 한 장을 from에서 to로 옮긴다.
    public void move(int from, int to) {
        result.add(List.of(from, to));
    }
    
    //n개의 원판을 from에서 by를 거쳐 to로 옮긴다.
    public void hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            move(from, to);
        } else {
            hanoi(n-1, from, to, by);
            move(from, to);
            hanoi(n-1, by, from, to);
        }
    }
    
    public List<List<Integer>> solution(int n) {
        hanoi(n, 1, 2, 3);
        return result;
    }
}