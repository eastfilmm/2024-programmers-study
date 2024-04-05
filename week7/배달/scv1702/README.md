# 문제 풀이

## 문제 해설

다익스트라 알고리즘을 이용하면 가중치가 양수인 그래프의 최단 거리를 구할 수 있다. 다익스트라는 시작 정점부터 거리를 저장하는 `distances`에서 가장 최소값을 가진 정점을 탐색하는데, 이를 선형 탐색으로 구현하면 $O(N^2)$이고, 우선순위 큐를 사용하도록 구현하면 $O(N\log{N})$이다. 우선순위 큐는 최소값/최대값을 $O(\log{N})$에 구할 수 있다.

## 참고할 것

`java.util.Comparator.comparing` 정적 메소드를 이용하면 `Comparator` 익명 클래스를 직접 만들지 않고 우선순위 큐에서 정렬 기준을 쉽게 정할 수 있다.

```java
class Pair {
    int distance;
    int node;
    
    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
    
    int getDistance() {
        return this.distance;
    }
    
    @Override
    public String toString() {
        return String.format("node = %d, distance = %d", node, distance);
    }
}

PriorityQueue<Pair> pq = new PriorityQueue<>(comparing(Pair::getDistance));
```

위 코드는 우선순위 큐를 `Pair` 클래스의 `Pair.distance`를 오름차순으로 정렬한다. `Pair::getDistance`와 같이 메소드 참조를 이용하면 더 간략하게 코드를 작성할 수 있다.

`PriorityQueue`는 Natural Ordering이 기본 값이기 때문에 내림차순으로 정렬하고 싶다면 `comparing(...).reversed()`를 하면 된다.

## 시간 복잡도

위에서 서술한 대로 $O(N\log{N})$이다.
