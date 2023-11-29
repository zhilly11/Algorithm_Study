//  Algorithm - 1351_무한수열.swift
//  Created by zhilly on 2023/06/02

import Foundation

let input: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }
let n: Int = input[0]
let p: Int = input[1]
let q: Int = input[2]
var dict: [Int: Int] = [0: 1]

func recursion(_ i: Int) -> Int {
    if let x = dict[i] { return x }
    dict[i] = recursion(i/p) + recursion(i/q)
    return dict[i]!
}

print(recursion(n))

//func recursion(_ i: Int) -> Int {
//    if i == 0 { return 1 }
//
//    return recursion(i/p) + recursion(i/q)
//}
//print(recursion(n))

// 배열에 저장해두고 0이 아닐때 값을 반환?
// 배열사용하면 시간초과 남
