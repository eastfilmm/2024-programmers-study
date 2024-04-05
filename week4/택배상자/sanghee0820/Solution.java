import java.util.*;

// stack 확인
// 같은 값이 나올 떄 까지 cur ++;
// 이때 나머지 값들을 subConveyor에 추가
class Solution {
    public int solution(int[] orders) {
        Stack<Integer> subConveyor = new Stack<>();

        int answer = 0;
        int cur = 0;
        for(int i = 1; i < orders.length + 1; i++){   
            if(i == orders[cur]){
                answer++;
                cur++;
                continue;
            }
            while(!subConveyor.isEmpty() && subConveyor.peek() == orders[cur]){
                answer++;
                cur++;
                subConveyor.pop();
                // System.out.println(subConveyor);
            }
            subConveyor.add(i);
            // System.out.println(subConveyor);
        }
        while(!subConveyor.isEmpty() && subConveyor.peek() == orders[cur]){
            answer++;
            cur++;
            subConveyor.pop();
            // System.out.println(subConveyor);
        }
        return answer;
    }
}