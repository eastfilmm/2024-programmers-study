import java.util.*;

class Solution {
    class File {
        String head;
        Integer number;
        
        File(String file) {
            slice(file);
        }
        
        private void slice(String f) {
            int i = 0;
            StringBuilder head = new StringBuilder();
            while (i < f.length() && !Character.isDigit(f.charAt(i))) {
                head.append(Character.toLowerCase((f.charAt(i++))));
            }
            this.head = head.toString();
            StringBuilder number = new StringBuilder();
            while (i < f.length() && Character.isDigit(f.charAt(i))) {
                number.append(f.charAt(i++));
            }
            this.number = Integer.parseInt(number.toString());
        }
    }
    
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                File f1 = new File(s1);
                File f2 = new File(s2);
                if (f1.head.compareTo(f2.head) != 0) {
                    return f1.head.compareTo(f2.head);
                }
                return f1.number.compareTo(f2.number);
            }
        });
        return files;
    }
}