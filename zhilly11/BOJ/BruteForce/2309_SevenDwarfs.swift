//
//  2309_SevenDwarfs.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/07.
//
import Foundation

func solution(nums: [Int]) -> [Int]{
    var array = nums
    for i in 0..<8{
        for j in i..<9{
            let temp1 = array.remove(at: j)
            let temp2 = array.remove(at: i)
            
            let result = array.reduce(0, +)
            if result == 100 {
                return array
            }
            
            array.append(temp1)
            array.append(temp2)
            array.sort()
        }
    }
    return array
}


var input = [Int]()

for _ in 0..<9 {
    input.append(Int(readLine()!)!)
}
input.sort()

for i in solution(nums: input) {
    print(i)
}

