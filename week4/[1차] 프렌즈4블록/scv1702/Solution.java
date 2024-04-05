import java.util.*;

class Solution {
    private static int[][] dirs = {
        {0, 1}, {1, 0}, {1, 1}
    };
    
    private Set<Integer> check(int m, int n, char[][] board) {
        Set<Integer> checked = new HashSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] != '\0') {
                    int t = 1;
                    for (int[] dir: dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                            && board[r][c] == board[nr][nc]
                           ) {
                            t += 1;
                        }
                    }
                    if (t == 4) {
                        checked.add(r * n + c);
                        for (int[] dir: dirs) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            checked.add(nr * n + nc);
                        }
                    }
                }
            }
        }
        return checked;
    }
    
    private void resolve(int m, int n, char[][] board, Set<Integer> checked) {
        List<TreeSet<Integer>> rows = new ArrayList<>();
        for (int c = 0; c < n; c++) {
            rows.add(new TreeSet<>());
        }
        for (Integer i: checked) {
            int r = i / n;
            int c = i % n;
            board[r][c] = '\0';
            rows.get(c).add(r);
        }
        for (int c = 0; c < n; c++) {
            for (int r = m - 1; r >= 0; r--) {
                if (board[r][c] != '\0' 
                    && rows.get(c).size() > 0 
                    && r < rows.get(c).last()) {
                    int nr = rows.get(c).pollLast();
                        board[nr][c] = board[r][c];
                        board[r][c] = '\0';
                        rows.get(c).add(r);
                }
            }
        }
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] blocks = new char[m][n];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }
        
        for (Set<Integer> checked = check(m, n, blocks); 
             checked.size() > 0; 
             checked = check(m, n, blocks)) {
            resolve(m, n, blocks, checked);
            answer += checked.size();
        } 
        
        return answer;
    }
}