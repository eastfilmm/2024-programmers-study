def solution(line):

    def pointer(ii, jj):
        x1, y1, c1 = ii
        x2, y2, c2 = jj
        
        if x1 * y2 == x2 * y1:
            return
        
        x = (y1 * c2 - y2 * c1) / (x1 * y2 - x2 * y1)
        y = (x2 * c1 - x1 * c2) / (x1 * y2 - x2 * y1)
        
        if x == int(x) and y == int(y):
            return [int(x), int(y)]
           
    cross = []
    for ii in range(len(line)):
        for jj in range(ii+1, len(line)):
            point = pointer(line[ii], line[jj])
            if point:
                cross.append(point)
    
    min_width, min_height = min(cross, key=lambda x: x[0])[0], min(cross, key=lambda x: x[1])[1]
    max_width, max_height = max(cross, key=lambda x: x[0])[0] + 1, max(cross, key=lambda x: x[1])[1] + 1
    
    answer = [['.'] * (max_width - min_width) for _ in range((max_height - min_height))]
    
    for x, y, in cross:
        answer[y-min_height][x-min_width] = '*'
    
    answer.reverse()
    answer = [''.join(a) for a in answer]
    return answer
