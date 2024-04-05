import math
def solution(n, k):
    answer = 0
    i = 0
    converted = convert(n,k)
    temp = ''
    while i < len(converted):
        if converted[i] == '0':
            if temp and temp != '1' :
                if is_prime(int(temp)):
                    answer += 1
                temp = ''
            temp = ''
        else:
            temp += converted[i]
        i += 1
    if temp and temp != '1':
        if is_prime(int(temp)):
            answer += 1
    return answer

#진법 변환 0 나올 때까지 나머지 -> 반대로
def convert(n,k):
    result = ''
    while(n>0):
        n,r=divmod(n,k)
        result += str(r)
    return result[::-1]
    
def is_prime(num):
    for i in range(2,int(math.sqrt(num))+1):
        if num % i == 0:
            return False
    return True
#조건1 0p0
#조건2 p0
#조건3 0p
#조건4 p
#1은 소수 아님!

#10진법으로 소수체크 해야함!!!