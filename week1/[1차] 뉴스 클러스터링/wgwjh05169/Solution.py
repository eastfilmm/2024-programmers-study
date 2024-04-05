def get_jset(string, jset):
    for i in range(len(string) - 1):
        c = string[i:i + 2]
        if c.isalpha():
            if jset.get(c):
                jset[c] += 1
            else:
                jset[c] = 1

    return


def solution(str1, str2):
    jset1 = {}
    jset2 = {}

    get_jset(str1.lower(), jset1)
    get_jset(str2.lower(), jset2)

    if jset1 or jset2:
        inter = union = 0
        for k in jset1:
            while jset1[k] != 0 and jset2.get(k, 0) != 0:
                jset1[k] -= 1
                jset2[k] -= 1
                inter += 1
                union += 1
            union += jset1[k]
            jset1[k] = 0

        for k in jset2:
            if jset2[k] != 0:
                union += jset2[k]
                jset2[k] = 0

        j = inter / union
    else:
        j = 1

    return int(j * 65536)