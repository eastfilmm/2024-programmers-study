# 문제 풀이

## 문제 해설

1. 문자열을 순회하며 2글자 SubString을 만든다. 이 때 문자를 모두 소문자로 바꾸어 진행한다.
   1. 만약 SubString이 알파벳이 아닌 경우, SubString을 만들지 않는다.
2. Hash함수를 통해 SubString들의 개수를 센다.
   1. 중복되는 SubString이 있을 경우 개수를 증가시킨다.
3. HashMap을 통해 교집합을 구한다.
   1. Str1의 SubString이 Str2의 SubString에 포함될 경우, 중복되는 SubString의 작은 개수를 합집합 원소 개수에 추가시킨다.
4. JacCard유사도를 계산한다.
   1. 합집합의 원소의 개수는 Str1의 SubString 개수 + Str2의 SubString 개수 - 교집합의 원소 개수로 구한다.


## 시간 복잡도

### 1. SubString 만들기 O(n)  / [ n = str의 길이 ]
``` Java
public List<String> subString(String str){
    str = str.toLowerCase();

    List<String> subStr = new ArrayList<>();
    /*
        str의 모든 원소를 순회 
    */
    for(int strIdx = 0; strIdx < str.length() - 1; strIdx++){
        if( ('a' > str.charAt(strIdx)) || ('z' < str.charAt(strIdx))
                || ( ('a' > str.charAt(strIdx + 1)) || ('z' < str.charAt(strIdx + 1)) ) ) {
            continue;
        }
        subStr.add(str.substring(strIdx, strIdx + 2));
    }

    return subStr;
}
```
### 2. HashMap 만들기 O(n) [ n = str의 길이 ]
``` Java
public HashMap<String, Integer> toHash(List<String> subStrs){
    HashMap<String, Integer> strMap= new HashMap<>();

    /* List의 길이는 최초 Input으로 주어진 str1, str2의 길이를 넘지않는다.
    따라서 List원소를 순회 하는 시간복잡도는 O(n)이다.
    */ 
    for(String subStr: subStrs) {

        if(strMap.containsKey(subStr)){
            strMap.put(subStr, strMap.get(subStr) + 1);
            continue;
        }
        strMap.put(subStr, 1);
    }

    return strMap;
}
```

### 3. 교집합 구하기 O(n) [ n = str의 길이 ]
``` Java
    /* HashMap의 키에 대해서만 진행된다.
        최악의경우 n-1개의 키를 가질 수 있다.
    */
    for(String key : str1Map.keySet()){
        if(str2Map.containsKey(key)){
            intersection += Math.min(str1Map.get(key), str2Map.get(key));
        }
    }
```

### 4. 결과

> str1 [ 길이 n ]과 str2[ 길이 m ]에 대해서 수행 한다.
> 
> 시간복잡도는 O(n + m)이 된다.