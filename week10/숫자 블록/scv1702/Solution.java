import java.util.*;

class Solution {
    static long t = 10_000_000L;
    
    public long decompose(long num) {
        if (num <= 1L) return 0L;
        List<Long> temp = new ArrayList<>();
        for (long i = 2L; i * i <= num; i++) {
            if (num % i == 0L) {
                temp.add(i);
                if (num / i <= t) {
                    return num / i;
                }
            }
        }
        if (temp.size() >= 1) {
            return temp.get(temp.size() - 1);
        }
        return 1L;
    }
    
    public long[] solution(long begin, long end) {
        int n = (int) (end - begin) + 1;
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            long num = i + begin;
            answer[i] = decompose(num);
        }
        return answer;
    }
}