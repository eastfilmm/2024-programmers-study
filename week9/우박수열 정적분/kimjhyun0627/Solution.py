def solution(k, ranges):

    graph = [k]
    while k != 1:
        if k % 2:
            k *= 3
            k += 1
            graph.append(int(k))
        else:
            k /= 2
            graph.append(int(k))
    
    areas = []
    for ii in range(len(graph)-1):
        area = (graph[ii] + graph[ii+1]) / 2
        areas.append(area)

    answer = []    
    for r in ranges:
        if r[0] > len(areas) + r[1]:
            answer.append(-1.0)
        else:
            answer.append(float(sum(areas[r[0]:len(areas)+r[1]])))

    return answer
