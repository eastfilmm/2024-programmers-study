# 문제 풀이

## 문제 해설

2차원 배열을 정렬한 뒤 문제의 조건에 따라 계산하면 된다.

## 참고

람다식을 이용하면 `Comparator` 익명 클래스를 만들지 않고 쉽게 정렬할 수 있다.

```java
Arrays.sort(data, (a, b) -> {
    int base = col - 1;
    if (a[base] - b[base] != 0) {
        return a[base] - b[base];
    }
    return b[0] - a[0];
});
```

## 시간 복잡도

행 크기를 $R$, 열 크기를 $C$라고 하자. 정렬은 $O(R\times \log(R))$이다. `modSum()`은 한 번 수행하는데 $O(C)$이다. 그러므로 전체 시간 복잡도는 $O(R\times \log(R) + R \times C)$