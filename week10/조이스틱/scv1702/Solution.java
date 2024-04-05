class Solution {

    public int change(char c) {
        return Math.min('Z' - c + 1, c - 'A');
    }

    public int solution(String name) {
        int n = name.length();
        int upDown = 0;
        int leftRight = n - 1;
        
        for (int i = 0; i < n; i++) {
            upDown += change(name.charAt(i));
            
            int index = i + 1;
            while (index < n && name.charAt(index) == 'A') {
                index += 1;
            }
            
            leftRight = Math.min(leftRight, i * 2 + n - index);
            leftRight = Math.min(leftRight, (n - index) * 2 + i);
        }
        
        return upDown + leftRight;
    }
}