import java.util.*;
class Solution {
    final int[][] directions = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    
    public int BFS(int[][] maps){
        int row = maps.length;
        int column = maps[0].length;
        int[][] visited = new int[row][column];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = 1;
        while(!queue.isEmpty()){
            int[] position = queue.remove();
            if(position[0] == row - 1 && position[1] == column -1 ) {
                return position[2];
            }
            for(int i = 0; i < 4; i++){
                int nextRow = position[0] + directions[i][0];
                int nextColumn = position[1] + directions[i][1];
                if( (-1 < nextRow && nextRow < row) && (-1 < nextColumn && nextColumn < column) ){
                    if(maps[nextRow][nextColumn] == 1 && visited[nextRow][nextColumn] != 1){
                        queue.add(new int[]{nextRow, nextColumn, position[2] + 1});
                        visited[nextRow][nextColumn] = 1;
                    }
                }
            }
        }
        
        return -1;
    }
    public int solution(int[][] maps) {
        int answer = BFS(maps);
        return answer;
    }
}