def solution(data, col, row_begin, row_end):

    answer = 0
    data = sorted(data, key = lambda x: [x[col - 1], -x[0]])    

    for ii in range(row_begin, row_end + 1):
        total = 0
        for jj in data[ii - 1]:
            total += (jj % ii)
        answer ^= total
            
    return answer