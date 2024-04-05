import java.util.*;
class Solution {
    public List<Long> solution(long[] numbers) {
        List<Long> answer = new ArrayList<>();
        for(long number : numbers){
            StringBuilder numberBuilder = new StringBuilder(Long.toString(number,2)).reverse();
            String reversedBinaryNum = numberBuilder.toString();
            //0이 포함되어있을 떄 최하위 0을 1로 바꿈
            if(reversedBinaryNum.contains("0")){
                numberBuilder.insert(reversedBinaryNum.indexOf("0") + 1, "1");
                // System.out.println(numberBuilder.toString());
                if(numberBuilder.length() > 3 && reversedBinaryNum.indexOf("0") != 0 ){
                    numberBuilder.deleteCharAt(reversedBinaryNum.indexOf("0") - 1);
                }else{
                    numberBuilder.deleteCharAt(reversedBinaryNum.indexOf("0"));
                }
                answer.add(Long.parseLong(numberBuilder.reverse().toString(),2));
                continue;
            }
            
            //0이 포함 안되어 있을 때맨 뒤에 10으로로 바꿈
            numberBuilder.deleteCharAt(numberBuilder.length()-1);
            numberBuilder.append("01");
            answer.add(Long.parseLong(numberBuilder.reverse().toString(),2));
        }
        return answer;
    }
}