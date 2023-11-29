//  Algorithm - 11478_서로다른부분문자열의개수.swift
//  Created by zhilly on 2023/05/31

import Foundation

// MARK: - 배열을 활용한 방법

let input: [String] = readLine()!.map { String($0) }
var result: Set<String> = []

for i in 0..<input.count {
    var word: String = ""

    for j in i..<input.count {
        word += String(input[j])
        result.insert(word)
    }
}

print(result.count)

// MARK: - indices를 활용한 방법

let input: String = readLine()!
var result: Set<Substring> = []

for i in input.indices {
    for j in input.indices[i...]{
        result.update(with: input[i...j])
    }
}

print(result.count)
