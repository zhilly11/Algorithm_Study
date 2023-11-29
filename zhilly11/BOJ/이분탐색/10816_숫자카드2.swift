//  Algorithm - 10816_숫자카드2.swift
//  Created by zhilly on 2023/05/22

import Foundation

// MARK: - 이분탐색 풀이

let n: Int = Int(readLine()!)!
let nArray: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }.sorted()
let m: Int = Int(readLine()!)!
let mArray: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }

for i in 0..<m {
    result.append(solution(item: mArray[i]))
}

print(result.map { String($0) }.joined(separator: " "))

func solution(item: Int) -> Int {
    let first = findFirstIndex(target: item, length: n)
    let last = findLastIndex(target: item, length: n)
    
    return last - first
}

func findFirstIndex(target: Int, length: Int) -> Int {
    var start: Int = 0
    var end: Int = length
    
    while start < end {
        let mid = (start + end) / 2
        
        if nArray[mid] >= target {
            end = mid
        } else {
            start = mid + 1
        }
    }
    
    return start
}

func findLastIndex(target: Int, length: Int) -> Int {
    var start: Int = 0
    var end: Int = length
    
    while start < end {
        let mid = (start + end) / 2
        
        if nArray[mid] > target {
            end = mid
        } else {
            start = mid + 1
        }
    }
    
    return start
}


// MARK: - 해시 풀이
/*
let n: Int = Int(readLine()!)!
let nArray: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }.sorted()
let m: Int = Int(readLine()!)!
let mArray: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }

var dict: [Int: Int] = [:]
var result: [Int] = []

for i in nArray {
    dict.updateValue((dict[i] ?? 0) + 1, forKey: i)
}

for i in mArray {
    result.append(dict[i] ?? 0)
}

print(result.map{ String($0) }.joined(separator: " "))

*/
