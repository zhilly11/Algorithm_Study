
//  BuyCard_11052.swift

import Foundation

var n: Int = Int(readLine()!)!

var card: [Int] = readLine()!.split(separator: " ").map{Int(String($0))!}
card.insert(0, at: 0)

var dp: [Int] = Array(repeating: 0, count: n+1)

for i in 1...n {
    for j in 1...i {
        dp[i] = max(dp[i], dp[i-j] + card[j])
    }
}

print(dp[n])
