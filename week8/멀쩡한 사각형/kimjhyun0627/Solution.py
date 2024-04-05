from math import gcd

def solution(w, h):

    answer = w * h

    g = gcd(w, h)
    x = ((w // g) * (h // g) - (w // g - 1) * (h // g - 1))
    
    answer -= x * g
    
    return answer
