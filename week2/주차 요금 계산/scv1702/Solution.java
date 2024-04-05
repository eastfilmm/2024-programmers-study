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