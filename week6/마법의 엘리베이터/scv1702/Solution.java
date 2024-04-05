class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int d = storey % 10;
            storey /= 10;
            
            if (d > 5) {
                storey += 1;
                answer += 10 - d;
            } else if (d < 5) {
                answer += d;
            } else {
                if (storey % 10 >= 5) {
                    storey += 1;
                }
                answer += 5;
            }
        }
        
        return answer;
    }
}