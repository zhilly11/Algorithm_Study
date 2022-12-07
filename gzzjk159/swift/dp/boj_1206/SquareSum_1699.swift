//
import Foundation

let n: Int = Int(readLine()!)!

var dp: [Int] = [Int]()

for i in 0...n {
    dp.append(i)
}

for i in 1...n {
    for j in 1...i {
        if j*j > i {
            break
        }
        if dp[i] > dp[i-j*j] + 1 {
            dp[i] = dp[i-j*j] + 1
        }
    }
}

print(dp[n])
