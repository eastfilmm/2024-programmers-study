  # 문제 풀이

## 문제 해설

***dfs***

1. 노드가 연결되었는지 확인하는 함수를 만든다.
2. dfs 재귀함수를 구현한다. 이때 visited를 list로 만들지 않고 dictionary로 구현하여 편의성을 높인다. target과 같다면 answers list에 depth를 apped하고, 이미 방문한 단어라면 더 적은 깊으로의 변환을 꾀하고, 방문하지 않았다면 visited dictionary에 추가해준다. 이후 나머지 words를 순회하며 재귀적으로 함수를 이어나간다.
생성된 answers list, 즉 가능한 모든 경로 중 최소를 반환한다.

## 시간 복잡도

$$O(words^2*log(words))$$

