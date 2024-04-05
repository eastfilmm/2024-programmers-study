# 문제 풀이

## 문제 해설

주어진 릴레이션에서 후보키 개수를 구하는 문제다. 후보키는 유일성과 최소성을 만족해야 한다. 가능한 모든 후보키 경우의 수 중 유일성과 최소성을 만족하는 후보키 개수를 세리는 완전 탐색 방법으로 문제를 해결했다.

### 1. 유일성 판단

```java
public boolean isUnique(String[][] relation, int[] columns) {
    Set<String> attributes = new HashSet<>();
    for (String[] tuple: relation) {
        attributes.add(join(tuple, columns));
    }
    return attributes.size() == relation.length;
}
```

`columns`는 후보키 경우의 수를 구성하는 열의 인덱스이다. 릴레이션의 각 튜플마다 `columns`에 위치하는 값들을 모두 문자열 조인을 하여 식별 가능 여부를 판단한다. 이는 `HashSet`을 이용하여 `HashSet`에 존재하는 튜플 개수와 전체 튜플 개수가 동일하면 `true`를 반환한다.

### 2. 최소성 판단

```java
public boolean isMinimal(Set<Integer> attributes) {
    for (Set<Integer> candidateKey: candidateKeys) {
        if (attributes.containsAll(candidateKey)) {
            return false;
        }
    }
    return true;
}
```

`attributes`는 `columns`를 `Set`으로 변환한 것이다. `candidateKeys`는 여태까지 탐색한 모든 후보키를 `Set<Integer>` 형태로 가지고 있는 `HashSet`이다. 그래서 `candidateKey`가 `attributes`의 하위 집합이라면, `attributes`는 후보키를 포함하고 있기 때문에 최소성을 위반하여 `false`를 반환한다.

### 3. 조합
```java
public void combination(String[][] relation, boolean[] visited, int r, int depth, int now) {
    int n = relation[0].length;

    if (depth >= r) {
        int[] columns = new int[r];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                columns[idx++] = i;
            }
        }
        Set<Integer> attributes = toAttributes(columns);
        if (isUnique(relation, columns) && isMinimal(attributes)) {
            candidateKeys.add(attributes);
        }
        return ;                      
    }
    
    for (int i = now; i < n; i++) {
        visited[i] = true;
        combination(relation, visited, r, depth + 1, i + 1);
        visited[i] = false;
    }
}
```

백트래킹을 이용한 조합이다. `columns` 배열의 후보키 경우의 수를 의미한다. 해당 경우의 수가 유일성과 최소성을 만족하면 새로운 후보키로 추가한다.

```java
public int solution(String[][] relation) {
    int n = relation[0].length;
    for (int r = 1; r <= n; r++) {
        combination(relation, new boolean[n], r, 0, 0);
    }
    return candidateKeys.size();
}
```

최종적으로 위와 같이 모든 가능한 경우에 대해 조합을 계산한다. 이는 후보키를 구성하는 열의 개수가 1인 경우부터 `n`인 경우까지를 모두 계산한다.