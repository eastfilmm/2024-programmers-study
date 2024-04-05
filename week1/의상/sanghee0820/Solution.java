import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> types = new HashMap<>();

        for(String[] data: clothes){
            if(types.containsKey(data[1])){
                types.put(data[1], types.get(data[1]) + 1);
                continue;
            }
            types.put(data[1], 1);
        }

        int result = 1;
        for(Integer value: types.values()){
            result *= value + 1;
        }
        return result - 1;
    }
}