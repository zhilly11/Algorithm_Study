
// ascentnumber_11057

import Foundation

var n: Int = Int(readLine()!)!

var ascent: [[Int]] = Array(repeating: Array(repeating: 1, count: 10), count: 1001)

for i in 2...1000 {
    for j in 0..<10 {
        var sum: Int = 0
        for k in 0...j {
            sum = (sum + ascent[i-1][k]) % 10007
        }
        ascent[i][j] = sum
    }
}

var dp: [Int] = [Int]()
dp.append(0)

for i in 1...1000 {
    var sumDP: Int = 0
    for j in 0..<10 {
        sumDP += ascent[i][j]
    }
    dp.append(sumDP)
}

print(dp[n])
