import java.util.*;

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
    
    static public Set<Integer> cd(int number) {
        Set<Integer> result = new HashSet<>();
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
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
        
        for (int d: cd(gcdA)) {
            if (filter(arrayB, d)) {
                answer = Math.max(answer, d);
            }
        }
        
        for (int d: cd(gcdB)) {
            if (filter(arrayA, d)) {
                answer = Math.max(answer, d);
            }
        }
        
        return answer;
    }
}