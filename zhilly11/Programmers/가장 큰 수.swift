//  Algorithm - 가장 큰 수.swift
//  Created by zhilly on 2023/07/05

import Foundation

func solution(_ numbers:[Int]) -> String {
    let sorted: [Int] = numbers.sorted{
        let s1 = Int("\($0)\($1)")!
        let s2 = Int("\($1)\($0)")!
        
        return s1 > s2
    }
    
    if sorted[0] == 0 {
        return "0"
    }
    
    return sorted.reduce(""){ "\($0)" + "\($1)" }
}
