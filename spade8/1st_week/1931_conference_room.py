conference_num = int(input())
conference =[]

for i in range(conference_num):
    conference.append(list(map(int, input().split())))
##데이터 입력

conference.sort(key=lambda  x: (x[1],x[0]))
##데이터 정렬

num= 1
end = conference[0][1]
for j in range(1, conference_num):
    if conference[j][0] >= end:
        num = num + 1
        end = conference[j][1]


print(num)
##결과 출력