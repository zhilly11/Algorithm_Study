s = list(input())

if len(s)<2:
    print(len(s))
else:
    first = s[0]
    switch = 0
    answer = 0
    for i in range(1,len(s)):
        if s[i] == first and switch==0:
            continue
        elif s[i] != first and switch==0:
            switch = 1
            answer += 1
        elif s[i] != first and switch==1:
            continue
        else:
            switch = 0
    print(answer)