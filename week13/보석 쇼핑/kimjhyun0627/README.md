  # 문제 풀이

## 문제 해설

***슬라이딩 윈도우***

1. defaultdict를 선언한다.
2. start를 순회한다. 모든 보석이 다 들어갈 때까지 end를 늘리고, 보석이 다 들어갔다면 길이를 비교하여 더 작다면(작거나 같으면 안됨) answer와 길이를 update한다. 이후 start지점의 gem 하나를 defaultdict에서 빼주고, 해당 gem이 0개라면 defaultdictd에서 없애준다.

## 시간 복잡도

$$O(len(gems)^2)$$

