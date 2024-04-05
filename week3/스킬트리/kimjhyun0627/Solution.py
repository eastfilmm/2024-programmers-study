def solution(skill, skill_trees):

    answer = 0
    
    for skill_tree in skill_trees:
        ord = ""
        for s in skill_tree:
            if s in skill:
                ord += s
        if skill[:len(ord)] == ord:
            answer += 1
            
    return answer