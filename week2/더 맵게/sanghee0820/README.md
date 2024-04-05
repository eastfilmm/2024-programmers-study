# 문제 풀이

## 문제 해설
1. int[]형을 List<Integer>로 변환.
2. 모든값들을 PriorityQueue에 넣고 작은값부터 remove.
    1. 계산한값을 PriorityQueue에 다시 넣음.

## 시간 복잡도

1. PriorityQueue에 값을 빼기(값을 제거하고 다시 재정렬) O(log(n)), 넣기 O(log(n)).
```java
    while((first = pq.remove()) < K){
        if(pq.isEmpty()){
            answer = -1;
            break;
        }
        second = pq.remove();
        pq.add(first + (second*2));
        answer++;
        
    }
```
## 결과

> while문 한번이 돌 때마다 PQ의 크기는 1씩 줄어든다.
>
> 따라서 log(n)+log(n−1)+…+log(1)=log(n⋅(n−1)⋅…⋅1)=log(n!)
>
> 이는 O(nlogn) 과 근사한다.