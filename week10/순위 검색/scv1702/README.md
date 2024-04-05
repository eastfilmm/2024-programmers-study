# 문제 풀이

## 문제 해설

주어진 조건에 따라 값을 검색한다. 다만, 코딩 테스트 점수가 주어진 점수보다 이상인 지원자를 검색하는 쿼리가 항상 주어지기 때문에 데이터를 미리 정렬하여 이진 검색을 하면 시간을 줄일 수 있을 것 같다. 그런데 다른 조건은 어떻게 검색할 수 있을까? 쿼리 개수는 $10^5$이고 데이터 길이는 $5 \times 10^4$이기 때문에 선형 탐색으로는 시간 내에 문제를 해결할 수 없다.

검색 조건에는 코딩 테스트 점수를 제외하고 개발 언어, 직군, 경력, 소울 푸드가 있다. 또한 각 조건에 `-`가 주어지면 해당 조건은 고려하지 않는다는 뜻이다. 그러므로 주어진 조건의 모든 경우의 수는 `-`까지 포함했을 때 총 $4 \times 3 \times 3 \times 3 = 108$이다. 그렇게 큰 값은 아니기 때문에 미리 각 조건에 따라 데이터를 캐싱해둔다면 시간 내에 문제를 해결할 수 있을 것이다.

### 다중 키 해시맵

자바는 다중 키를 뜻하는 새로운 클래스를 정의하면 다중 키 해시맵을 쉽게 구현할 수 있다. 다만, 해당 클래스는 해시맵이 사용할 수 있도록 `equals()`와 `hashCode()`를 꼭 오버라이드해야 한다. 이번 문제는 다음과 같이 키를 선언할 수 있다.

```java
class Key {
    String language;
    String position;
    String career;
    String food;
    
    Key(String language, String position, String career, String food) {
        this.language = language;
        this.position = position;
        this.career = career;
        this.food = food;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Key)) {
            return false;
        }
        Key key = (Key) o;
        return this.language.equals(key.language) &&
            this.position.equals(key.position) &&
            this.career.equals(key.career) &&
            this.food.equals(key.food);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(language, position, career, food);
    }
}
```

해시맵을 선언할 때는 다음과 같이 사용하면 된다.

```java
Map<Key, List<Integer>> database = new HashMap<>();
```

### 중복되는 원소일 경우 먼저 나타나는 원소를 찾는 이진 탐색

지원자의 코딩 테스트 점수가 중복될 수도 있기 때문에, 이진 탐색을 수행할 때 중복을 고려해줘야 한다. 그렇다면 중복되는 원소가 있을 때 어떤 원소의 위치를 반환해야 할까? 배열의 위치 상 먼저 나타나는 원소의 위치를 반환할 수도 있고, 가장 마지막에 나타나는 원소의 위치를 반환할 수도 있다. 그런데 이번 문제에서는 **조건을 만족하는 지원자 수**를 구해야하기 때문에, 중복되는 원소일 경우 먼저 나타나는 원소의 위치를 반환해야 한다. 

```java
public int search(List<Integer> arr, int n) {
    int left = 0;
    int right = arr.size() - 1;
    
    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr.get(mid) >= n) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    
    return left;
}
```

위 메소드는 주어진 `arr`에서 `n`의 위치에 대해 이진 탐색을 수행한다. 단, `arr`에 `n`이 중복될 경우 먼저 나타나는 `n`의 위치를 반환한다. 이는 `arr.get(mid) >= n`을 보면 알 수 있는데 기존 이진 탐색일 경우 `arr.get(mid) == n`일 경우 바로 `return mid`를 했을 것이지만, 이번에는 `arr.get(mid) == n`일 때도 탐색을 이어간다. 

## 시간 복잡도

쿼리의 길이를 $Q$, 지원자 목록의 길이를 $N$이라고 하자.
먼저 모든 조건에 대해 캐싱을 수행하는 과정은 $O(108 \times N)$이다. 그리고 쿼리를 수행하는 과정은 $O(Q \times \log(N))$이다. 그러므로 전체 시간 복잡도는 $O(108 \times N + Q \times \log(N))$이다.
