import Foundation

func solution(index: Int, num: Int) {
    used[num] = true
    
    for i in index+1..<N {
        solution(index: i, num: num + array[i])
    }
}

let N = Int(readLine()!)!
var array = readLine()!.split(separator: " ").map{ Int(String($0))! }
var used = [Bool](repeating: false, count: 2000001)
var count = 0

used[0] = true

for i in 0..<N {
    solution(index: i, num: array[i])
}

for i in used {
    if i == false {
        break
    } else {
        count += 1
    }
}

print(count)
