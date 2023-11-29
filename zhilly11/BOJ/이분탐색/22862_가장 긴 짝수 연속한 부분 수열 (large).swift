//  Algorithm - 22862_가장 긴 짝수 연속한 부분 수열 (large).swift
//  Created by zhilly on 2023/05/28

import Foundation

let input: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }
let n = input[0], k = input[1]
let array: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }

var start = 0, end = 0
var count = (array[start] & 1) != 0 ? 1 : 0 // 홀수의 개수
var result = 0

while true {
    while end < n - 1 {
        if (array[end + 1] & 1) != 0 {
            if count < k {
                count += 1
            } else {
                break
            }
        }
        end += 1
    }

    if start >= n || end >= n {
        break
    }

    result = max(result, end - start + 1 - count)

    if (array[start] & 1) != 0 {
        count -= 1
    }

    start += 1
}

print(result)
