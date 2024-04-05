def solution(begin, end):

    answer = []
        
    for ii in range(begin, end+1):
        min_num = 1
        max_num = 1
        
        for jj in range(2, int(ii**0.5)+1):
            if ii % jj == 0:
                if ii // jj <= 10000000:
                    min_num = jj
                    answer.append(ii // jj)
                    break
                else:
                    max_num = jj
        if ii == 1:
            answer.append(0)
        elif min_num == 1:
            answer.append(max_num)
            
    return answer