# 문제 풀이

## 문제 해설

처음에는 본 문제를 주어진 `skillTree`가 올바른 위상 정렬 중 하나인지 판단하는 문제로 생각했다. 그러나 데이터 크기가 그렇게 크지 않아서 단순한 문자열 처리 문제/구현 문제로 생각하고 풀었다. 

주어진 `skillTree`에서 `skill`에 존재하지 않는 스킬을 모두 제외한 문자열을 `filtered`라고 할때, `skill`이 `filtered`로 시작하는지 판단하면 된다.

## 시간 복잡도

`skill`의 길이를 $n$이라고 하자. `filtered`의 최대 길이는 $n$이다. `skillTrees`의 길이를 $m$이라고 하자.

`filter()`은 `skillTree`의 각 문자가 `skill`에 등장 여부에 대해 탐색하기 때문에, $O(n^2)$이 소요된다. `isValidSkillTree()`는 `filter()`와 `startsWith()`를 호출하는데 `startsWith()`가 $O(n)$이므로 $O(n^2)$이다.

이를 각 `skillTree`에 대해서 반복하므로 전체 시간 복잡도는 $O(m\times n^2)$이다.

```java
import java.util.*;

class Solution {
    public String filter(String skill, String skillTree) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < skillTree.length(); i++) {
            char c = skillTree.charAt(i);
            if (skill.indexOf(c) >= 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public boolean isValidSkillTree(String skill, String skillTree) {
        String filtered = filter(skill, skillTree);
        return skill.startsWith(filtered);
    }
    
    public int solution(String skill, String[] skillTrees) {
        int answer = 0;
        for (String skillTree: skillTrees) {
            if (isValidSkillTree(skill, skillTree)) {
                answer += 1;
            }
        }
        return answer;
    }
}
```