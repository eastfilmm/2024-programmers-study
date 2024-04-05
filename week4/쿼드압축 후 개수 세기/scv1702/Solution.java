class Solution {
    int one = 0;
    int zero = 0;
    
    public void count(int[][] arr, int r, int c) {
        if (arr[r][c] == 0) {
            zero += 1;
        }
        if (arr[r][c] == 1) {
            one += 1;
        }
    }
    
    public void helper(int[][] arr, int r, int c, int n) {
        if (n == 1) {
            count(arr, r, c);
            return ;
        }
        boolean flag = true;
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[r][c] != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            count(arr, r, c);
            return ;
        }
        helper(arr, r, c, n / 2);
        helper(arr, r, c + n / 2, n / 2);
        helper(arr, r + n / 2, c, n / 2);
        helper(arr, r + n / 2, c + n / 2, n / 2);
    }
    
    public int[] solution(int[][] arr) {
        helper(arr, 0, 0, arr.length);
        int[] answer = new int[2];
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
}