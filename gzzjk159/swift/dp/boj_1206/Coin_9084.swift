
import Foundation

let t: Int = Int(readLine()!)!

for _ in 0..<t {
    let n = Int(readLine()!)!
    let coin = readLine()!.split(separator: " ").map{Int(String($0))!}
    let m = Int(readLine()!)!
    
    var dp = Array(repeating: 0, count: m+1)
    dp[0] = 1
    
    for i in coin {
        for j in 1...m {
            if j-i >= 0 {
                dp[j] += dp[j-i]
            }
        }
    }
    print(dp[m])
}
