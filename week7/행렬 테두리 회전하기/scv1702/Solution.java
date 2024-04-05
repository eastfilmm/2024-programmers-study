import java.util.*;

class Solution {
    public int rotate(int[][] matrix, int[] query) {
        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;
        
        int temp = matrix[r1][c1];
        int result = temp;
        
        for (int r = r1; r < r2; r++) {
            result = Math.min(result, matrix[r + 1][c1]);
            matrix[r][c1] = matrix[r + 1][c1];
        }
        
        for (int c = c1; c < c2; c++) {
            result = Math.min(result, matrix[r2][c + 1]);
            matrix[r2][c] = matrix[r2][c + 1];
        }
        
        for (int r = r2; r > r1; r--) {
            result = Math.min(result, matrix[r - 1][c2]);
            matrix[r][c2] = matrix[r - 1][c2];
        }
        
        for (int c = c2; c > c1 + 1; c--) {
            result = Math.min(result, matrix[r1][c - 1]);
            matrix[r1][c] = matrix[r1][c - 1];
        }
        
        matrix[r1][c1 + 1] = temp;
        
        return result;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + (j + 1);
            }
        }
        for (int[] query: queries) {
            answer.add(rotate(matrix, query));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}