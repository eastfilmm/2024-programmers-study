class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree : skill_trees){
            boolean flag = true;
            int skillCnt = 0;
            for(int j = 0; j < skill_tree.length(); j++){
                if(!skill.contains(String.valueOf(skill_tree.charAt(j)))){
                    continue;
                }
                if(skill_tree.charAt(j) == skill.charAt(skillCnt++)){
                    continue;
                }
                flag = false;
                break;
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}