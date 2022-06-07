//
//  15970_DrawArrow.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/07.
//

import Foundation

let N = Int(readLine()!)!
var array = [Int : [Int]]()
var result = 0

for _ in 0..<N {
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    let(node,color) = (input[0],input[1])
    if array.keys.contains(color) == true {
        array[color]!.append(node)
    } else {
        array[color] = [node]
    }
}

for num in array.keys {
    let temp = array[num]!.sorted()
    
    for i in 1..<temp.count-1{
        result += min(( temp[i] - temp[i-1] ), (temp[i+1] - temp[i]) )
    }
    result += temp[1] - temp[0]
    result += temp[temp.count - 1] - temp[temp.count - 2]
}

print(result)



/*
5
4 1
1 2
3 1
4 2
5 1
 */
