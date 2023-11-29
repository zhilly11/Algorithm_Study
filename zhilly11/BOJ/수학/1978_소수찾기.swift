//  1978_소수찾기.swift
//  Created by zhilly on 2023/05/19

import Foundation

func isPrime(num: Int) -> Bool {
    if (num < 4) {
        return num == 1 ? false : true
    }
    for i in 2...Int(sqrt(Double(num))) {
        if (num % i == 0) { return false }
    }
    return true
}

let input: Int = Int(readLine()!)!
let numberArray: [Int] = readLine()!.split(separator: " ").map{ Int(String($0))! }
var result: Int = 0

numberArray.forEach { item in
    if isPrime(num: item) {
        result += 1
    }
}

print(result)

// 월 수금 하는데 월 금
// 연습문제는 다 풀기
// 다음주 월요일 까지 수학

