def solution(places):

    transformed_places = []
    for place in places:
        room = ['XXXXXXX']
        for row in place:
            room.append('X' + row + 'X')
        room.append('XXXXXXX')
        transformed_places.append(room)
                
    answer = []

    for place in transformed_places:
        ans = 1
        for ii in range(1, 6):
            for jj in range(1, 6):
                if place[ii][jj] == 'O' or place[ii][jj] == 'P':
                    tmp = [place[ii+k][jj+l] for k, l in [(-1, 0), (1, 0), (0, -1), (0, 1)]]
                    count = 0
                    for t in tmp:
                        if t == 'P':
                            count += 1
                    if (place[ii][jj] == 'O' and count >= 2) or (place[ii][jj] == 'P' and count >= 1):
                        ans = 0
                        break
        answer.append(ans)
            
    return answer
