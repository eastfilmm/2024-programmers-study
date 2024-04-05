def solution(s):
    #s는 문자열
    s = s.replace("{","").replace("}","").split(",")
    #print(s)
    
    #dict에 해당 숫자와 빈도수 저장
    num = dict()
    for i in s:
        i = int(i)
        if i in num:
            num[i] += 1
        else:
            num[i] = 1
    print(num)
    # #빈도수로 sorting하기
    answer = sorted(num, key= lambda x:num[x],reverse=True)
    return answer