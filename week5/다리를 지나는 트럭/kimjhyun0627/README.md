  # 문제 풀이

## 문제 해설


******

1. 큐를 생성하고 pop()의 편의성을 위해 truck_weights를 반전시킨다.
2. truck_weights에 요소가 없을때까지 반복문을 수행한다. 
3. answer에 1초를 추가하고, cur_weight에 queue에서 pop한 요소만큼을 빼준다. 
4. 새로운 트럭이 오를 수 있다면 cur_weight에 그만큼을 더해주고 그렇지 못하다면 cur_weight를 유지한다.
5. queue에 w를 추가한다.
6. 반복문이 끝날 시 answer값과 queue의 길이를 더해 반환한다.


## 시간 복잡도
$$O(n)$$

