def solution(k, dungeons):

    def search(k:int, dungeons:list) -> int:
        if len(dungeons) == 1:
            return 1 if k >= dungeons[0][0] else 0
        cnt = 0
        for i in dungeons:
            if k >= i[0]:
                cnt = max(cnt, 1+search(k-i[1], [d for d in dungeons if d != i]))
        return cnt

    answer = search(k, dungeons)
    return answer
