  # 문제 풀이

## 문제 해설

***효율성***

*흑흑*

1. info 와 query를 split해준다.
2. defaultdict와 product를 사용하여 모든 경우의 수를 딕셔너리에 넣는다.
3. bisect_left(처음봄)를 사용하여 이진 탐색하여 주어진 query에 있는 값들의 개수를 추가해준다.



## 시간 복잡도

$$O(len(info)*len(query))$$

