import java.util.*;
class Solution {
    public static List<List<Integer>> parseStr(String str) {

        List<List<Integer>> parsedInput = new ArrayList<>();

        str = str.substring(1, str.length() - 1);

        String[] splitStrs = str.split("\\},\\{");

        for (String data : splitStrs) {
            data = data.replace("{", "").replace("}", "");
            String[] numbers = data.split(",");

            List<Integer> parsedInt = new ArrayList<>();
            for (String number : numbers) {
                parsedInt.add(Integer.parseInt(number));
            }

            parsedInput.add(parsedInt);
        }

        return parsedInput;
    }

    public int[] solution(String s) {
        List<List<Integer>> parsedInput = parseStr(s);
        Collections.sort(parsedInput, (a,b)->{
            return Integer.compare(a.size(), b.size());
        });
        List<Integer> answer = new ArrayList<>();
        for(List<Integer> elements: parsedInput){
            for(Integer element: elements){
                if(answer.contains(element)){
                    continue;
                }
                answer.add(element);
                break;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}