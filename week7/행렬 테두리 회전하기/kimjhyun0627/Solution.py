from heapq import heappush

def solution(rows, columns, queries):
    
    answer = []
    matrix = [[columns * r + c for c in range(1, columns+1)] for r in range(rows)]

    for q in queries:

        y1, x1, y2, x2 = q
        heap = []

        y1x1 = matrix[y1-1][x1-1]
        y1x2 = matrix[y1-1][x2-1]
        y2x1 = matrix[y2-1][x1-1]
        y2x2 = matrix[y2-1][x2-1]

        heappush(heap, y1x1)
        heappush(heap, y1x2)
        heappush(heap, y2x1)
        heappush(heap, y2x2)

        for x in range(x2 - 1, x1 - 1, -1):
            matrix[y1-1][x] = matrix[y1-1][x-1]
            heappush(heap, matrix[y1-1][x])

        for y in range(y2 - 1, y1 - 1, -1):
            matrix[y][x2-1] = matrix[y-1][x2-1]
            heappush(heap, matrix[y][x2-1])

        for x in range(x1 - 1, x2 - 1, 1):
            matrix[y2-1][x] = matrix[y2-1][x+1]
            heappush(heap, matrix[y2-1][x])

        for y in range(y1 - 1, y2 - 1, 1):
            matrix[y][x1-1] = matrix[y+1][x1-1]
            heappush(heap, matrix[y][x1-1])

        matrix[y1][x2-1] = y1x2
        matrix[y2-1][x2-2] = y2x2
        matrix[y2-2][x1-1] = y2x1

        answer.append(heap[0])
    
    return answer
