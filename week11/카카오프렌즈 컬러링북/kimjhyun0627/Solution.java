import java.util.*;

class Solution {

    static ArrayList<Integer> arr;
    
    static int[][] map;
    static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {

        map = new int[m][n];
        visited = new boolean[m][n];
        arr = new ArrayList<>();

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                map[i][j] = picture[i][j];
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] != 0 && !visited[i][j]){
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        int[] answer = new int[2];
        Collections.sort(arr, Collections.reverseOrder());
        int numberOfArea = arr.size();
        int maxSizeOfOneArea = arr.get(0);
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void bfs(int x, int y){

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0 ,0, -1, 1};
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));

        int color = map[x][y];
        int cnt = 0;

        while(!queue.isEmpty()){

            Pair next = queue.poll();
            int nx = next.x;
            int ny = next.y;
            cnt++;
            for (int d = 0; d < 4; d++){

                int nextX = nx + dx[d];
                int nextY = ny + dy[d];
                if (nextX < map.length && nextY < map[0].length && nextX >= 0 && nextY >= 0 && map[nextX][nextY] != 0 && !visited[nextX][nextY]){
                    if (color == map[nextX][nextY]){
                        queue.offer(new Pair(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        arr.add(cnt);
    }

    public static class Pair{
        int x = 0;
        int y = 0;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}