//  Algorithm - 모의고사.swift
//  Created by zhilly on 2023/06/14

import Foundation

func solution(_ answers:[Int]) -> [Int] {
    let array1: [Int] = [1,2,3,4,5]
    let array2: [Int] = [2,1,2,3,2,4,2,5]
    let array3: [Int] = [3,3,1,1,2,2,4,4,5,5]
    
    var dic: [Int: Int] = [:]
    
    for i in 0..<answers.count {
        if answers[i] == array1[i%array1.count] { dic[1] = (dic[1] ?? 0) + 1 }
        if answers[i] == array2[i%array2.count] { dic[2] = (dic[2] ?? 0) + 1 }
        if answers[i] == array3[i%array3.count] { dic[3] = (dic[3] ?? 0) + 1 }
    }
    
    let max: Int = dic.values.max() ?? 0
    let result = dic.filter { $0.value == max }.keys.map { Int($0) }.sorted()

    return result
}
