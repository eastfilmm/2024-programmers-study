def solution(land):
    for ii in range(1, len(land)):
        for jj in range(4):
            land[ii][jj] += max(land[ii-1][:jj] + land[ii-1][jj+1:])
        
    answer = max(land[len(land)-1])
    return answer