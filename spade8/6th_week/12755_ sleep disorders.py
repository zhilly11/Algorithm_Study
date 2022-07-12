import sys
input = sys.stdin.readline

n = int(input())
word_list = ''
n_cnt = n
for i in range(1, n+1):
    word = str(i)
    n_cnt -= len(word)
    if n_cnt <= 0:
        print(word[n_cnt-1])
        break


