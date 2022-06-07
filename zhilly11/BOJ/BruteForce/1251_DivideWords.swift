//
//  1251_DivideWords.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/07.
//

import Foundation

let str = Array(readLine()!)
let len = str.count
var array = [String]()

for i in 0..<len - 2 {
    for j in i + 1..<len - 1 {
        let first = Array(str[0...i].reversed())
        let second = Array(str[i + 1...j].reversed())
        let third = Array(str[j + 1..<len].reversed())
        
        let comb = (first + second + third)
            .map { String($0) }
            .joined()
        
        array.append(comb)
    }
}

array.sort()

print(array[0])
