<!--다시 한 번 풀어볼 것-->
# 문제 풀이

## 문제 해설

숫자 $n$의 약수 중 가장 큰 약수를 구하는 문제다. 즉, 2부터 $\sqrt{n}$까지 중에서 $n$을 나눌 수 있는 수들 중 가장 큰 수를 찾으면 된다. 이는 다음과 같이 구현할 수 있다.

```java
public long decompose(long num) {
    if (num <= 1L) return 0L;
    for (long i = 2L; i * i <= num; i++) {
        if (num % i == 0L) {
            return num / i;
        }
    }
    return 1L; // 나누어 떨어지는 수가 없으면 num은 소수
}
```

모든 약수를 찾지 않아도 $n / i$를 통해 바로 가장 큰 약수를 찾을 수 있다.

다만 문제가 되는 것은, 약수에 대한 크기의 제한이 있는 것이다. 문제의 조건에 따라 약수는 $10^7$보다 작거나 같아야 한다.

그러므로 다음과 같이 `temp` 리스트를 두고, 전체 약수를 저장하도록 수정이 필요하다.

```java
public long decompose(long num) {
    if (num <= 1L) return 0L;
    List<Long> temp = new ArrayList<>();
    for (long i = 2L; i * i <= num; i++) {
        if (num % i == 0L) {
            temp.add(i);
            if (num / i <= t) {
                return num / i;
            }
        }
    }
    if (temp.size() >= 1) {
        return temp.get(temp.size() - 1);
    }
    return 1L;  // 나누어 떨어지는 수가 없으면 num은 소수
}
```

도로의 최대 길이는 $10^9$이기 때문에, $\sqrt{10^9} < 10^7$이므로 `temp` 안에 존재하는 약수는 모두 $10^7$이하이다.

## 시간 복잡도

도로의 최대 길이를 $n$이라고 할 때, 시간 복잡도는 $O((begin-end) \times n)$이다.