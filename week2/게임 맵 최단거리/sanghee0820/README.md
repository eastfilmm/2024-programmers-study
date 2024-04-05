# 문제 풀이

## 문제 해설
1. 완전탐색(BFS)

## 시간 복잡도
1. BFS O(n * m) n = row, m = column의 개수
```java
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
```
## 결과

> BFS를 사용해 시간복잡도는 O(n*m)이다.