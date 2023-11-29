//  Algorithm - 땅따먹기.swift
//  Created by zhilly on 2023/07/04

import Foundation

func solution(_ land: [[Int]]) -> Int {
    var land = land
    
    for i in 0..<(land.count - 1) {
        land[i+1][0] += max(land[i][1], max(land[i][2], land[i][3]))
        land[i+1][1] += max(land[i][0], max(land[i][2], land[i][3]))
        land[i+1][2] += max(land[i][0], max(land[i][1], land[i][3]))
        land[i+1][3] += max(land[i][0], max(land[i][1], land[i][2]))
    }
 
    if let last = land.last {
        return last.max() ?? 0
    }
    
    return 0
}
