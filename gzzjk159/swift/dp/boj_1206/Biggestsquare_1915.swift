
import Foundation

let nm = readLine()!.split(separator: " ").map{ Int(String($0))! }

let n = nm[0]
let m = nm[1]
var arr: [[Int]] = [[Int]]()

var dp = Array(repeating: Array(repeating: 0, count: m), count: n)

for _ in 0..<nm[0] {
    arr.append(Array(readLine()!).map{ Int(String($0))! })
}
var answer: Int = 0

for i in 0..<n {
    for j in 0..<m {
        if i == 0 || j == 0 {
            dp[i][j] = arr[i][j]
        } else if arr[i][j] == 0 {
            dp[i][j] = 0
        } else {
            dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
        }
        answer = max(dp[i][j], answer)
    }
}

print(answer * answer)
