class Solution {
    public long solution(int k, int d) {
        long answer = 0L;
        for (long x = 0; x <= d; x += k) {
            long dots = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            answer += dots / k + 1L;
        }
        return answer;
    }
}