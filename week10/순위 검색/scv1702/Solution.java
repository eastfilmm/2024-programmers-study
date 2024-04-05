import java.util.*;
import java.util.stream.*;

class Applicant {
    String language;
    String position;
    String career;
    String food;
    int score;
    
    Applicant(String[] splited) {
        this.language = splited[0];
        this.position = splited[1];
        this.career = splited[2];
        this.food = splited[3];
        this.score = Integer.parseInt(splited[4]);
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %s %s %d", language, position, career, food, score);
    }
}

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
    
    @Override
    public String toString() {
        return String.format("%s %s %s %s", language, position, career, food);
    }
}

class Solution {
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
    
    public int[] solution(String[] info, String[] query) {
        // 모든 조건 조합에 대해 미리 계산
        // database[language][position][career][food]
        
        List<List<String>> conditions = List.of(
            List.of("cpp", "java", "python", "-"),
            List.of("backend", "frontend", "-"),
            List.of("junior", "senior", "-"),
            List.of("chicken", "pizza", "-")
        );
        
        Map<Key, List<Integer>> database = new HashMap<>();
        
        Applicant[] applicants = Arrays.stream(info)
            .map(s -> new Applicant(s.split(" ")))
            .sorted((a1, a2) -> a1.score - a2.score)
            .toArray(Applicant[]::new);
        
        for (String language: conditions.get(0)) {
            for (String position: conditions.get(1)) {
                for (String career: conditions.get(2)) {
                    for (String food: conditions.get(3)) {
                        Stream<Applicant> stream = Arrays.stream(applicants);                    
                        
                        if (!"-".equals(language)) {
                            stream = stream.filter(applicant -> applicant.language.equals(language));
                        }
                        if (!"-".equals(position)) {
                            stream = stream.filter(applicant -> applicant.position.equals(position));
                        }
                        if (!"-".equals(career)) {
                            stream = stream.filter(applicant -> applicant.career.equals(career));
                        }
                        if (!"-".equals(food)) {
                            stream = stream.filter(applicant -> applicant.food.equals(food));
                        }
                        
                        Key key = new Key(language, position, career, food);
                        List<Integer> result = stream.map(a -> a.score)
                            .sorted()
                            .collect(Collectors.toList());
                        
                        database.put(key, result);
                    }
                }
            }
        }   
        
        int[] answer = Arrays.stream(query).mapToInt(q -> {
            String[] splited = Arrays.stream(q.split("and| "))
                .filter(s -> !"".equals(s))
                .toArray(String[]::new);
            
            String language = splited[0];
            String position = splited[1];
            String career = splited[2];
            String food = splited[3]; 
            int score = Integer.parseInt(splited[4]);
            
            Key key = new Key(language, position, career, food);
            List<Integer> result = database.get(key);
            
            return result.size() - search(result, score);
        }).toArray();
        
        return answer;
    }
}