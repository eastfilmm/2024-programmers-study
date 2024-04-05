# 문제 풀이

## 문제 해설

본 문제는 구현 문제로 해시 맵과 문자열 처리만 적절히 할 줄 알면 쉽게 해결할 수 있다.

## 시간 복잡도

`records`의 길이를 $N$이라고 할 때, 모든 기록은 한 번씩 탐색되기 때문에 $O(N)$이 걸린다. 두 번째 `for` 문에서도 모든 자동차 번호에 대해 입출차 기록인 `recordList`을 탐색하는데, 이들을 모두 합하면 `records`의 개수와 같다.

```java
import java.util.*;

class Solution {
    private int toTime(String t) {
        StringTokenizer st = new StringTokenizer(t, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        return h * 60 + m;
    }
    
    public List<Integer> solution(int[] fees, String[] records) {
        Map<Integer, List<Integer>> map = new HashMap<>();    
        List<Integer> answer = new ArrayList<>();
        
        for (String record: records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            int time = toTime(st.nextToken());
            int carNumber = Integer.parseInt(st.nextToken());
            List<Integer> recordList = map.getOrDefault(carNumber, new ArrayList<>());
            recordList.add(time);
            map.put(carNumber, recordList);
        }
        
        List<Integer> carNumbers = new ArrayList<>(map.keySet());
        Collections.sort(carNumbers);

        for (int carNumber: carNumbers) {
            List<Integer> recordList = map.get(carNumber);
            int fee = 0;
            int accumulateTime = 0;
            if (recordList.size() % 2 != 0) {
                recordList.add(60 * 23 + 59);
            }
            for (int i = 0; i < recordList.size() - 1; i += 2) {
                int in = recordList.get(i);
                int out = recordList.get(i + 1);
                accumulateTime += out - in;
            }
            if (accumulateTime <= fees[0]) {
                answer.add(fees[1]);
            } else {
                answer.add(fees[1] + ((int) Math.ceil((double) (accumulateTime - fees[0]) / fees[2])) * fees[3]);
            }
        }
        
        return answer;
    }
}
```