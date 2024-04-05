# 문제 풀이

## 문제 해설

조합을 이용해 각 손님이 주문한 단품메뉴 조합에서 가능한 모든 경우에 대해 탐색을 하였다. 

## 시간 복잡도

`orders`의 길이를 $n$, `course`의 길이를 $m$이라고 할 때 각 `course`에 대해 `createCourse(orders, course)`를 수행한다. `createCourse()`는 각 `order`에 대해 `Combination`을 만드는데, 이는 $order \choose course$이다. `order`와 `course`의 범위는 2 ~ 10이기 때문에 `Combination`을 생성하는데 최악의 경우는 ${10 \choose 5} = 252$이다. 그러므로 이를 정리하면 $O(m\times n \times 252)$이다. 다만 이는 코드에서 중요한 연산에 대해서만 시간 복잡도를 구한 것이기 때문에 실제 시간 복잡도와 상수배 차이가 있을 수 있다.