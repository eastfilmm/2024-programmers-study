import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] nums = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        Arrays.sort(nums, (s1, s2) -> {
            Integer i1 = Integer.parseInt(s1 + s2);
            Integer i2 = Integer.parseInt(s2 + s1);
            return i2.compareTo(i1);
        });
        for (String num: nums) {
            sb.append(num);
        }
        String answer = sb.toString();
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}