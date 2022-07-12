import sys
input = sys.stdin.readline
dwarf = []

for i in range(9) :
    num = int(input().strip())
    dwarf.append(num)
dwarf.sort()

for i in range(9):
    for j in range(i+1,9):
        if sum(dwarf) - dwarf[i] - dwarf[j] == 100:
            del dwarf[j]
            del dwarf[i]
            break
    if len(dwarf) < 9:
        break

for i in range(len(dwarf)):
    print(dwarf[i])

