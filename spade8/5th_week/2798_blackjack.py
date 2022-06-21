n,m = map(int, input().split())
cards = list(map(int, input().split()))
max = 0
for i in range(n):
    for j in range(i+1 ,n):
        for k in range(j+1 , n):
            sum_cards = cards[i] + cards[j] + cards[k]
            if max < sum_cards and sum_cards <= m:
                max = sum_cards

print(max)
