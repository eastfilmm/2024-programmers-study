class Solution {
    public boolean isCorrect(String p) {
        return p.charAt(0) == '(';
    }
    
    public String trimAndReverse(String p) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < p.length() - 1; i++) {
            if (p.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }
    
    public String[] divide(String p) {
        String[] result = new String[2];
        int innerCnt = 0; // )에 대해 개수 계산
        int outerCnt = 0; // (에 대해 개수 계산
        int idx = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == ')') {
                innerCnt++;
            }
            if (p.charAt(i) == '(') {
                outerCnt++;
            }
            if (innerCnt == outerCnt) {
                idx = i;
                break;
            }
        }

        result[0] = p.substring(0, idx + 1);
        result[1] = p.substring(idx + 1, p.length());

        return result;
    }
    
    public String helper(String w) {
        if ("".equals(w)) {
            return "";
        }
        
        String[] divided = divide(w);
        
        String u = divided[0];
        String v = divided[1];
        
        if (isCorrect(u)) {
            return u + helper(v);
        }
        
        StringBuilder result = new StringBuilder();
        result.append('(');
        result.append(helper(v));
        result.append(')');
        result.append(trimAndReverse(u));
        
        return result.toString();
    }
    
    public String solution(String p) {
        return helper(p);
    }
}