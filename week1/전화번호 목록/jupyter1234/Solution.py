def solution(phone_book):
    answer = True
    size = len(phone_book)
    for i in range(size):
        phone_book[i].replace(" ","")
        for j in range(size):
            if len(phone_book[i]) < len(phone_book[j]):
                if phone_book[i] == phone_book[j][0:len(phone_book[i])]:
                    answer = False
                    return answer
    return answer