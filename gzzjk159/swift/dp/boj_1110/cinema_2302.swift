import Foundation

var n: Int = Int(readLine()!)!

var m: Int = Int(readLine()!)!
var vip: [Int] = [Int]()

for _ in 0..<m {
    vip.append(Int(readLine()!)!)
}

var sit: [Int] = [Int]()
sit.append(1)
sit.append(1)
sit.append(2)

for i in 3..<41 {
    sit.append(sit[i-2] + sit[i-1])
}

var answer: Int = 1

if m>0 {
    var pre: Int = 0
    for i in 0..<m {
        answer *= sit[vip[i]-1-pre]
        pre = vip[i]
    }
    answer *= sit[n-pre]
} else {
    answer = sit[n]
}
print(answer)
