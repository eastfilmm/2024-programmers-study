# 문제 풀이

## 문제 해설
이 문제를 풀기위해서 알아야 하는 것은 두가지 이다.
1. 문자열 파싱
2. 다중집합 이애하기 
위의 두가지만 이해하면 풀수 있는 문제이다.

아래는 코드이다.

    def solution(str1, str2):
    str1=str1.lower();
    str2 = str2.lower();
    
    str1_list = [];
    str2_list = [];
    
    for i in range(len(str1)-1):
        a = str1[i:i+2]
        if a.isalpha():
            str1_list.append(a);
    
    for i in range(len(str2)-1):
        a = str2[i:i+2]
        if a.isalpha():
            str2_list.append(a);
    
    if len(str1_list)==0 and len(str2_list)==0:
        j=1
    else:
        a_temp = str1_list.copy()
        a_result = str1_list.copy()
        for i in str2_list:
            if i not in a_temp:
                a_result.append(i) 
            else:
                a_temp.remove(i)
        
        result = []
        for i in str2_list:
            if i in str1_list:
                str1_list.remove(i)
                result.append(i)

        j = len(result)/len(a_result)
        
    return (int(j * 65536))

위의 코드는 크게 세부분으로 나누어져 있다.
1. 문자열 파싱 : 문자열 내에 알파벳 이외의 내용이 있으면 뺀다.
2. 집합이 모두 공집합이면 자카드 유사도는 1 이다.
3. 이외에는 공집합/합집합 으로 자카드 유사도를 계산한다.

## 시간 복잡도
위의 코드 시간복잡도는 O(n) 이다.