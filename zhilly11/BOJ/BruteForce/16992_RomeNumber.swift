//
//  16992_RomeNumber.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/07/05.
//

import Foundation

func solution(cnt: Int, number: Int, idx: Int) {
    if (cnt == n) {
        if (arr[number] == true) {
            return
        }
        arr[number] = true
        result += 1
        return
    }
    
    for i in idx..<4 {
        solution(cnt: cnt + 1, number: number + num[i], idx: i)
    }
}

var n = Int(readLine()!)!
var num = [1,5,10,50]
var arr = [Bool](repeating: false, count: 1001)
var result = 0

solution(cnt: 0, number: 0, idx: 0)

print(result)
