//
//  12755_Sleep_Disorder.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/19.
//

import Foundation

var N = Int(readLine()!)!
var res = ""
var now = 1

while String(now).count < N {
    res = String(now)
    N -= String(now).count
    now += 1
}

res = String(now)
let index = res.index(res.startIndex, offsetBy: N - 1)
print(res[index])

//12345678910111213
