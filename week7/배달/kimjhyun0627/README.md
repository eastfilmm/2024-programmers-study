  # 문제 풀이

## 문제 해설

***dijkstra 알고리즘***

*까먹어서 다시 공부했다*

1. 최종 거리 정보를 저장할 dist_map과 초기 그래프 정보를 저장할 graph list를 구현한다.
2. heapq를 통해 dijkstra 알고리즘을 구현한다. 1번에서 다른 곳으로 갈때의 가중치인 0을 heappush 해주고, 다른 마을들에 대해 현재 dist_map에 저장된 거리가 heappop한 거리보다 길다면 total을 계산하여 다음 마을로 가는 가중치가 최소인지 확인한다.

## 시간 복잡도

$$O(road * logN)$$


