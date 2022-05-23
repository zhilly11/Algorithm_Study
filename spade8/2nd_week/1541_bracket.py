import sys

str = sys.stdin.readline().strip()
strlen = len(str)

buf = ""
result = 0
flag = True

for pos, char in enumerate(str):
    if(char == "+"):
        if flag == True:
            result += int(buf)
        else:
            result -= int(buf)
        buf = ""

    elif(char =="-"):
        if flag == True:
            result += int(buf)
        else:
            result -= int(buf)
        buf = ""
        flag = False

    else:
        buf += char


if flag == True:
    result += int(buf)
else:
    result -= int(buf)

print(result)



