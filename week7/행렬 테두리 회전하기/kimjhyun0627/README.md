  # 문제 풀이

## 문제 해설

***Brute Force, 노가다 및 머리깨기 문제***

1. matrix를 생성한다.
2. queries 속 범위들에 따라 heap에 테두리 수들을 저장하고 matrix를 움직인 후 heap의 가장 작은 값을 answer에 추가한다.

## 시간 복잡도

$$O(len(queries)*(nlogn)^2)$$


