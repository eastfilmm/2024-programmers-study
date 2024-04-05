def solution(routes):
    
    routes.sort(key=lambda x: x[0])
    answer = 0
    finish = -30000
    
    for enter, exit in routes:
        if enter > finish:
            answer += 1
            finish = exit
        finish = min(finish, exit)
    
    return answer
