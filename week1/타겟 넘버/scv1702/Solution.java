class Solution {
    int[] base = { 1, -1 };
    int answer = 0;
    
    public void dfs(int[] numbers, int source, int target, int depth) {
        if (depth == numbers.length) {
            if (source == target) {
                answer += 1;
            }
            return ;
        }
        dfs(numbers, source + base[0] * numbers[depth], target, depth + 1);
        dfs(numbers, source + base[1] * numbers[depth], target, depth + 1);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
}