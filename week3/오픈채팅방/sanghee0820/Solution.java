import java.util.*;
class Solution {
    private final String[] OUTPUT_DESC = {"님이 들어왔습니다.", "님이 나갔습니다."};
    
    
    private Map<String, String> nameMap = new HashMap<>();
    private Map<String, List<List<Integer>> > recordMap = new HashMap<>();
    
    public String[] solution(String[] records) {
        int count = 0;
        for(int i = 0; i < records.length; i++){
            String record = records[i];
            // [0] = Type [1] = UID, [2] = NickName
            String[] parsedRecord = record.split(" ");
            
            if(parsedRecord[0].equals("Enter")){
                if(!nameMap.containsKey(parsedRecord[1])){
                    recordMap.put(parsedRecord[1], new ArrayList<List<Integer>>());
                }
                
                nameMap.put(parsedRecord[1], parsedRecord[2]);
                recordMap.get(parsedRecord[1]).add(
                                  Arrays.asList(count, 0));
                count++;
                continue;
            
            }
            if(parsedRecord[0].equals("Leave")){
                recordMap.get(parsedRecord[1]).add(
                                  Arrays.asList(count, 1));
                
                count++;
                continue;
            
            }
            if(parsedRecord[0].equals("Change")){
                nameMap.put(parsedRecord[1], parsedRecord[2]);
            }
        }
        
        String[] answer = new String[count];
        for(String key : recordMap.keySet()){
            List<List<Integer>> descs = recordMap.get(key);
            for(List<Integer> desc : descs){
                answer[desc.get(0)] = nameMap.get(key).concat(OUTPUT_DESC[desc.get(1)]);
            }
        }
        
        return answer;
    }
}