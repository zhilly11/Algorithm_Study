//
//  LCS.swift

import Foundation

let inputArray1 = Array(readLine()!)
let inputArray2 = Array(readLine()!)

var dp: [[Int]] = Array(repeating: Array(repeating: 0, count: inputArray2.count+1), count: inputArray1.count+1)

for i in 1...inputArray1.count {
    for j in 1...inputArray2.count {
        if inputArray1[i-1] == inputArray2[j-1] {
            dp[i][j] = dp[i-1][j-1] + 1
        } else {
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        }
    }
}

print(dp[inputArray1.count][inputArray2.count])
