import re

def solution(files):

    tmp = [re.split(r"([0-9]+)", file) for file in files]
    sorted_tmp = sorted(tmp, key=lambda x:(x[0].lower(), int(x[1])))
    answer = [''.join(s) for s in sorted_tmp]
    
    return answer
