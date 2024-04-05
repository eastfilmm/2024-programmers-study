# 문제 풀이

## 문제 해설
1. 문자열 파싱
   1. 먼저 앞뒤 괄호{}를 제거
   2. },{를 기준으로 split
   3. { }를 제거
   4. ,를 기준으로 split
2. 파싱 한 문자열을 List<List<Integer>>로 변환
3. List<List<Integer>>를 길이 순으로 정렬
4. 정렬된 List<List<Integer>>를 순회.
   1. 각 원소를 순회하며 순서대로 answer에 추가

## 시간 복잡도

### 문자열 파싱 O(n) (n = 문자길이)
```java
    List<List<Integer>> parsedInput = new ArrayList<>();

        str = str.substring(1, str.length() - 1);

        String[] splitStrs = str.split("\\},\\{");

        for (String data : splitStrs) {
        data = data.replace("{", "").replace("}", "");
        String[] numbers = data.split(",");

        List<Integer> parsedInt = new ArrayList<>();
        for (String number : numbers) {
            parsedInt.add(Integer.parseInt(number));
        }

        parsedInput.add(parsedInt);
    }
```

### 정렬 O(nlogn) (n = List<List<Integer>>의 길이)
```java
   Collections.sort(parsedInput, (a,b)->{
        return Integer.compare(a.size(), b.size());
    });
```

### 순회 O(n^2) (n = 튜플 원소의 개수)
```java
    for(List<Integer> elements: parsedInput){
        for(Integer element: elements){
            if(answer.contains(element)){
             continue;
            }
            answer.add(element);
            break;
        }
    }
```

### 배열 만들기 O(n)
```java
    answer.stream().mapToInt(i -> i).toArray();
```


## 결과
> 문자열 파싱은 모두 문자열 길이에 선형으로 이루어지기 때문에 O(n)이다.
>
> Collection.sort는 O(nlogn)이다.
>
> 순회의 경우 튜플 최종길이를 n이라고 할 때 1~n 개 길이의 리스트가 존재하므로 n(n+1)/2이므로 O(n^2)이다.
>
> 따라서 시간 복잡도는 O(n^2)이다.