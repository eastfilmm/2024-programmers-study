# 문제 풀이

## 문제 해설
이 문제에서는 해시맵을 사용할 수 있는가가 중점이었다고 생각한다.
옷 type 개수가 정해져있지 않기 때문에,
미리 배열로 만들어 둘 수 없었다.

코드는 아래와 같다.

    def solution(clothes):
    hash_map ={}
    for clothe, type in clothes:
        hash_map[type]=hash_map.get(type,0)+1
        
    answer = 1
    for type in hash_map:
        answer *= (hash_map[type]+1)
        
    return answer-1

이 코드에서는 딕셔너리를 활용했다.
첫번째 for문을 보면 type 이 딕셔너리 내에 없다면, 새로 추가하고 그 수는 1,
이미 해당 type 이 있다면 +1을 해주고 있다.

이제 가능한 모든 경우의 수를 구하려면, 
해당 type의 의상을 입지 않는 경우가 있기에 +1 하고
이러한 수를 모두 곱한다.
마지막에 결과값에서 어떤 의상도 입지 않은 경우 1을 빼주면 된다.

## 시간 복잡도
시간 복잡도는 O(n) 이다.