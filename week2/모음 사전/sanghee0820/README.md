# 문제 풀이

## 문제 해설
1. String을 List<Character>배열로 만들기
2. 각 자리 문자마다 A와의 거리 계산.

## 시간 복잡도
1. Character 배열 만들기 O(n) n = String의 길이
```java
    List<Character> words = word.chars()
        .mapToObj(e-> (char)e)
        .collect(Collectors.toList());
```

2. 각 자리 문자마다 A와의 거리 계산 O(n) n = String의 길이
```java
    for(int i=0; i<words.size(); i++) {
        answer += charCnt.get(i)*chars.indexOf(words.get(i)) + 1;
    } 
```
## 결과

> 각자리마다 A와의 거리를 계산해서 하드코딩 해놓았다 (실전에서는 완전탐색이 더 효율적일듯 하다)
>
> 따라서 시간복잡도는 O(n)이다.