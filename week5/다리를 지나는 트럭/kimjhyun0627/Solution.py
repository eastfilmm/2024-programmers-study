def solution(bridge_length, weight, truck_weights):
    
    answer = 0
    queue = [0 for _ in range(bridge_length)]
    cur_weight = 0
    truck_weights = truck_weights[::-1]

    while truck_weights:
        answer += 1
        cur_weight -= queue.pop(0)
        w = truck_weights.pop() if cur_weight + truck_weights[-1] <= weight else 0
        cur_weight += w
        queue.append(w)

    return answer + len(queue)
