def solution(book_time):

    books = [[(int(b[0].split(':')[0])*60 + int(b[0].split(':')[1])),
              (int(b[1].split(':')[0])*60 + int(b[1].split(':')[1]))]
                for b in book_time ]
    books = sorted(books, key=lambda item: item[0])

    rooms = [0]
    for b in books:
        if rooms[0] <= b[0]:
            rooms[0] = b[1] + 10
        else:
            rooms.append(b[1] + 10)
        rooms = sorted(rooms)

    answer = len(rooms)
    return answer
