//
//  2170_LineDrawing.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/31.
//

import Foundation

let n = Int(readLine()!)!
var lines = [(Int,Int)]()

for _ in 0..<n {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    let (s,e) = (input[0],input[1])
    lines.append((s,e))
}

lines.sort{
    if $0.0 == $1.0 {
        return $0.1 < $1.1
    }
    return $0.0 < $1.0
}

var start = lines[0].0
var end = lines[0].1
var count = 0

for i in 1..<lines.count {
    if (end < lines[i].0) {
        count += end - start
        start = lines[i].0
        end = lines[i].1
    } else if lines[i].1 > end {
        end = lines[i].1
    }
}
count += end - start

print(count)
