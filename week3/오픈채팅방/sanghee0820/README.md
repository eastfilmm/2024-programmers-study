# 문제 풀이

## 문제 해설

1. 입장 정보를 순회하며, 각 타입별로 처리.
2. 최종 결과를 위치에 맞게 String배열에 추가.

## 시간 복잡도

1. 입장정보 순휘 O(n)
```java
    for(int i = 0; i < records.length; i++){
        String record = records[i];
        // [0] = Type [1] = UID, [2] = NickName
        String[] parsedRecord = record.split(" ");

        if(parsedRecord[0].equals("Enter")){
            if(!nameMap.containsKey(parsedRecord[1])){
                recordMap.put(parsedRecord[1], new ArrayList<List<Integer>>());
            }
            nameMap.put(parsedRecord[1], parsedRecord[2]);
            recordMap.get(parsedRecord[1]).add(
            Arrays.asList(count, 0));
            count++;
            continue;
        }
        if(parsedRecord[0].equals("Leave")){
            recordMap.get(parsedRecord[1]).add(
            Arrays.asList(count, 1));
            count++;
            continue;
        }
        if(parsedRecord[0].equals("Change")){
            nameMap.put(parsedRecord[1], parsedRecord[2]);
        }
    }
```
2. 배열순회하며 위치에 맞게 결과값 추가 O(n)
```java
    String[] answer = new String[count];
    for(String key : recordMap.keySet()){
        List<List<Integer>> descs = recordMap.get(key);
        for(List<Integer> desc : descs){
            answer[desc.get(0)] = nameMap.get(key).concat(OUTPUT_DESC[desc.get(1)]);
        }
    }
```
## 결과

> 배열을 순회하며, 각 타입에 맞는 역할을 수행하는데 O(n)의 시간이 든다.
> 
> 최종 결과값을 추가하는데 최대 O(n)의 시간이 든다.