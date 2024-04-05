import java.util.*;

class Solution {
    static int[][] line1 = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0},
    };
    
    static int[][][] diagonal1 = {
        {{1, 1}, {0, 1}, {1, 0}},
        {{1, -1}, {1, 0}, {0, -1}},
        {{-1, -1}, {0, -1}, {-1, 0}},
        {{-1, 1}, {-1, 0}, {0, 1}}
    };
    
    static int[][][] line2 = {
        {{0, 2}, {0, 1}}, 
        {{2, 0}, {1, 0}}, 
        {{-2, 0}, {-1, 0}}, 
        {{0, -2}, {0, -1}}
    };
    
    public boolean isValidBoundary(int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }
    
    public int predicate(char[][] matrix) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (matrix[r][c] == 'P') {
                    // 거리가 1인 직선에는 사람이 존재하면 안된다.
                    for (int[] d: line1) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (isValidBoundary(nr, nc) && matrix[nr][nc] == 'P') {
                            return 0;
                        }
                    }
                    // 대각선에 사람이 있으면 파티션이 있어야한다.
                    for (int[][] diagonal: diagonal1) {
                        int nr = r + diagonal[0][0];
                        int nc = c + diagonal[0][1];
                        int pr1 = r + diagonal[1][0];
                        int pc1 = c + diagonal[1][1];
                        int pr2 = r + diagonal[2][0];
                        int pc2 = c + diagonal[2][1];
                        if (isValidBoundary(nr, nc) && matrix[nr][nc] == 'P') {
                            if ((isValidBoundary(pr1, pc1) && matrix[pr1][pc1] != 'X') ||
                                (isValidBoundary(pr2, pc2) && matrix[pr2][pc2] != 'X')) {
                                return 0;
                            }
                        }
                    }
                    // 거리가 2인 직선에 사람이 있으면 파티션이 있어야 한다.
                    for (int[][] line: line2) {
                        int nr = r + line[0][0];
                        int nc = c + line[0][1];
                        int pr1 = r + line[1][0];
                        int pc1 = c + line[1][1];
                        if (isValidBoundary(nr, nc) && matrix[nr][nc] == 'P') {
                            if (isValidBoundary(pr1, pc1) && matrix[pr1][pc1] != 'X') {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
    
    public List<Integer> solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        for (String[] place: places) {
            char[][] matrix = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    matrix[i][j] = place[i].charAt(j);
                }
            }
            answer.add(predicate(matrix));
        }
        return answer;
    }
}