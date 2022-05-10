rope_num = int(input())
rope =[]
for i in range(rope_num):
    rope.append(int(input()))
##데이터 입력

max = 0
rope.sort(reverse=True)
for i in range(rope_num):
    if rope[i] * (i+1) > max:
        max = rope[i] * (i+1)
##(임의의 로프)*(해당 로프보다 중량이 높은 로프의 수) 를 연산하여 최대값을 구한다

print(max)
##결과 출력
