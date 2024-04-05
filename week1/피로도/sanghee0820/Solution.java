import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        Arrays.sort(dungeons, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o2[0]-o2[1] == o1[0]-o1[1]){
                    return Integer.compare(o2[0],o1[0]);
                }
                return Integer.compare(o2[0]-o2[1], o1[0]-o1[1]);
            }
        });

        int answer = 0;
        for(int[] data : dungeons){
            if(data[0] <= k){
                k = k - data[1];
                answer++;
            }
        }
        return answer;
    }
}