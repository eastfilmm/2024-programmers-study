# 문제 풀이

## 문제 해설

1. 문자열을 Head, Number, Tail로 파싱
2. 파싱된 문자열을 순회하며 조건에 맞게 정렬.
3. 결과값 입력
## 시간 복잡도

1. 문자열 파싱 O(n)
```java
    for(int i = 0; i < files.length; i++){
        String[] parsedFile = files[i].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        parsedFiles[i] = parsedFile;
    }
```

2.정렬 O(n log n)
```java
    Arrays.sort(parsedFiles, (a,b) -> {
        if(a[0].toLowerCase().equals(b[0].toLowerCase())){
            return Integer.valueOf(a[1].trim()) - Integer.valueOf(b[1].trim());
        }
        return a[0].toLowerCase().compareTo(b[0].toLowerCase());
    });
```

3. 결과값 입력 O(n)
```java
    for(int i = 0; i < files.length; i++){
        String[] parsedFile = parsedFiles[i];
        answer[i] = "";
        for(int j = 0; j < parsedFile.length; j++){
            answer[i] += parsedFile[j];
        }
    }
```
## 결과
> 파싱과 결과값 입력에서 모두 O(n)의 시간복잡도가 소모된다.
>
> 정렬에서 O(nlogn)이 소모된다.
>
> 따라서 시간복잡도는 O(nlogn)이다.