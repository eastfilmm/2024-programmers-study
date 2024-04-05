def solution(str1, str2):
    answer = 0
    #다중집합 (중복허용)
    str1_arr = []
    str2_arr = []
    size1 = len(str1)
    size2 = len(str2)
    for i in range(size1-1):
        if(str1[i:i+2].isalpha()):
            str1_arr.append(str1[i:i+2].lower())
    for i in range(size2-1):
        if(str2[i:i+2].isalpha()):
            str2_arr.append(str2[i:i+2].lower())
    #print(str1_arr) 	['fr', 'ra', 'an', 'nc', 'ce']
    
    #유사도 계산
    #다중집합의 합집합
    sum_arr = str1_arr.copy()
    intersection_arr = str1_arr.copy()
    #합집합 a + b - a교b
    for i in str2_arr:
        if i not in intersection_arr:
            sum_arr.append(i) #안겹치는 부분 -> 합에 포함
        else:
            #겹치는 부분
            intersection_arr.remove(i) #빼주기
    sum_count = len(sum_arr)
    #교집합
    intersection_arr = []
    for i in str2_arr:
        if i in str1_arr:
            intersection_arr.append(i)
            str1_arr.remove(i)
    inter_count = len(intersection_arr)
    if (len(sum_arr) == 0 and len(intersection_arr) == 0):
        return 65536
    answer = int(inter_count / sum_count * 65536)
    return answer