import Foundation

var n: Int = Int(readLine()!)!

var wine: [Int] = [Int]()
wine.append(0)

for _ in 0..<n {
    wine.append(Int(readLine()!)!)
}

var dp: [Int] = [Int]()
dp.append(0)
dp.append(wine[1])

if n == 1{
    print(dp[1])
} else if n == 2 {
    dp.append(wine[1] + wine[2])
    print(dp[2])
} else {    // n = 3이상일 때
    dp.append(wine[1] + wine[2])
    for i in 3...n {
        dp.append(max(dp[i-1], dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]))
    }
    print(dp[n])
}
