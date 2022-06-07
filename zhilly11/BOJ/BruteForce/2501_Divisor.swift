//
//  2501_Divisor.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/07.
//

import Foundation

let input = readLine()!.split(separator: " ").map{ Int(String($0))! }
let (N,K) = (input[0],input[1])

var count = 0

for i in 1...N{
    if N % i == 0 {
        count += 1
        if K == count {
            print(i)
        }
    }
}

if K > count {
    print(0)
}
