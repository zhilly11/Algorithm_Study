//  Algorithm - 귤고르기.swift
//  Created by zhilly on 2023/06/29

import Foundation

func solution(_ k: Int, _ tangerine: [Int]) -> Int {
    var k = k
    var countDictionary: [Int: Int] = [:]
    var rankArray: [(number: Int, count: Int)] = []
    var result: Int = 0
    
    tangerine.forEach {
        if let count = countDictionary[$0] {
            countDictionary[$0] = count + 1
        } else {
            countDictionary[$0] = 1
        }
    }
    
    rankArray = countDictionary.sorted { $0.value > $1.value }.map { ($0.key, $0.value) }
    
    for item in rankArray {
        if k <= 0 { break }
        
        if item.count > k {
            result += 1
            break
        } else {
            result += 1
            k -= item.count
        }
    }
    
    return result
}
