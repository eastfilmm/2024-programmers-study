def solution(storey):

    answer = 0
    while storey:
        move = storey % 10
        if move > 5:
            answer += (10 - move)
            storey += (10 - move)
        elif move < 5:
            answer += move
            storey -= move
        else:
            tmp = storey // 10
            if tmp % 10 >= 5:
                answer += (10 - move)
                storey += (10 - move)
            else:
                answer += move
                storey -= move
        storey //= 10

    return answer
