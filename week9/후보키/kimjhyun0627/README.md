  # 문제 풀이

## 문제 해설

***combinations***

1. itertools의 combinations를 사용해 모든 키 조합을 구한다.
2. set 자료형을 통해 유일성을 비교하고, issubset()을 통해 최소성을 확인한 후 unique list에 append한다.
3. unique list의 길이를 반환한다.

## 시간 복잡도

$$O(2^{len(relation)})$$


