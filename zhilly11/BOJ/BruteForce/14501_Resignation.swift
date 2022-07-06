import Foundation

func solve(day: Int) -> Int{
    if (day > N) {
        return -9999
    }
    if (day == N) {
        return 0
    }
    var ret = used[day]
    
    if ret != -1 {
        return ret
    }
    
    ret = max(solve(day: day + 1),solve(day: day + T[day]) + P[day])
    return ret
}

let N = Int(readLine()!)!
var T = [Int]()
var P = [Int]()
var used = [Int](repeating: 0, count: 15)

for i in 0..<N {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    T.append(input[0])
    P.append(input[1])
    used[i] = -1
}

var ret = solve(day: 0)
print(ret)
