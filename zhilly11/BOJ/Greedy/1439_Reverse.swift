//
//  1439_Reverse.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/24.
//

import Foundation

let N = readLine()!
var array = [Character]()
var count: [Int] = [0,0]

array.append(N[N.startIndex])
countPlus(str: array[0])

for i in 1..<N.count {
    //다음 문자를 배열에 추가해준다.
    array.append(N[N.index(N.startIndex, offsetBy: i)])
    
    //추가된 문자가 전에 문자와 다르다면 count를 해준다.
    if array[i-1] != N[N.index(N.startIndex, offsetBy: i)] {
        countPlus(str: array[i])
    }
}

func countPlus(str: Character) {
    if str == "0" {
        count[0] += 1
    } else {
        count[1] += 1
    }
}

print(count.min()!)
