//
//  연속부분.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/20.
//
import Foundation

let N = Int(readLine()!)!
var array = [Double]()

for _ in 0..<N {
    array.append(Double(readLine()!)!)
}

for i in 1..<N {
    array[i] = max(array[i], array[i]*array[i-1])
}

print(String(format: "%.3f", array.max()!))
