# 문제 풀이

## 문제 해설

1. 배열을 순회하며, 바로 윗 칸에서 자신의 열과 같지 않 번호중 가장 큰수와 더하기.
## 시간 복잡도

1. 배열 순회
```java

    for(int i = 1; i < land.length; i++){
        for(int j = 0; j < 4; j++){
            int max = -1;
            for(int k = 0;  k < 4; k++){
                if(j == k){
                    continue;
                }
            max = Math.max(max, dp[i-1][k]);
        }
        dp[i][j] = max + land[i][j];
        }
    }
```