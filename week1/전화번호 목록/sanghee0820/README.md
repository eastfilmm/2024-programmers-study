# 문제 풀이

## 문제 해설 1 (효율성 4번 실패)
1. phone_book **배열을 길이**로 sorting 한다.
2. 배열의 앞(i) 뒤(j)로 탐색을 한다.
   1. 만약 i와 j 번 째 있는 문자열의 길이가 같아지면 i를 update 한다.
   2. 접두사가 일치하면 모든 탐색을 종료한다.
## 시간 복잡도

### Sorting (DualPivotQuicksort 사용 평균O(nlogn, 최악 O(n^2) ) )
```Java
    Arrays.sort(phone_book, new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
        }
    });
```

### 탐색 O(n^2) 
```Java
    for(int i = 0; i < phone_book.length - 1 && answer; i++){
        //만약 앞으로 비교할 전화번호의 길이가 같으면 break
        if(phone_book[i].length() ==
           phone_book[phone_book.length - 1].length()){
           break;
        }

        //긴 번호부터 비교.
        for(int j = phone_book.length - 1 ; j > i && answer; j--){
           int str1Len = phone_book[i].length();
           int str2Len = phone_book[j].length();

            //같은 길이가 나오면 break
           if(str1Len == str2Len){
            break;   
           }

            if(checkPrefix(phone_book[i], phone_book[j], str1Len, str2Len)){
                answer = false;
            }
        }
    }
```

### 결과

> 시간 복잡도가 최악의 경우 O(n^2)이 나올 수도 있다.
>
> When? 접두사가 일치하는 경우가 없고, phone_book의 길이가 길 때.
>

## 문제 해설 2 
1. phone_book **알파벳순으로**로 sorting 한다.
2. 배열을 순회하며, 다음 문장과 비교한다.
## 시간 복잡도

### Sorting (DualPivotQuicksort 사용 평균O(nlogn, 최악 O(n^2) ) )
```Java
    Arrays.sort(phone_book);
```

### 탐색 O(n)
```Java
    for(int i = 0; i < phone_book.length - 1 && answer; i++){
        if(checkPrefix(phone_book[i], phone_book[i+1])){
            answer = false;
        }
     }
```

### 결과

> 최악의 경우 Sorting에서 O(n^2)이 나올 수도 있다.
>
> 하지만, 배열을 순회하며 Prefix를 찾는 로직에서 배열을 한 번만 순회하면 된다.
>
> 시간 복잡도는 O(n^2)이다.