//
//  8980_Delivery.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/31.
//

import Foundation

let info = readLine()!.split(separator: " ").map({Int(String($0))!}) // [마을 개수, 트럭 용량]
let count = Int(readLine()!)!
var nums = [[Int]]() // [출발 마을, 도착 마을, 택배 개수]
var town = Array(repeating: 0, count: info[0]) // 마을 별 적재중인 택배 개수
var answer = 0

for _ in 0..<count {
    nums.append(readLine()!.split(separator: " ").map({Int(String($0))!}))
}

nums.sort {
    if $0[1] != $1[1] {
        return $0[1] < $1[1]
    }
    else {
        return $0[0] < $1[0]
    }
}

for i in 0..<count {
    let max = (town[nums[i][0]-1..<nums[i][1]-1]).max()!
    if max < info[1] {
        let add = nums[i][2] + max > info[1] ? info[1] - max : nums[i][2]
        answer += add // 더해지는 택배 개수를 answer에 추가
        for j in nums[i][0]-1...nums[i][1]-2 {
            town[j] += add // 현재 택배가 지나가는 마을들에 add만큼의 택배 개수를 추가
        }
    }
}

print(answer)


