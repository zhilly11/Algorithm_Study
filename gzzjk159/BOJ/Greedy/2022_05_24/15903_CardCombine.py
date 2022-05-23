n, m = map(int, input().split())
card = list(map(int, input().split()))
card.sort()

answer =0
hab = 0
while m>0:
    hab = card[0]+card[1]
    card[0]=hab
    card[1]=hab
    card.sort()
    m -= 1
answer = sum(card)
print(answer)