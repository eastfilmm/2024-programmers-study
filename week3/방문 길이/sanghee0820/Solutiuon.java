import java.util.*;
class Solution {
    public final int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int[] getDirection(String dirChar){
        switch(dirChar){
            case ("U"):
                return directions[2];
            case ("D"):
                return directions[3];
            case ("R"):
                return directions[0];
            case ("L"):
                return directions[1];
            default:
                return null;
        }
    }
    public String buildKey(int[] pos1, int[] pos2) {
        return "" + pos1[0] + pos2[0] + pos1[1] + pos2[1];
    }
    
    public int solution(String dirs) {
        int answer = 0;
        String[] splitedDirs = dirs.split("");
        int[] position = {0,0};
        Map<String, Boolean> visited = new HashMap<>();
        for(String str : splitedDirs){
            
            int[] nextDirection = getDirection(str);
            int[] nextPosition = {position[0] + nextDirection[0], position[1] + nextDirection[1]};
            if((-6 < nextPosition[0] && nextPosition[0] < 6) && (-6 < nextPosition[1] && nextPosition[1] < 6)){
                String key1 = buildKey(position, nextPosition);
                String key2 = buildKey(nextPosition, position);
                
                if(!visited.containsKey(key1) && !visited.containsKey(key2) ){
                    visited.put(key1, true);
                    visited.put(key2.toString(), true);
                    answer++;
                }
                
                position = nextPosition;
            }
        }
        return answer;
    }
}