//
//  FibonacciExtension.swift

import Foundation

let n: Int = Int(readLine()!)!

var posArray: [Int] = Array(repeating: 0, count: 1000001)
var negArray: [Int] = Array(repeating: 0, count: 1000001)

posArray[1] = 1
negArray[1] = 1

for i in 2...1000000 {
    posArray[i] = (posArray[i-1] + posArray[i-2]) % 1000000000
    negArray[i] = (negArray[i-2] - negArray[i-1]) % 1000000000
}

if n >= 0 {
    if posArray[n] == 0 {
        print(0)
    } else {
        print(1)
    }
    print(posArray[n])
} else {
    let num: Int = abs(n)
    if negArray[num] < 0 {
        print(-1)
    } else if negArray[num] == 0 {
        print(0)
    } else {
        print(1)
    }
    print(abs(negArray[num]))
}
