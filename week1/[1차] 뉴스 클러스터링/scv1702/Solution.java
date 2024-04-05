import java.util.*;

class Solution {
    public String slice(String str, int i) {
        StringBuilder sb = new StringBuilder();
        if (Character.isAlphabetic(str.charAt(i))) {
            sb.append(str.charAt(i));
        }
        if (Character.isAlphabetic(str.charAt(i + 1))) {
            sb.append(str.charAt(i + 1));
        }
        if (sb.length() < 2) {
            return null;
        }
        return sb.toString();
    }
    
    public List<String> toSet(String str) {
        List<String> set = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n - 1; i++) {
            String sliced = slice(str.toLowerCase(), i);
            if (sliced != null) {
                set.add(sliced);
            }
        }
        return set;
    }
    
    public int jacard(List<String> set1, List<String> set2) {
        int result = 65536;
        if (set1.size() == 0 && set2.size() == 0) {
            return result;
        }
        int[] helper = jacardHelper(set1, set2);
        return result * helper[0] / helper[1];
    }
    
    public int[] jacardHelper(List<String> set1, List<String> set2) {
        int[] result = new int[2];
        Map<String, Integer[]> map = new HashMap<>();
        for (String str: set1) {
            if (map.containsKey(str)) {
                Integer[] counts = map.get(str);
                counts[0] += 1;
                map.put(str, counts);
            } else {
                Integer[] counts = new Integer[2];
                counts[0] = 1;
                counts[1] = 0;
                map.put(str, counts);
            }
        }
        for (String str: set2) {
            if (map.containsKey(str)) {
                Integer[] counts = map.get(str);
                counts[1] += 1;
                map.put(str, counts);
            } else {
                Integer[] counts = new Integer[2];
                counts[0] = 0;
                counts[1] = 1;
                map.put(str, counts);
            }
        }
        for (String str: map.keySet()) {
            Integer[] counts = map.get(str);
            if (counts[0] > 0 && counts[1] > 0) {
                result[0] += Math.min(counts[0], counts[1]);
            }
            result[1] += Math.max(counts[0], counts[1]);
        }
        return result;
    }
    
    public int solution(String str1, String str2) {
        return jacard(toSet(str1), toSet(str2));
    }
}