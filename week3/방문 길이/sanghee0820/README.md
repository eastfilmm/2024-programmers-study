# 문제 풀이

## 문제 해설
1. 입력값을 칸 기준으로 파싱
2. 파싱된 입력값을 순회하며, 이미 방문한 선을 Map의 키로 넣고 방문표시
   1. 만약 방문하지 않았다면 결과값 추가
## 시간 복잡도

1. 입력값 순회 O(n)
```java
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
```
## 결과

> 입력값을 순회하며, Map의 key에 넣고 확인하는 과정은 최대 O(n)이 소모된다.