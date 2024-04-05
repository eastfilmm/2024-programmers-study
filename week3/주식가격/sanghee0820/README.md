# 문제 풀이

## 문제 해설

1. 스택에 숫자 담기.
    1. 만약 Stack의 맨 위  숫자보다 클 때 까지 pop
2. 스택에 남아있는 숫자 빼기.
    1. 만약 숫자가 남아있다면, 끝까지 가격이 떨어지지 않은 것
## 시간 복잡도

1. 스택에 숫자 담기 O(n^2)
```java
    for(int i = 1; i < numbers.length; i++){
        int[] current = stack.peek();
        while(!stack.isEmpty() && current[0] < numbers[i]){
            answer[current[1]] = numbers[i];
            stack.pop();
            if(stack.isEmpty()){
                break;
            }
            current = stack.peek();
        }
        stack.add(new int[]{numbers[i], i});
    }
```

2. 스택에 남아있는 숫자 빼기 O(n)
```java 
    while (!stack.isEmpty()) {
        answer[stack.peek()] = prices.length - stack.peek() - 1;
        stack.pop();
    }
```
## 결과

> 모든 배열을 순회하며 stack에 넣는 과정은 최대 n^2의 시간이 소모된다.
>
> 스택에 남아있는 숫자를 순회하며 모두 pop하는 과정은 최대 n의 시간이 소모된다.
>
> 따라서 시간복잡도는 O(n^2)이다.