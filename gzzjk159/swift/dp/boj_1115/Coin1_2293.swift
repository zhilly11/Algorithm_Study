//
//  Coin1_2293.swift

import Foundation

let input = readLine()!.split(separator: " ").map{Int(String($0))!}
let n: Int = input[0]
let k: Int = input[1]

var coins: [Int] = [Int]()
for _ in 0..<n {
    coins.append(Int(readLine()!)!)
}

var dp: [Int] = Array(repeating: 0, count: k+1)
dp[0] = 1

for coin in coins {
    for j in 1...k {
        if j-coin >= 0 {
            dp[j] += dp[j-coin]
            if dp[j] > Int(pow(2.0, 31.0)){ dp[j] = 0 }
        }
    }
}

print(dp[k])
