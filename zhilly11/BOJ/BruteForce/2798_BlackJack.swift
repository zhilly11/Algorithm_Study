//
//  2798_BlackJack.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/07.
//

import Foundation

let input = readLine()!.split(separator: " ").map{ Int(String($0))! }
let cards = readLine()!.split(separator: " ").map{ Int(String($0))! }

print(blackJack(N: input[0], M: input[1], array: cards))


func blackJack(N: Int, M: Int, array: [Int]) -> Int{
    var max = 0
    for i in 0..<N-2 {
        for j in i+1..<N-1 {
            for k in j+1..<N {
                let result = (array[i] + array[j] + array[k])
                if result <= M && max < result {
                    max = result
                }
            }
        }
    }
    return max
}

// 5 6 7 8 9
