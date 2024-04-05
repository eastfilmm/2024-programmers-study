from collections import defaultdict

def solution(genres: list, plays: list) -> list:
    
    songs = defaultdict(list)
    for ii in range(len(genres)):
        songs[genres[ii]].append([ii, plays[ii]])
    
    answer = []
    while songs:
        m = max(songs, key=lambda x: sum(s[1] for s in songs[x]))
        if len(songs[m]) == 1:
            answer.append(songs[m][0][0])
        else:
            for ii in range(2):
                mi = max(songs[m], key=lambda x: x[1])
                answer.append(mi[0])
                songs[m].remove(mi)
        del songs[m]
        
    return answer
