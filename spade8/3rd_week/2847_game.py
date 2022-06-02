n = int(input())        #스테이지 수
score = []              #스테이지 별 점수
modify_score = 0
for i in range(n):
    score.append(int(input()))
##데이터 입력

score.reverse()
pre_score = score[0]
for i in range(1,n):
    if score[i] >= pre_score:
        x = (score[i] - pre_score) +1
        modify_score += x
        score[i] -= x

    pre_score = score[i]


print(modify_score)