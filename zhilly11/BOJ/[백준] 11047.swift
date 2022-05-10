//
//  [백준] 11047.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/10.
//

import Foundation

func returnIndex(num : Int) -> Int {
    var countIndex = 0
    for i in array {
        if(num < i){
            break
        }
        else{
            countIndex += 1
        }
    }
    return (countIndex-1)
}

var input = readLine()!.split(separator: " ").map { Int(String($0))! }
var N = input[0]
var K = input[1]
var num = K
var count = 0
var array = [Int](repeating: 0, count: N)

for i in 0..<N {
    array[i] = Int(readLine()!)!
}

while(num > 0) {
    num -= array[returnIndex(num: num)]
    count += 1
}

print(count)
