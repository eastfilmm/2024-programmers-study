# 문제 풀이
## 문제 해설

1. 숫자를 k진수로 바꾸기
    1. List를 Reverse
2. List를 순회하며 조건에 맞는 소수 확인.
## 시간 복잡도

1. k진수로 바꾸기
```java O(log_k(n))
public List<Integer> toKNumeral(int n, int k){
        List<Integer> kNum = new ArrayList<>();
        while(n != 0){
            kNum.add(n % k);
            n = n / k;
        }
        //시간 복잡도 log_k(n) -> 리스트 크기와 비례
        Collections.reverse(kNum);
        return kNum;
    }
```

2. List를 순회하며 조건에 맞는 소수 확인. O(n) n=List의 길이
```java
    public int countPrime(List<Integer> kNum){
        int cnt = 0;
        long num = 0;
        for(Integer k : kNum){
            if(k == 0){
                if(isPrime(num)) {
                    cnt++;
                }
                num = 0;   
            }
            num = num * 10 + k;
        }
        if(isPrime(num)) {
            cnt++;
        }
        return cnt;
    }
```

3. 소수 확인 O(root(num))

```java
public boolean isPrime(long num){
        if(num <= 1) return false;
        if(num == 2) return true;
        for(int i = 3; i < Math.sqrt(num) + 1; i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
```

## 결과

> n 을 k진수로 바꾸는 로직은 log_n(k)의 시간복잡도를 가진다
> 
> 소수를 확인하는 로직은 root(num)의 시간복잡도를 가지며
> 
> 배열을 순회하며 조건에 맞는 숫자를 만드는데는 O(n)의 시간복잡도가 필요하다.