//  Algorithm - 2295_세수의합.swift
//  Created by zhilly on 2023/05/24

import Foundation

let n: Int = Int(readLine()!)!
var array: [Int] = []
var sumArray: [Int] = []

for _ in 0..<n {
    array.append(Int(readLine()!)!)
}

array = array.sorted()

for i in 0..<n {
    for j in i..<n {
        sumArray.append(array[i] + array[j])
    }
}

array = array.reversed()
sumArray = sumArray.sorted()
solution()

func solution() {
    for i in 0..<n {
        for j in 0..<n {
            if binarySearch(target: array[i] - array[j]) == 1 {
                print(array[i])
                return
            }
        }
    }
}

func binarySearch(target: Int) -> Int {
    var start: Int = 0
    var end: Int = sumArray.count - 1

    while start <= end {
        let mid: Int = (start + end) / 2

        if sumArray[mid] < target {
            start = mid + 1
        } else if sumArray[mid] > target {
            end = mid - 1
        } else {
            return 1
        }
    }

    return 0
}
