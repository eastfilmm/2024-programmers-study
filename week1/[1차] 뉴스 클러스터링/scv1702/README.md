# 문제 풀이

## 문제 해설

본 문제는 주어진 문자열 `str1`과 `str2`에 대해 다중 집합으로 만든 후 두 다중 집합 간 자카드 유사도를 구하는 문제다. 구현 문제이기 때문에 문제에서 명시된 대로 구현하면 된다. 다만 필자는 두 집합의 교집합과 합집합을 구하는 과정을 `HashMap`을 이용하였다. `jacardHelper()`에서 두 집합에서 등장하는 각 원소의 개수를 `map`에 기록한 뒤, 이를 이용해 교집합과 합집합의 원소 개수를 구하였다.

## 시간 복잡도

본 문제는 두 문자열에 대해 선형 탐색만을 수행한다. 가장 많은 시간이 걸리는 지점은 두 다중 집합 간의 교집합과 합집합의 원소 개수를 구하는 부분인데, 이는 `map.keySet()`의 크기에 의존한다. `map.keySet()`의 크기는 `str1` 다중 집합과 `str2` 다중 집합의 원소 개수를 모두 합한 것과 같다. 그러므로 시간 복잡도는 `O(len(str1) + len(str2))`이다.

```java
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
        // set1의 각 원소 개수 계산
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
        // set2의 각 원소 개수 계산
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
        // set1과 set2의 교집합과 합집합의 원소 개수 계산
        // result[0]: 교집합의 원소 개수
        // result[1]: 합집합의 원소 개수
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
```