
import Foundation

let n = Int(readLine()!)!

let array = readLine()!.split(separator: " ").map{Int(String($0))!}

let m = Int(readLine()!)!

var dp: [[Int]] = Array(repeating: Array(repeating: 0, count: n), count: n)

for num in 0..<n {
    for start in 0..<n-num {
        var end = start + num
        
        if start == end {
            dp[start][end] = 1
        } else if array[start] == array[end] {
            if start + 1 == end {
                dp[start][end] = 1
            } else if dp[start+1][end-1] == 1 {
                dp[start][end] = 1
            }
        }
    }
}

for _ in 0..<m {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    print(dp[input[0]-1][input[1]-1])
}
