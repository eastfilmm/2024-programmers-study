import java.util.*;

class Solution {
    
    public int compress(String s, int u) {
        StringBuilder sb = new StringBuilder();
        List<String> splited = new ArrayList<>();
        for (int i = 0; i < s.length(); i += u) {
            splited.add(s.substring(i, Math.min(s.length(), i + u)));
        }
        int repeat = 1;
        int n = splited.size();
        for (int i = 1; i < n; i++) {
            if (splited.get(i).equals(splited.get(i - 1))) {
                repeat += 1;
            } else {
                if (repeat > 1) {
                    sb.append(repeat);
                }
                sb.append(splited.get(i - 1));
                repeat = 1;
            }
        }
        if (repeat > 1) {
            sb.append(repeat);
        }
        sb.append(splited.get(n - 1));
        return sb.length();
    }
    
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        if (n <= 1) {
            return n;
        }
        //u: 문자열 자르는 단위
        for (int u = 1; u < n; u++) {
            answer = Math.min(answer, compress(s, u));
        }
        return answer;
    }
}