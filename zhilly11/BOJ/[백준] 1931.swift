//
//  [백준] 1931.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/10.
//

import Foundation

let n = Int(readLine()!)!
var talks = [(Int,Int)]()

for _ in 0..<n {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    let (s,e) = (input[0],input[1])
    talks.append((s,e))
}

talks.sort{
    if $0.1 == $1.1 {
        return $0.0 < $1.0
    }
    return $0.1 < $1.1
}

var end = 0
var cnt = 0

for (s,e) in talks {
    if s >= end {
        end = e
        cnt += 1
    }
}
print(cnt)
