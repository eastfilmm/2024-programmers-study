import java.util.*;
class Solution {
    private Map<Integer, Integer> preesed = new HashMap<>();
    public int[] solution(int[][] arr) {
        quardPress(arr);
        
        return new int[]{preesed.getOrDefault(0, 0), preesed.getOrDefault(1, 0)};
    }
    
    public void quardPress(int[][] arr){
        boolean zeroFlag = false;
        boolean oneFlag = false;
        boolean flag = false;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(oneFlag && zeroFlag){
                    flag = true;
                    break;
                }
                if(arr[i][j] == 1){
                    oneFlag = true;
                    continue;
                }
                zeroFlag = true;
            }
            if(oneFlag && zeroFlag){
                flag = true;
                break;
            }
        }
        if(!flag){
            if(zeroFlag){
                preesed.put(0, preesed.getOrDefault(0, 0) + 1);
                return;
            }
            preesed.put(1, preesed.getOrDefault(1, 0) + 1);
            return;
        }
        int[][] topLeft = new int[arr.length/2][arr.length/2];
        int[][] topRight = new int[arr.length/2][arr.length/2];
        int[][] bottomLeft = new int[arr.length/2][arr.length/2];
        int[][] bottomRight = new int[arr.length/2][arr.length/2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i < arr.length/2 && j < arr.length/2) {
                    topLeft[i][j] = arr[i][j];
                } else if (i < arr.length/2) {
                    topRight[i][j - arr.length/2] = arr[i][j];
                } else if (j < arr.length/2) {
                    bottomLeft[i - arr.length/2][j] = arr[i][j];
                } else {
                    bottomRight[i - arr.length/2][j - arr.length/2] = arr[i][j];
                }
            }
        }
        quardPress(topLeft);                                      
        quardPress(topRight);                                    
        quardPress(bottomLeft);                                   
        quardPress(bottomRight);
    }
}