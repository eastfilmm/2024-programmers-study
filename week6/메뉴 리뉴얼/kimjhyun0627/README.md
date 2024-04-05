  # 문제 풀이

## 문제 해설


***combination 및  Counter dict 자료형***

1. combinations()를 통해 중복조합을 구한다.
2. Counter()를 통해 각 조합에 대한 빈도수를 계산한다.
3. dictonary 자료형을 {코스 메뉴 수:[빈도수]}로 초기화한다.
4. Counter를 순회하며 코스 메뉴 수에 해당하는 빈도수가 같다면 dictionary의 item에 추가학고, 빈도수가 더 많다면 item을 교체한다.
5. dictonary의 item[0]를 제외한 값을 answer에 넣고 정렬해 출력한다. 

## 시간 복잡도
$$O(o * c)$$

