# 문제 풀이

## 문제 해설

본 문제는 구현 문제로 오픈 채팅방의 로그가 주어질 때 최종적으로 보여지는 로그를 만드는 문제다. 필자는 각 사용자의 닉네임을 저장하는 해시맵 `idToNickname`을 만든 뒤, 전체 로그에서 채팅방의 입장 및 퇴장에 대한 로그만을 가져와 닉네임을 변경한 후 정답 배열에 저장하도록 했다.

## 시간 복잡도

문자열 파싱의 경우 로그 `r`이 짧은 문자열이기 때문에 $O(1)$이 걸린다고 가정하면, `record`의 길이를 $N$이라고 할 때 전체 시간 복잡도는 $O(N)$이다.

```java
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        
        Map<String, String> idToNickname = new HashMap<>();
        
        for (String r: record) {
            StringTokenizer st = new StringTokenizer(r, " ");
            String op = st.nextToken();
            String id = st.nextToken();
            if (!op.equals("Leave")) {
                String nickname = st.nextToken();
                idToNickname.put(id, nickname);
            }
        }
        
        for (String r: record) {
            StringTokenizer st = new StringTokenizer(r, " ");
            String op = st.nextToken();
            String id = st.nextToken();
            String nickname = idToNickname.get(id);
            if (op.equals("Enter")) {
                answer.add(nickname + enter);
            }
            if (op.equals("Leave")) {
                answer.add(nickname + leave);
            }
        }

        return answer.toArray(String[]::new);
    }
}
```