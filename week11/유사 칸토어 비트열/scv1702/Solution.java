class Solution {
    public int cantor(long i) {
        if (i % 5 == 2) {
            return 0;
        }
        
        if (i < 5 && i % 5 != 2) {
            return 1;
        }
        
        return cantor(i / 5);
    }
    
    public int solution(int n, long l, long r) {
        int answer = 0;
        for (long i = l - 1; i < r; i++) {
            if (cantor(i) == 1) {
                answer += 1;
            }
        }
        return answer;
    }
}