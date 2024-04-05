def solution(record):
    id = {}
    log = []
    for rec in record:
        r = rec.split()
        if r[0] == "Enter":
            id[r[1]] = r[2]
            log.append([r[1], r[0]])
        if r[0] == "Change":
            id[r[1]] = r[2]
        if r[0] == "Leave":
            log.append([r[1], r[0]])
            
    answer = []
    for l in log:
        answer.append(''.join(f"{id[l[0]]}님이 들어왔습니다." if l[1] == "Enter" else f"{id[l[0]]}님이 나갔습니다."))
    
    return answer