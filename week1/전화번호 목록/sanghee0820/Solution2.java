import java.util.*;

class Solution {
    public boolean checkPrefix(String str1, String str2)
    {
        if(str2.startsWith(str1)) {
            return true;
        }
        return false;
    }
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        //Sorting With char
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1 && answer; i++){
            if(checkPrefix(phone_book[i], phone_book[i+1])){
                answer = false;
            }
        }

        return answer;
    }
}