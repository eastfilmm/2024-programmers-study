def solution(m, n, startX, startY, balls):
    
    answer = []
    
    for b in balls:
        cousions = []
        #top
        if b[0] != startX or b[1] < startY:
            cousions.append(abs(b[0] - startX) ** 2 + abs((n - b[1]) + (n - startY)) ** 2)
        #bot
        if b[0] != startX or b[1] > startY:
            cousions.append(abs(b[0] - startX) ** 2 + abs(b[1] + startY) ** 2)
        #left
        if b[1] != startY or b[0] > startX:
            cousions.append(abs(b[0] + startX) ** 2 + abs(b[1] - startY) ** 2)
        #right
        if b[1] != startY or b[0] < startX:
            cousions.append(abs((m - b[0]) + (m - startX)) ** 2 + abs(b[1] - startY) ** 2)

        answer.append(min(cousions))
        
    return answer
