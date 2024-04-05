import java.util.*;

class Solution {
    public boolean checkPrefix(String str1, String str2, int str1Len, int str2Len)
    {
        if(str2.startsWith(str1)) {
            return true;
        }
        return false;
    }
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        //Sorting With Length
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        for(int i = 0; i < phone_book.length - 1 && answer; i++){

            //만약 앞으로 비교할 전화번호의 길이가 같으면 break
            if(phone_book[i].length() ==
                    phone_book[phone_book.length - 1].length()){
                break;
            }

            //긴 번호부터 비교.
            for(int j = phone_book.length - 1 ; j > i && answer; j--){
                int str1Len = phone_book[i].length();
                int str2Len = phone_book[j].length();

                //같은 길이가 나오면 break
                if(str1Len == str2Len){
                    break;
                }

                if(checkPrefix(phone_book[i], phone_book[j], str1Len, str2Len)){
                    answer = false;
                }
            }
        }

        return answer;
    }
}