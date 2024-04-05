def solution(p):

    answer = ''
    if p == '':
        return p

    index = balanced(p)
    u = p[:index+1]
    v = p[index+1:]

    if proper(u):
        answer = u + solution(v)
    else:
        answer = '('
        answer += solution(v)
        answer += ")"

        u = list(u[1:-1])
        for ii in range(len(u)):
            if u[ii] == "(":
                u[ii] = ')'
            else:
                u[ii] = "("
        answer += "".join(u)

    return answer

def balanced(p):
    count = 0
    for ii in range(len(p)):
        if p[ii] == "(":
            count += 1
        else:
            count -= 1
        if count == 0:
            return ii
    
def proper(p):
    count = 0
    for i in p:
        if i == "(":
            count += 1
        else:
            if count == 0:
                return False
    return True
