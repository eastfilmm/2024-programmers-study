def solution(numbers, target):

    def calc(current,index):
        nonlocal answer
        if index == len(numbers):
            if current == target:
                answer += 1
            return
        if check(numbers,target,index,current) == True:
            calc(current - numbers[index],index+1)
            calc(current + numbers[index],index+1)
    answer = 0
    calc(0,0)
    return answer
def check(numbers,target,index,current):
    #남은 수 다 더해도 타겟보다 작은 지 확인
    if sum(numbers[index:]) + current >= target:

        #남은 수 다 빼도 타겟보다 큰 지 확인
        if current - sum(numbers[index:]) > target:
            return False
        return True
    else:
        return False