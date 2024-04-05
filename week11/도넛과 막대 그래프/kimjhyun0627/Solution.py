def solution(edges):
    
    answer = [0, 0, 0, 0]
    
    count = {}
    for edge in edges:
        fr = edge[0]
        to = edge[1]
        
        if not count.get(fr):
            count[fr] = [0, 0]
        if not count.get(to):
            count[to] = [0, 0]
        count[fr][0] += 1
        count[to][1] += 1
    
    for node, cnt in count.items():
        if cnt[0] >= 2 and cnt[1] == 0:
            answer[0] = node
        elif cnt[0] == 0 and cnt[1] > 0:
            answer[2] += 1
        elif cnt[0] >= 2 and cnt[1] >= 2:
            answer[3] += 1
    
    answer[1] = count[answer[0]][0] - answer[2] - answer[3]

    return answer
