def solution(s):
    tuples = s[2:-2].split("},{")
    tuples.sort(key=len)

    answer = []
    for t in tuples:
        for s in map(int, t.split(",")):
            if s not in answer:
                answer.append(s)

    return answer