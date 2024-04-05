class Solution {
    static int[][] dirs = {
        {0, 1}, //right
        {1, 1}, //right-down
        {1, 0}, //down
        {1, -1}, //left-down
        {0, -1}, //left
        {-1, -1}, //left-up
        {-1, 0}, //up
        {-1, 1}, //right-up
    };
    
    int answer = 0;
    
    public boolean isEqual(char[][] game, String[] board) {
        int n = game.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[i][j] != board[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int count(char[][] game, int i, int j, int dir) {
        int result = 0;
        int n = game.length;
        char stone = game[i][j];
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (game[i][j] == stone) {
                result += 1;
            }
            i += dirs[dir][0];
            j += dirs[dir][1];
        }
        return result;
    }
    
    public boolean isGameOver(char[][] game, int i, int j) {
        if (count(game, i, j, 0) + count(game, i, j, 4) >= 4) {
            return true;
        }
        if (count(game, i, j, 1) + count(game, i, j, 5) >= 4) {
            return true;
        }
        if (count(game, i, j, 2) + count(game, i, j, 6) >= 4) {
            return true;
        }
        if (count(game, i, j, 3) + count(game, i, j, 7) >= 4) {
            return true;
        }
        return false;
    }
    
    public void play(char[][] game, String[] board, int round, int step) {
        int n = game.length;
        
        if (answer == 1) {
            return ;
        }
        
        if (step >= round) {
            if (isEqual(game, board)) {
                answer = 1;
            }
            return ;
        }
        
        char stone = 'O';
        if (step % 2 != 0) {
            stone = 'X';
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[i][j] == '.') {
                    game[i][j] = stone;
                    if (!isGameOver(game, i, j) || step >= round - 1) {
                        play(game, board, round, step + 1);
                    }
                    game[i][j] = '.';
                }
            }
        }
    }
    
    public int solution(String[] board) {
        int count = 0;
        int n = board.length;
        char[][] game = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) != '.') {
                    count += 1;
                }
                game[i][j] = '.';
            }
        }
        
        play(game, board, count, 0);
        
        return answer;
    }
}