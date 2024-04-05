from itertools import product

def solution(users, emoticons):
    
    discounts = list(product([10, 20, 30, 40], repeat=len(emoticons)))
    
    answer = []
    for discount in discounts:
        members = 0
        incomes = 0
        
        for d, p in users:
            purchased = 0
            
            for ii in range(len(emoticons)):
                if d <= discount[ii]:
                    purchased += emoticons[ii] - emoticons[ii] * discount[ii] * 0.01
                    
            if purchased >= p:
                members += 1
            else:
                incomes += purchased
                
        answer.append((members, incomes))
        
    answer = sorted(answer, reverse=True, key=lambda x: (x[0], x[1]))
    
    return answer[0]