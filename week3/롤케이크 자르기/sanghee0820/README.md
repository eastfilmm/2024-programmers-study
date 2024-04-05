# 문제 풀이

## 문제 해설

1. 왼쪽과 오른쪽부터 각 자리수 별로 몇가지 토핑이 들어가있는지 확인
2. 왼쪽부터 순회하며, n+1에 있는 오른쪽 토핑이 같은지 확인.
## 시간 복잡도

1. 왼쪽과 오른쪽 배열 만들기 O(n)
```java
    private int[] getLeft(int[] toppings){
        int total = 0;
        int[] left = new int[toppings.length];
        boolean[] visited = new boolean[10000];
        for(int i = 0; i < toppings.length; i++){
            int topping = toppings[i];
            if(!visited[topping - 1]){
                visited[topping - 1] = true;
                left[i] = ++total;  
                continue;
            }
            left[i] = total;
        }
        return left;
    }
```
2. 배열을 순회하며, 오른쪽 토핑 개수 확인 O(n)
```java
    for(int i = 0; i < toppings.length - 1; i++){
        if(left[i] == right[i + 1]){
            answer++;
        }
    }
```

## 결과
> 오른쪽 토핑 개수와 왼쪽 토핑 개수 배열을 만드는데 O(n)의 시간복잡도가 든다.
> 
> 배열을 순회하며 결과값을 확인하는데 O(n)의 시간복잡도가 든다.