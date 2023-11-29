//  Algorithm - 6064_카잉달력.swift
//  Created by zhilly on 2023/05/19

import Foundation

func gcd(_ x: Int, _ y: Int) -> Int {
    if x == 0 { return y }
    return gcd(y % x, x)
}

func lcm(_ x: Int, _ y: Int) -> Int {
    return x / gcd(x, y) * y
}

func solution(m: Int, n: Int, x: Int, y: Int) -> Int {
    var number1 = x
    var number2 = y
    
    if x == m { number1 = 0 }
    if y == n { number2 = 0 }
    
    let lcm = lcm(m, n)
    
    for i in stride(from: number1, through: lcm, by: m) {
        if i % n == number2 {
            if i == 0 { continue }
            return i
        }
    }
    
    return -1
}

var n: Int = Int(readLine()!)!

while n > 0 {
    n -= 1
    let input = readLine()!.split(separator: " ").map{ Int(String($0))! }
    print(solution(m: input[0], n: input[1], x: input[2], y: input[3]))
}
