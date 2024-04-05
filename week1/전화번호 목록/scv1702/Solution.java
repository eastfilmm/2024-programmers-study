import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Map<String, String> map = new HashMap<>();
        Arrays.sort(phoneBook, (String s1, String s2) -> s1.length() - s2.length());
        for (String phone: phoneBook) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < phone.length(); i++) {
                String key = sb.append(phone.charAt(i)).toString();
                if (map.containsKey(key)) {
                    return false;
                }
            }
            map.put(phone, phone);
        }
        return true;
    }
}