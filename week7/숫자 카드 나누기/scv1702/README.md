# 문제 풀이

## 문제 해설

`arrayA`와 `arrayB` 각각에 대한 최대공약수를 구한 뒤, 해당 최대 공약수가 조건을 만족하는지 검사하고 가장 큰 값을 반환하면 된다. 두 정수의 최대공약수를 구하는 방법은 유클리드 호제법을 사용하면 되는데, 이를 배열로 확장하려면 다음과 같이 `reduce`를 하면 된다.

```java
public int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

public int gcd(int[] array) {
    return Arrays.stream(array).reduce(array[0], Solution::gcd);
}
```    

## 개선 사항

처음에는 최대공약수의 약수, 즉 배열의 모든 공약수들 중 조건을 만족하는 최대값을 찾았다. 왜냐하면 최대공약수만 검사했을 때 답이 없는 반례가 있을 것이라고 생각했는데.. 최대공약수만 했을 때 통과가 되는 이유는 아직 잘 모르겠다. 수학적인 증명이 필요할 것 같다.

## 시간 복잡도

유클리드 호제법의 시간 복잡도는 두 정수 $A, B (A \geq B)$에 대해 $O(\log(A))$이다. 이를 전체 배열에 대해서 수행하므로 $O(N \times \log(max(max(arrayA), max(arrayB))))$이다.
