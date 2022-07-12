n, m = map(int, input().split())
dna = []
for i in range(n):
    data = input()
    dna.append(data)

result = []
word = ['A','C','G','T']
hamming_distance = 0
for i in range(m):
    acgt = [0,0,0,0]
    for j in range(n):
        if dna[j][i] == 'A':
            acgt[0] += 1
        if dna[j][i] == 'C':
            acgt[1] += 1
        if dna[j][i] == 'G':
            acgt[2] += 1
        if dna[j][i] == 'T':
            acgt[3] += 1
    max_char = max(acgt)
    max_index = acgt.index(max_char)
    result.append(word[max_index])
    hamming_distance += sum(acgt) - max_char

print(''.join(result))
print(hamming_distance)

