import java.util.*;

class Solution {
    public long findZero(long n) {
        long i = 0;
        while (n > 0) {
            if ((n & 1L) == 0) {
                return i;
            }
            n >>>= 1L;
            i += 1;
        }
        return i;
    }
    
    public long setOne(long n, long i) {
        long mask = 1L << i;
        return n | mask;
    }
    
    public long setZero(long n, long i) {
        long mask = ~(1L << i);
        return n & mask;
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if (number % 2 == 0) {
                number += 1;
            } else {
                long zeroOfNumber = findZero(number);
                number = setOne(number, zeroOfNumber);
                number = setZero(number, zeroOfNumber - 1);
            }
            answer[i] = number;
        }
        return answer;
    }
}