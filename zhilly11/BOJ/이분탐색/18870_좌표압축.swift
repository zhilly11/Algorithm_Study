//  Algorithm - 18870_좌표압축.swift
//  Created by zhilly on 2023/05/22

import Foundation

// MARK: - 이분탐색 풀이

let n: Int = Int(readLine()!)!
let nArray: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }
let uniqueArray: [Int] = Array(Set(nArray)).sorted()
var result: [Int] = []

for i in 0..<n {
    result.append(binarySearch(target: nArray[i]))
}

print(result.map { String($0) }.joined(separator: " "))

func binarySearch(target: Int) -> Int {
    var start: Int = 0
    var end: Int = uniqueArray.count - 1
    
    while start <= end {
        let mid: Int = (start + end) / 2
        
        if uniqueArray[mid] < target {
            start = mid + 1
        } else if uniqueArray[mid] > target {
            end = mid - 1
        } else {
            return mid
        }
    }
    
    return -1
}


// MARK: - 해시 풀이
/*
let n: Int = Int(readLine()!)!
let nArray: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }
var dict: [Int: Int] = [:]
var next: Int = 0

for i in nArray.sorted() {
    if dict[i] == nil {
        dict[i] = next
        next += 1
    }
}

print(nArray.map{ String(dict[$0]!) }.joined(separator: " "))
*/
