# 문제 풀이

## 문제 해설
dfs방식으로 numbers 배열에 있는 숫자를 더하거나 빼서 타켓 숫자를 구할 수 있는 방식의 개수를 구한다.

<p>효율성을 위해 배열의 남은 수를 모두 더해도 타겟 숫자보다 작거나 혹은 배열의 남은 수를 다 빼도 타겟 숫자보다 큰 경우는 더 이상의 탐색을 중단하였다.

<p>
체크 안 했을 때
  <br><img width="1000" alt="non" src="https://github.com/jupyter1234/2024-programmers-study/assets/87298145/919b2a66-bb4b-485f-a7b3-3512d8dc4fe1">
<p>
체크 했을 때
<br><img width="1000" alt="check" src="https://github.com/jupyter1234/2024-programmers-study/assets/87298145/8c4fc74d-82ff-4453-875b-30f5f5d316cc">



## 시간 복잡도
O(N+E)
