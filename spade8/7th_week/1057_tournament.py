import math
n, kim, lim= map(int, input().split())
result = 0
def tour(n,a,b,result):

    result += 1
    next_n = math.ceil(n / 2)
    next_a = math.ceil(a / 2)
    next_b = math.ceil(b / 2)
    if abs(next_a - next_b) == 0:
        print(result)
    else:
        return tour(next_n,next_a,next_b,result)



tour(n,kim,lim,result)

