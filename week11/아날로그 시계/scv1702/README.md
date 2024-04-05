# 문제 풀이

## 문제 해설

초침은 1초에 6도를, 분침은 1초에 1/10도를, 시침은 1초에 1/120도를 돈다. 각 침의 현재 각도를 $ds$, $dm$, $dh$라고 하자. 각 침이 $t$초 동안 움직였을 때 현재 각도는 다음과 같다.

$$ ds_t = (ds_0 + t \times 6) \mod 360 $$
$$ dm_t = (dm_0 + t \times (1/10)) \mod 360$$
$$ dh_t = (dh_0 + t \times (1/120)) \mod 360$$

초침과 시침이 충돌하는 시각을 $t'$라고 하자. 그러면 초침과 시침의 현재 각도가 동일하기 때문에 다음과 같이 식을 도출할 수 있다.

$$ ds_{t'} = dh_{t'} $$
$$ t' \times 6  \equiv t' \times (1/120) \mod 360$$
$$ t' \times (6 - 1/120) = 360k$$ 
$$ t' = \frac{360k}{(6 - 1/120)}$$

이때 $k$는 임의의 정수이다. 그런데 $t'$에 대한 조건이 주어지기 때문에(시작 시각과 종료 시각), 조건을 만족하는 $k$의 개수가 초침과 시침이 충돌하는 횟수가 된다. 분침의 경우에도 비슷한 방법을 통해 식을 도출할 수 있다.

이때 중요한 점은 초침이 시침, 분침과 동시에 충돌하는 경우이다. 위 두 식에 대한 답을 단순히 더하게 되면 해당 경우가 중복되기 때문에 이를 고려해야 한다. 본인은 `HashSet`을 통해 고려하였다.

```java
Set<Long> answer = new HashSet<>();
        
double start = toSeconds(h1, m1, s1);
double end = toSeconds(h2, m2, s2);

for (double k = 0f; 360 * k / (diff[0] - diff[1]) <= end + EPSILON; k++) {
    double t = 360 * k / (diff[0] - diff[1]);
    if (t >= start) {
        answer.add((long) (t * PRECISION));   
    }
}

for (double k = 0f; 360 * k / (diff[0] - diff[2]) <= end + EPSILON; k++) {
    double t = 360 * k / (diff[0] - diff[2]);
    if (t >= start) {
        answer.add((long) (t * PRECISION));  
    }
}
```

가장 어려웠던 점은 부동소수점을 처리하는 일이였다. `HashSet`에 원소를 추가할 때 자바는 `hashCode()`를 이용하는데, 부동소수점의 끝자리가 조금이라도 다른 경우 중복으로 처리되지 않기 때문이다. 그래서 특정 값을 곱하고 `Long`으로 형변환을 하여 특정 소수점 이하의 경우는 무시되도록 하였다. 또한 부동소수점의 값을 비교하는 경우에도 `EPSILON`을 이용해 특정 오차 범위 내일 경우 `true`가 되도록 하였다.

## 배운 점

$a \equiv b \mod c$인 경우 $a - b = c \times k$ (단, $k$는 임의의 정수)이다. 

## 시간 복잡도

이번 경우에는 전체 시간 복잡도를 정확히 계산하기 어렵기 때문에, 단순하게 $O(end)$라고 구하겠다.