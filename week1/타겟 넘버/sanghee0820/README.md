# 문제 풀이

## 문제 해설
1. DFS

## 시간 복잡도

### DFS O(n^2)
```java
    public int DFS(int[] numbers, int aryLength, int position, int target, int calculatedValue, int count ){

        if(aryLength  == position){
        if(target == calculatedValue){
            return count + 1;
            }
            return count;
        }
        count = DFS(numbers, aryLength, position + 1, target, calculatedValue + numbers[position], count);
        count = DFS(numbers, aryLength, position + 1, target, calculatedValue - numbers[position], count);

        return count;
        }
```

## 결과
> 완전 탐색으로, 시간복잡도는 O(n^2) 이다.