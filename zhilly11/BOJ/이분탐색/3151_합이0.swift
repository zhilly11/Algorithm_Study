//  Algorithm - 3151_합이0.swift
//  Created by zhilly on 2023/05/25

import Foundation

let n: Int = Int(readLine()!)!
let array: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }.sorted()

var sumArray: [Int] = []
var indexArray: [[Int]] = []
var result: Int = 0
print(array)





for i in 0..<n {
    for j in i+1..<n {
        sumArray.append(array[i] + array[j])
        indexArray.append(Array([i, j]))
    }
}

for i in 0..<sumArray.count {
    let firstIndex = indexArray[i][0]
    let secondIndex = indexArray[i][1]
    let sum = sumArray[i]
    
    print("first: \(firstIndex)")
    print("second: \(secondIndex)")
    print("sum: \(sum)")
    
    for sumArrayIndex in 0..<n {
        
        if sumArrayIndex != firstIndex
            && sumArrayIndex != secondIndex
            && sum == -array[sumArrayIndex] {
            
            print("result index = ", sumArrayIndex)
            print("result = ",-array[sumArrayIndex])
            print("결과: ", array[firstIndex], array[secondIndex], array[sumArrayIndex])
            result += 1
        }
    }
}

print(sumArray)
print(sumArray.count)
print(indexArray)
print(result)
