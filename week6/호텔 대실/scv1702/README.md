# 문제 풀이

## 문제 해설

주어진 `book_time`에 대해 전처리를 하여 `times` 배열을 만든 뒤 각 대실의 시작 시간에 대해 정렬을 한 뒤 시뮬레이션을 하였다. 대실의 시작 시간 순으로, 대실을 하려고 할 때 호텔 객실을 의미하는 `PriorityQueue<Integer> rooms`에서 빈 객실이 없으면(`rooms.peek() > 현재 대실의 시작 시간` 또는 `rooms.isEmpty()`) `rooms.offer(현재 대실의 종료 시간 + 청소 시간)`을 통해 새로운 객실을 대여해주고 빈 객실이 있으면 해당 객실을 대여(`rooms.poll()` 후 `rooms.offer()`)해준다. `rooms`는 각 대실의 종료 시간에 대해 정렬되어 있기 때문에 `rooms.peek()`을 통해 가장 빨리 끝나는 대실의 종료 시간을 확인할 수 있다.

## 시간 복잡도

`book_time`의 길이를 $n$이라고 하자. `times`를 정렬하는데 $O(n\log(n))$이 걸린다. 또한 각 `times[i]`에 대해 객실을 대여해주는데 $O(\log(n))$이 걸리기 때문에(`PriorityQueue`의 `poll()` 또는 `offer()`의 시간 복잡도) 모든 `times`에 대해 객실을 대여하는데 $O(n\log(n))$이 걸리므로 전체 시간 복잡도는 $O(n\log(n))$이다.