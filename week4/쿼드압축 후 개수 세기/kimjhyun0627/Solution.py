def solution(arr):

    global answer
    answer = [0, 0]
    quad_zip(arr, answer, len(arr))
    return answer

def quad_zip(arr, ans, window):
    x, y, target = ans[0], ans[1], arr[ans[0]][ans[1]]
    for ii in range(window):
        for jj in range(window):
            if arr[x+ii][y+jj] != target:
                quad_zip(arr, [x, y], window//2)
                quad_zip(arr, [x, y+window//2], window//2)
                quad_zip(arr, [x+window//2, y], window//2)
                quad_zip(arr, [x+window//2, y+window//2], window//2)
                return
    answer[target] += 1