# 문제 풀이

## 문제 해설

1. 숫자(num) 0부터 result의 길이가 t보다 클 때까지 1씩 증가시키기
    1. num을 n진수로 변환
    2. 사용자가 답해야하는 부분을 result에 추가
## 시간 복잡도

1. n진수 변환 O(log_n(num))
```java
    public List<Character> getKNum(int n, int num){
        List<Character> kNum = new ArrayList();
        if(num == 0){
            kNum.add('0');
        }
        while(num != 0){
            kNum.add(chars.get(num % n));
            num /= n;
        }
        Collections.reverse(kNum);
        return kNum;
    }
```

2. 결과값 추가 O(k * (log_n(num))) k = 결과값 도달을 위한 반복 횟수
```java
    while(result.size() < t){
        List<Character> kNum = getKNum(n, num);
        
        for(int i = 0; i < kNum.size(); i++){
            if(mCnt == p){
                result.add(kNum.get(i));
            }
            mCnt = (mCnt + 1) % (m + 1);
            if(mCnt == 0){
                mCnt++;
            }
        }
        
        num++;
    }
```

## 결과
> n진수를 만드는데 로직은 log_n(num)를 가진다.
>
> while문은 k회 반복하고, 내부에있는 for문은 최대 log_n(num)의 길이만큼 순회한다.
