class Solution {
    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public long solution(int w, int h) {
        long W = Math.min(w, h);
        long H = Math.max(w, h); 
        long g = gcd(H, W);
        long k = W / g + H / g - 1;
        return W * H - g * k;
    }
}