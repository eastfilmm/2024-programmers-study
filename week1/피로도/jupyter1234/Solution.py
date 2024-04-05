answer = 0
def solution(k, dungeons):
    global answer
    size = len(dungeons)
    #방문했는지 확인
    visited = [0] * size
    # k : 현재 피로도
    dfs(k,visited,0,dungeons)
    return answer

def dfs(k,visited,cnt,dungeons):
    global answer
    answer = max(answer,cnt) #현재 방문한 던전 수가 더 큰경우 answer 갱신
    size = len(dungeons)
    for i in range(size):
        if (visited[i] == 0 and k >= dungeons[i][0]):
            #cnt += 1
            visited[i] = 1
            dfs(k-dungeons[i][1],visited,cnt+1,dungeons)
            #이전 던전으로 back
            visited[i] = 0
            #cnt -= 1