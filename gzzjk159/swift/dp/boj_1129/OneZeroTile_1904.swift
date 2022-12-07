//
//  OneZeroTile.swift

import Foundation

let n: Int = Int(readLine()!)!

var array: [Int] = [Int]()

array.append(0)
array.append(1)
array.append(2)

if n >= 3 {
    for i in 3...n {
        array.append((array[i-1] + array[i-2]) % 15746)
    }
}

print(array[n])
