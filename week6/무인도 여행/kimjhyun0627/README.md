  # 문제 풀이

## 문제 해설

***DFS***

1. 방향성을 지정해주고(dx, dy), visited list를 생성한다.
2. DFS를 수행한다. 바다가 아니고 방문하지 않은 땅이 있다면 days를 0으로 초기화하고 queue에 해당 위치를 append한다. 그 후 방향성을 바탕으로 주변 땅을 탐색한 후 days를 answer에 append한다.

## 시간 복잡도

$$O(n*m)$$
