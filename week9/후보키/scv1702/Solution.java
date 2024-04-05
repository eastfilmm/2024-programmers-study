import java.util.*;

class Solution {
    Set<Set<Integer>> candidateKeys = new HashSet<>();
    
    public Set<Integer> toAttributes(int[] columns) {
        Set<Integer> set = new HashSet<>();
        for (int column: columns) {
            set.add(column);
        }
        return set;
    }
    
    public String join(String[] tuple, int[] columns) {
        StringBuilder sb = new StringBuilder();
        for (int column: columns) {
            sb.append(tuple[column]);
        }
        return sb.toString();
    }
    
    //최소성 검사
    public boolean isMinimal(Set<Integer> attributes) {
        for (Set<Integer> candidateKey: candidateKeys) {
            if (attributes.containsAll(candidateKey)) {
                return false;
            }
        }
        return true;
    }
    
    // 유일성 검사
    public boolean isUnique(String[][] relation, int[] columns) {
        Set<String> attributes = new HashSet<>();
        for (String[] tuple: relation) {
            attributes.add(join(tuple, columns));
        }
        return attributes.size() == relation.length;
    }
    
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
    
    public int solution(String[][] relation) {
        int n = relation[0].length;
        for (int r = 1; r <= n; r++) {
            combination(relation, new boolean[n], r, 0, 0);
        }
        return candidateKeys.size();
    }
}