def solution(s):

    if len(s) == 1:
        return 1
    
    answer = 1001

    def make_string(string):
        cnt = 1
        new_str = ""
        comp = string[0]
        for ii in range(1, len(string)):
            if string[ii] == comp:
                cnt += 1
            else:
                if cnt != 1:
                    new_str += str(cnt)
                    cnt = 1
                new_str += comp
                comp = string[ii]
        new_str = new_str + str(cnt) + comp if cnt != 1 else new_str + comp
        return new_str

    for ii in range(1, len(s)//2+1):
        lst = [s[jj:jj+ii] for jj in range(0, len(s), ii)]
        answer = min(answer, len(make_string(lst)))

    
    return answer
