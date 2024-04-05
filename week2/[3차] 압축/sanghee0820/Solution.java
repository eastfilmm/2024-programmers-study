import java.util.*;
class Solution {
    public HashMap<String, Integer> secretCode;
    public Integer valueCnt;
    
    public void initSecretCode(){
        secretCode = new HashMap<>();
        for(char code = 'A'; code <= 'Z'; code++){
            secretCode.put(String.valueOf(code), code - 'A' + 1);
        }
        valueCnt = 26;
    }
    
    public List<Integer> toSecretCode(String msg){
        List<Integer> secret = new ArrayList<>();

        for(int index = 1; index-1 < msg.length(); ){
            
            String subMsg = String.valueOf(msg.charAt(index - 1));
            
            while(secretCode.containsKey(subMsg) 
                  && index < msg.length() ){
                subMsg += String.valueOf(msg.charAt(index++));
            }

            if(index == msg.length() ) {
                if(secretCode.containsKey(subMsg)){
                    secret.add(secretCode.get(String.valueOf(subMsg)));
                }
                else{
                    secret.add(secretCode.get(subMsg.substring(0, subMsg.length() - 1)));
                    secret.add(secretCode.get(String.valueOf(msg.charAt(msg.length() - 1))));
                }
                break;
            }
            
            secret.add(secretCode.get(subMsg.substring(0, subMsg.length() - 1)));
            secretCode.put(subMsg, ++valueCnt);
        }
        
        return secret;
    }
    public List<Integer> solution(String msg) {
        initSecretCode();
        List<Integer> test = toSecretCode(msg);
        return test;
    }
}