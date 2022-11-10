
import Foundation

var n: Int = Int(readLine()!)!

var arr: [Int] = readLine()!.split(separator: " ").map{ Int(String($0))! }

var dp: [Int] = Array(repeating: 1, count: n)

var answer = 1

for i in 1..<n {
    for j in 0..<i {
        if arr[i] > arr[j] {
            dp[i] = max(dp[i], dp[j]+1)
            answer = max(answer, dp[i])
        }
    }
}

var num = answer
var result: [Int] = [Int]()
for i in stride(from: n-1, through: 0, by: -1) {
    if dp[i] == num {
        result.append(arr[i])
        num-=1
    }
}

print(answer)
for i in result.reversed() {
    print(i, terminator: " ")
}
