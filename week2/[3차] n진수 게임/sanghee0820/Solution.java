import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private final List<Character> chars = Arrays.asList(
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F'
    );
    List<Character> result = new ArrayList<>();
    public List<Character> getKNum(int n, int num){
        List<Character> kNum = new ArrayList();
        if(num == 0){
            kNum.add('0');
        }
        while(num != 0){
            kNum.add(chars.get(num % n));
            num /= n;
        }
        Collections.reverse(kNum);
        return kNum;
    }
    public String solution(int n, int t, int m, int p) {
        
        int num = 0;
        int mCnt = 1;
        while(result.size() < t){
            List<Character> kNum = getKNum(n, num);
            
            for(int i = 0; i < kNum.size(); i++){
                if(mCnt == p){
                    result.add(kNum.get(i));
                }
                mCnt = (mCnt + 1) % (m + 1);
                if(mCnt == 0){
                    mCnt++;
                }
            }
            
            num++;
        }
        String answer =  result.subList(0, t).stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());

        return answer;
    }
}