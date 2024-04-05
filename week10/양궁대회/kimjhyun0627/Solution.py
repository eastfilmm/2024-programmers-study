from collections import deque

def bfs(n, info):
    
    res = []
    q = deque([(0, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])])
    max = 0
    
    while q:
        
        focus, arrow = q.popleft()
        if sum(arrow) == n:
            apeach, lion = 0, 0
            
            for ii in range(11):
                if not (info[ii] == 0 and arrow[ii] == 0):
                    if info[ii] >= arrow[ii]:
                        apeach += 10 - ii
                    else:
                        lion += 10 - ii
                        
            if apeach < lion:
                gap = lion - apeach
                if max > gap:
                    continue
                if max < gap:
                    max = gap
                    res.clear()
                res.append(arrow)
        
        elif sum(arrow) > n:
            continue
        
        elif focus == 10:
            tmp = arrow.copy()
            tmp[focus] = n - sum(tmp)
            q.append((-1, tmp))
        
        else:
            tmp = arrow.copy()
            tmp[focus] = info[focus] + 1 
            q.append((focus+1, tmp))
            tmp2 = arrow.copy()
            tmp2[focus] = 0
            q.append((focus+1, tmp2))
            
    return res

def solution(n, info):
    
    winList = bfs(n, info)
    
    if not winList:
        return [-1]
    elif len(winList) == 1:
        return winList[0]
    else:
        return winList[-1]
