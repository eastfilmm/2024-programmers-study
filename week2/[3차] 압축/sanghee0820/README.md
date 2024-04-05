# 문제 풀이

## 문제 해설
1. HashMap 에 A ~ Z의 값을 저장
2. msg를 순회하며 subMsg가 key에 포함되어있을 경우 return에 값 추가.

## 시간 복잡도

1. HashMap에 A ~ Z의 값을 저장 O(26);
```java
public void initSecretCode(){
        secretCode = new HashMap<>();
        for(char code = 'A'; code <= 'Z'; code++){
            secretCode.put(String.valueOf(code), code - 'A' + 1);
        }
        valueCnt = 26;
    }
```

2. msg를 순회하며 subMsg 확인 O(n) n = msg의 길이
```java
public List<Integer> toSecretCode(String msg){
        List<Integer> secret = new ArrayList<>();

        for(int index = 1; index-1 < msg.length(); ){
            
            String subMsg = String.valueOf(msg.charAt(index - 1));
            
            while(secretCode.containsKey(subMsg) 
                  && index < msg.length() ){
                subMsg += String.valueOf(msg.charAt(index++));
            }

            if(index == msg.length() ) {
                if(secretCode.containsKey(subMsg)){
                    secret.add(secretCode.get(String.valueOf(subMsg)));
                }
                else{
                    secret.add(secretCode.get(subMsg.substring(0, subMsg.length() - 1)));
                    secret.add(secretCode.get(String.valueOf(msg.charAt(msg.length() - 1))));
                }
                break;
            }
            
            secret.add(secretCode.get(subMsg.substring(0, subMsg.length() - 1)));
            secretCode.put(subMsg, ++valueCnt);
        }
        
        return secret;
    }
```

## 결과

> 최초 secretCode Map을 만드는데 A~Z의 값을 넣으므로 O(26)의 시간이 걸린다.
>
> 또 msg를 순회하며 subMsg를 만들고 secretCode에 추가하는 로직은 msg를 순회하는데 걸리는 시간과 비슷하므로
> 
> O(n)이 걸린다.