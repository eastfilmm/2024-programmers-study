def solution(dirs):

    direction = {'U' : (-1, 0), 'D' : (1, 0), 'L' : (0, -1), 'R' : (0, 1)}
    passed = set()
    
    x, y = 0, 0
    for d in dirs:
        new_x = x + direction[d][0]
        new_y = y + direction[d][1]
        if -5 <= new_x <= 5 and -5 <= new_y <= 5:
            passed.add(((x, y), (new_x, new_y)))
            passed.add(((new_x, new_y), (x, y)))
            x = new_x
            y = new_y

    answer = len(passed) // 2
    return answer