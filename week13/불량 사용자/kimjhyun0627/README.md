  # 문제 풀이

## 문제 해설

***정규표현과 순열***

1. re.match를 위해 *을 .으로 바꾼다.
2. permutations를 이용해 순회한다. permutaions을 list 자료형으로 바꾸고, 반복문을 순회하며 모든 banned_id가 해당 permutaion들과 끝가지 같다면 — 가능한 경우라면 — 중복 확인 후 list에 append한다.
3. list의 길이를 반환한다.


## 시간 복잡도

$$O(len(userID)*len(bannedID))$$

