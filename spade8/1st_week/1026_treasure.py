list_num = int(input("수열의 길이 : "))
list_a = list(map(int, input("수열 A : ").split()))
list_b = list(map(int, input("수열 B : ").split()))
list_b_size = []
list_a_sorted = []
s = 0
##데이터 입력

list_a.sort(reverse=True)
for i in range(list_num):
    k = 0
    for j in range(list_num):
        if list_b[i] > list_b[j]:
            k = k + 1
        elif list_b[i] == list_b[j] and i > j:
            k = k+1
    list_b_size.append(k)

for i in list_b_size:
    list_a_sorted.append(list_a[i])
for i in range(list_num):
    s = s + list_a_sorted[i] * list_b[i]
# 수열B의 순서를 구하여 저장한후
# 수열A를 정렬하여 A의 큰값과 b의 작은값이 곱해질수 있도록 한다.

print(s)
##결과 출력