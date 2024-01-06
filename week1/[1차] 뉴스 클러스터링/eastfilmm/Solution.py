def solution(str1, str2):
    str1=str1.lower();
    str2 = str2.lower();
    
    str1_list = [];
    str2_list = [];
    
    for i in range(len(str1)-1):
        a = str1[i:i+2]
        if a.isalpha():
            str1_list.append(a);
    
    for i in range(len(str2)-1):
        a = str2[i:i+2]
        if a.isalpha():
            str2_list.append(a);
    
    if len(str1_list)==0 and len(str2_list)==0:
        j=1
    else:
        a_temp = str1_list.copy()
        a_result = str1_list.copy()
        for i in str2_list:
            if i not in a_temp:
                a_result.append(i) 
            else:
                a_temp.remove(i)
        
        result = []
        for i in str2_list:
            if i in str1_list:
                str1_list.remove(i)
                result.append(i)

        j = len(result)/len(a_result)
        
    return (int(j * 65536))