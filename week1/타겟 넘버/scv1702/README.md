# 문제 풀이

## 문제 해설

전형적인 완전 탐색 문제로 모든 경우의 대해 탐색을 하면서 타겟 넘버를 만들 수 있는 경우를 헤아리면 된다.

## 시간 복잡도

`numbers`의 길이를 `n`이라고 할때, 각 원소의 앞에 `+`가 오는 경우와 `-`가 오는 경우 모두에 대해서 탐색하므로 시간 복잡도는 `O(2^n)`이다.

```java
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
```