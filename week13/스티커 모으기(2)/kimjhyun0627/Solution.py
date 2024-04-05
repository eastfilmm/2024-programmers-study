def solution(sticker):
    
    if len(sticker) == 1:
        return sum(sticker)
    
    dp0 = [0 for _ in range(len(sticker))]
    dp0[0] = sticker[0]
    dp0[1] = max(sticker[0], sticker[1])
    for ii in range(2, len(sticker)-1):
        dp0[ii] = max(dp0[ii-1], dp0[ii-2] + sticker[ii])
        
    dp1 = [0 for _ in range(len(sticker))]
    dp1[1] = sticker[1]        
    for ii in range(2, len(sticker)):
        dp1[ii] = max(dp1[ii-1], dp1[ii-2] + sticker[ii])
    
    answer = max(max(dp1), max(dp0))

    return answer
