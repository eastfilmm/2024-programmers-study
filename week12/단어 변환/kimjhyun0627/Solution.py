def solution(begin, target, words):
    
    answers = []
    visited = {}
    
    if target not in words:
        return 0
    
    def is_connected(fr, to):
        diff = 0
        for ii in range(len(fr)):
            if fr[ii] != to[ii]:
                diff += 1
        return True if diff == 1 else False
    
    def dfs(fr, depth):
        
        if fr == target:
            answers.append(depth)
            
        if fr in visited:
            if visited[fr] > depth:
                visited[fr] = depth
        if fr not in visited:
            visited[fr] = depth
            
        for w in words:
            if is_connected(fr, w):
                if w in visited and visited[w] > depth:
                    dfs(w, depth+1)
                elif w not in visited:
                    dfs(w, depth+1)
            
    dfs(begin, 0)
    
    answer = min(answers)
    return answer
