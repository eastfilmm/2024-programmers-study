def solution(word):
    answer = 0
    #각 자리수마다 나올 수 있는 경우의 수 
    case = [781,156,31,6,1]
    #[VXXXX,VVXXX,VVVXX,VVVVX,VVVVVV]
    vow = ['A','E','I','O','U']
    for i in range(len(word)):
        #AAAE -> 781 * vow[A] + 156 * vow[A] + 31 * vow[A] + .. 5 * vow[E] + len(AAAE)
        #EIO -> 781 * vow[E] + 156 * [I] + 31 * [O] + len(EIO)
        answer += case[i] * vow.index(word[i])
    answer += len(word)
    return answer