//  Algorithm - 푸드 파이트 대회.swift
//  Created by zhilly on 2023/06/12

import Foundation

func solution(_ food:[Int]) -> String {
    var frontResult: String = ""
    
    for i in 1..<food.count {
        var item: String = ""

        for _ in 0..<(food[i] / 2) {
            item += String(i)
        }
        
        if item != "" {
            frontResult += item
        }
    }
    
    return frontResult + "0" + frontResult.reversed()
}
