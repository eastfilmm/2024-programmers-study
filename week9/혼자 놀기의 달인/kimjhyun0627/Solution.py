def solution(cards):

    answer = 0

    for ii in range(len(cards)):
        visited = [False for _ in range(len(cards))]
        groups = []
        next = ii
        while visited.count(False) > 0 and next < len(cards):
            if visited[next]:
                next = (next + 1) % len(cards)
                continue
            new = []
            while not visited[next]:
                visited[next] = True
                new.append(cards[next])
                next = cards[next] - 1
            groups.append(new)
            next = (next + 1) % len(cards)

        groups.sort(key=len, reverse=True)
        if len(groups) >= 2:
            answer = max(len(groups[0]*len(groups[1])), answer)
        
    return answer
