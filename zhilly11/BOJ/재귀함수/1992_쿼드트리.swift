//  Algorithm - 1992_쿼드트리.swift
//  Created by zhilly on 2023/05/31

import Foundation

let n: Int = Int(readLine()!)!
var array: [[Int]] = []
var result: String = .init()

for _ in 0..<n {
    array.append(readLine()!.map { Int(String($0))! })
}

func check(_ x: Int, _ y: Int, _ width: Int) -> Bool {
    for i in x..<x+width {
        for j in y..<y+width {
            if array[x][y] != array[i][j] { return false }
        }
    }
    return true
}

func quadTree(_ x: Int, _ y: Int, _ n: Int) {
    // 사각형 체크
    if check(x, y, n) == true {
        result += "\(array[x][y])"
        return
    }
    
    let w = n / 2
    result += "("
    
    // 4등분 해서 한번 더 체크
    for i in 0..<2 {
        for j in 0..<2 {
            quadTree(x + i * w, y + j * w, w)
        }
    }
    
    result += ")"
}

quadTree(0, 0, n)
print(result)
