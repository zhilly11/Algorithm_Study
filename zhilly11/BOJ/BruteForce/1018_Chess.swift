//
//  1018_Chess.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/28.
//

import Foundation

func solution(x:Int, y:Int){
    var color = chess[x][y]
    var cnt = 0

    for i in x..<x+8 {
        for j in y..<y+8 {
            
            // 선택한 체스판의 색이 다르다면
            if chess[i][j] != color {
                cnt += 1
            }
            //다음칸은 색깔이 반대여야 한다.
            color = !color
        }
        
        //다음줄
        color = !color
    }
    
    cnt = min(cnt, 64-cnt)
    result = min(cnt, result)
    
}

var input = readLine()!.split(separator: " ").map{ Int(String($0))! }
var (N,M) = (input[0],input[1])

var array = [String]()
var chess:[[Bool]] = Array(repeating: Array(repeating: false, count: M), count: N)
var result = 64

for _ in 0..<N {
    let input = readLine()!
    array.append(input)
}

for i in 0..<N {
    for j in 0..<M {
        let index = array[i].index(array[i].startIndex, offsetBy: j)
        let value = array[i][index]
        if value == "W" {
            chess[i][j] = true
        }
    }
}

for xIndex in 0..<N-7 {
    for yIndex in 0..<M-7 {
        solution(x: xIndex, y: yIndex)
    }
}

print(result)
