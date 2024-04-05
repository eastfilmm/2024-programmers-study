from collections import defaultdict

def solution(gems):
    
    var = len(set(gems))
    min_length = len(gems) + 1
    answer = []
    d = defaultdict(int)
    
    end = 0
    for start in range(len(gems)):
        
        while len(d) < var and end < len(gems):
            d[gems[end]] += 1
            end += 1    
        if len(d) == var:
            if min_length > end - start:
                min_length = end - start
                answer = [start+1, end]
                
        d[gems[start]] -= 1
        if d[gems[start]] == 0:
            del(d[gems[start]])
    
    return answer

print(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]))
print(solution(["AA", "AB", "AC", "AA", "AC"]))
print(solution(["XYZ", "XYZ", "XYZ"]))
print(solution(["ZZZ", "YYY", "NNNN", "YYY", "BBB"]))