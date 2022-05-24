//
//  11000_lesson.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/24.
//

import Foundation

let n = Int(readLine()!)!
var lesson = [(Int,Int)]()
var cnt = 0

for _ in 0..<n {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    let (s,e) = (input[0],input[1])
    lesson.append((s,e))
}


lesson.sort{
    if $0.0 == $1.0 {
        return $0.1 < $1.1
    }
    return $0.0 < $1.0
}




//남아있는 수업이 비어있다면 반복문 종료
while !lesson.isEmpty {
    var start = 0
    var i = 0
    
    while i != lesson.count {
        if lesson[i].0 >= start {
            start = lesson[i].1
            lesson.remove(at: i)
        } else {
            i+=1
        }
    }
    
    cnt += 1
}


print(cnt)
