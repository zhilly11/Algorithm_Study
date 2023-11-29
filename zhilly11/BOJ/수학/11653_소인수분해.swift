//  Algorithm - 11653_소인수분해.swift
//  Created by zhilly on 2023/05/19

import Foundation

var input: Int = Int(readLine()!)!
var i: Int = 2

while i * i <= input {
    while input % i == 0 {
        print(i)
        input /= i
    }
    i += 1
}

if input != 1 {
    print(input)
}
