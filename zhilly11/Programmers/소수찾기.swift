//  Algorithm - 소수찾기.swift
//  Created by zhilly on 2023/07/10

import Foundation

func solution(_ numbers: String) -> Int {
    let allNumbers: Set<Int> = getCombinations(numbers)
    var result: Int = 0
    
    allNumbers.forEach { number in
        if isPrime(number) { result += 1 }
    }
    
    return result
}

func getCombinations(_ digits: String) -> Set<Int> {
    var combinations: Set<Int> = []
    
    func getAllNumbers(_ current: String, _ remaining: String) {
        if !current.isEmpty {
            combinations.insert(Int(current) ?? 0)
        }
        
        for i in 0..<remaining.count {
            let index = remaining.index(remaining.startIndex, offsetBy: i)
            let digit = remaining[index]
            
            let nextCurrent = current + String(digit)
            let nextRemaining = remaining.replacingCharacters(in: index...index, with: "")
            
            getAllNumbers(nextCurrent, nextRemaining)
        }
    }
    
    getAllNumbers("", digits)
    
    return combinations
}

func isPrime(_ num: Int) -> Bool {
    if num < 4 {
        return (num <= 1) ? false : true
    } else {
        for i in 2...Int(sqrt(Double(num))) {
            if num % i == 0 {
                return false
            }
        }
    }
    
    return true
}
