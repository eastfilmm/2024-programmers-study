import java.util.*;

class Solution {
    public String filter(String skill, String skillTree) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < skillTree.length(); i++) {
            char c = skillTree.charAt(i);
            if (skill.indexOf(c) >= 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public boolean isValidSkillTree(String skill, String skillTree) {
        String filtered = filter(skill, skillTree);
        return skill.startsWith(filtered);
    }
    
    public int solution(String skill, String[] skillTrees) {
        int answer = 0;
        for (String skillTree: skillTrees) {
            if (isValidSkillTree(skill, skillTree)) {
                answer += 1;
            }
        }
        return answer;
    }
}
