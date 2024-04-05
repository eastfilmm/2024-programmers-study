# 문제 풀이

## 문제 해설

1. 모든 스킬트리를 순회하며, 스킬순서 대로 스킬트리를 배웠는지 확인.
## 시간 복잡도

1. 스킬트리 순회하며, 스킬 배웠는지 확인 O(n * m)
```java
    for(String skill_tree : skill_trees){
        boolean flag = true;
        int skillCnt = 0;
        for(int j = 0; j < skill_tree.length(); j++){
            if(!skill.contains(String.valueOf(skill_tree.charAt(j)))){
                continue;
            }
            if(skill_tree.charAt(j) == skill.charAt(skillCnt++)){
                continue;
            }
            flag = false;
            break;
        }
        if(flag){
            answer++;
        }
    }

```
## 결과

> 최악의 경우 모든 스킬트리와, 스킬순서를 순회하므로
> 
> 최대 O(N * M)이 소모된다.