from math import gcd

def solution(arrayA, arrayB):

    GCD_A = sGCD(arrayA)
    GCD_A = check(arrayB, GCD_A)
    GCD_B = sGCD(arrayB)
    GCD_B = check(arrayA, GCD_B)

    answer = max(GCD_A, GCD_B)
    return answer

def sGCD(array):
    GCD = 0
    for a in array:
        GCD = gcd(GCD, a)
    return GCD

def check(array, GCD):
    for a in array:
        if a % GCD == 0:
            return 0
    return GCD
