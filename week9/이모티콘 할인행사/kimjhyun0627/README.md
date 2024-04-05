  # 문제 풀이

## 문제 해설

***product로 완전 탐색하기***

*이게 되네*

1. itertools의 product를 사용해 이모티콘 별 가능한 모든 할인 경우의 수를 discounts list에 저장한다.
2. 반복문을 순회하며 모든 경우를 탐색한다.
3. 정렬한 후 가장 회원이 많고 수입이 큰 경우를 반환한다.

## 시간 복잡도

$$O(4^{len(emoticons)}*len(users)*len(emoticons))$$
