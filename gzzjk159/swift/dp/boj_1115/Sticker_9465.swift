
//  Sticker_9465.swift

import Foundation

var t: Int = Int(readLine()!)!

for _ in 0..<t {
    let n: Int = Int(readLine()!)!
    
    let input1: [Int] = readLine()!.split(separator: " ").map{Int(String($0))!}
    let input2: [Int] = readLine()!.split(separator: " ").map{Int(String($0))!}
    
    var arr: [[Int]] = [[Int]]()
    var dp: [[Int]] = Array(repeating: Array(repeating: 0, count: n), count: 2)
    
    arr.append(input1)
    arr.append(input2)
    dp[0][0] = arr[0][0]
    dp[1][0] = arr[1][0]
    
    if n == 1 {
        print(max(arr[0][0], arr[1][0]))
        continue
    } else {
        dp[0][1] = arr[0][1] + arr[1][0]
        dp[1][1] = arr[0][0] + arr[1][1]
        for j in 2..<n {
            dp[0][j] = max(arr[0][j] + dp[1][j-1], arr[0][j] + dp[1][j-2])
            dp[1][j] = max(arr[1][j] + dp[0][j-1], arr[1][j] + dp[0][j-2])
        }
        print(max(dp[0][n-1], dp[1][n-1]))
    }
    
}
