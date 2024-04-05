# 문제 풀이

## 문제 해설
1. 2차원 String 배열에 포함된 타입별 개수를 센다.
2. 타입별 개수 + 1을 모두 곱해서 - 1을 한다.
    1. Type + 1 :해당 Type을 착용하지 않는 경우를 추가.
    2. 곱한 값에 - 1 : Type들을 모두 착용하지 않는 경우 추가.

## 시간 복잡도
본 코드의 시간 복잡도를 계산해 주세요.

### Type별 개수 새기 O(n) [ n = Clothes의 개수 ]
```java
    for(String[] data: clothes){
        if(types.containsKey(data[1])){
            types.put(data[1], types.get(data[1]) + 1);
            continue;
        }
        types.put(data[1], 1);
    }
```

### Type별 개수 모두 곱하기 [ n = Clothes의 개수 ]
```java
    for(Integer value: types.values()){
        result *= value + 1;
    }
```

### 결과

> Type 별 개수 구하기는 O(n)으로 Clothes의 개수에 비례.
>
> Type 별 개수 모두 곱하기는 "모든 Clothes가 다른 type 일 때(최악)" O(n)
>
> 시간 복잡도는 O(n)이 된다.