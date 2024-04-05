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