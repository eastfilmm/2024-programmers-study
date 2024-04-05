# 문제 풀이

## 문제 해설

주어진 음악 정보 `musicinfos`에 대해서 전체 악보와 재생 시간을 통해 실제 재생된 악보와 재생 시간 등에 대한 정보를 가진 클래스 `MusicInfo`를 계산한다. 이에 대한 리스트를 `List<MusicInfo> musicInfos`라고 할 때, 주어진 `m`을 하위 리스트로 가지고 있는 `MusicInfo`를 구한다. 이때 답이 여러 개인 경우 재생 시간에 대해 정렬을 한다.

## 시간 복잡도

`musicinfos`의 길이를 $n$이라고 하고, 악보 최대 길이를 $k$라고 할 때 $O(n \times k + n\log(n))$이다.