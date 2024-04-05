class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int arr1RowIdx = 0; arr1RowIdx < arr1.length; arr1RowIdx++){
            for(int arr1ColIdx = 0; arr1ColIdx < arr1[arr1RowIdx].length; arr1ColIdx++){
                for(int arr2ColIdx = 0; arr2ColIdx < arr2[0].length; arr2ColIdx++){
                    answer[arr1RowIdx][arr2ColIdx] += arr1[arr1RowIdx][arr1ColIdx] * arr2[arr1ColIdx][arr2ColIdx];
                }
            }
        }
        return answer;
    }
}