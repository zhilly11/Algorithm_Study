//
//  3number.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/20.
//

import Foundation

let input = readLine()!.split(separator: " ").map{ Int($0)! }
let (N,M) = (input[0],input[1])
let S = readLine()!.split(separator: " ").map{ Int($0)! }
var check : [Bool] = 

var minValue = 100000

for i in 1...1001 {
    if S.contains(i) == true { continue }
    for j in i...1001 {
        if S.contains(j) == true { continue }
        for k in j...1001 {
            if S.contains(k) == true { continue }
            minValue = min(minValue,abs(N - i*j*k))
            if minValue == 0 { break }
        }
    }
}

print(minValue)


