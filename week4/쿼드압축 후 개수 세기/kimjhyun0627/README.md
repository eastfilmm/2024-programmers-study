  # 문제 풀이

## 문제 해설


***분할 정복***

*global 안쓰고싶었는데 어쩔 수 없었다*

1. answer를 global 처리한다.
2. quad_zip 함수를 통해 재귀적으로 처리한다. window 안에서 target과 다른 수를 찾게 되면, window 크기를 줄여서 다시 quad_zip을 수행한다. 모두 target과 같다면, answer[target] += 1을 수행한다. 

## 시간 복잡도
$$O(n^{2}log{n})$$
근데 이거 맞나..?재귀 안에 이중반복문이라…

