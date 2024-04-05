# 문제 풀이

## 문제 해설 (테스트케이스 일부 통과 X)
0-1 Knapsack
1. 최소 피로도 - 소비 피로도 가 큰 순서 대로 정렬
2. 배열을 순회하며, 최소 피로도가 현재 피로도보다 높으면 answer + 1

## 시간 복잡도

### Sorting (DualPivotQuicksort 사용 평균O(nlogn, 최악 O(n^2) ) )
```java
   Arrays.sort(dungeons, new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
            if(o2[0]-o2[1] == o1[0]-o1[1]){
                return Integer.compare(o2[0],o1[0]);
            }
            return Integer.compare(o2[0]-o2[1], o1[0]-o1[1]);
        }
    });
```

### 배열 순회 O(n)
```java
    for(int[] data : dungeons){
        if(data[0] <= k){
            k = k - data[1];
            answer++;
        }
    }
```

## 결과
> 최악의 경우 Sorting에서 O(n^2)이 나올 수도 있다. 하지만 평균 시간 복잡도는 O(nlogn)이다.
>
> Sorting 후 배열을 순회하는데 O(n)이 걸린다.
>
> 최악의 경우 시간 복잡도는 O(n^2)이다.