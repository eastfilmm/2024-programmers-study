class Solution {
    static public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    static public int gcd(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);
        }
        return result;
    }
    
    static boolean filter(int[] array, int d) {
        for (int n: array) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = gcd(arrayA);
        int gcdB = gcd(arrayB);
        
        if (filter(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }

        if (filter(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
}