  # 문제 풀이

## 문제 해설


***Counter 자료형 사용***

1. Counter 자료형을 사용해 각 토핑이 몇 개나 들어있는지 알 수 있는 dictonray를 만든다.
2. 반복문을 통해 counter에서 토핑을 빼 주고, set형 brother 집합에 토핑을 더해준다.
3. collection과 set의 길이가 같으면 answer값을 1 더해준다.
## 시간 복잡도

$$O(len(topping))$$