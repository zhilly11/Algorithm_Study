//  Algorithm - 1920_수찾기.swift
//  Created by zhilly on 2023/05/22

import Foundation

let n: Int = Int(readLine()!)!
let nArray: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }.sorted()
let m: Int = Int(readLine()!)!
let mArray: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }

for i in stride(from: 0, to: m, by: 1) {
    print(binarySearch(target: mArray[i]))
}

func binarySearch(target: Int) -> Int {
    var start: Int = 0
    var end: Int = n - 1
    
    while start <= end {
        var mid: Int = (start + end) / 2
        
        if nArray[mid] < target {
            start = mid + 1
        } else if nArray[mid] > target {
            end = mid - 1
        } else {
            return 1
        }
    }
    
    return 0
}

