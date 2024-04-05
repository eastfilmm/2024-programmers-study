def solution(name):

    if set(name) == {'A'}:
        return 0

    a_pos = ord('A')
    z_pos = ord('Z')

    answer = float('inf')

    for ii in range(len(name)//2+1):
        
        left_to_right = name[-ii:] + name[:-ii]
        right_to_left = name[ii::-1] + name[ii+1:][::-1]
        
        for n in [left_to_right, right_to_left]:
            while n and n[-1] == 'A':
                n = n[:-1]
            cnt = [min(ord(c)-a_pos, (z_pos+1)-ord(c)) for c in n ]
            answer = min(answer, ii+(len(cnt)-1)+sum(cnt))

    return answer
