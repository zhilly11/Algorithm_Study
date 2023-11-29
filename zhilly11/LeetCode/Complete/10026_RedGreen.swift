//
//  10026_RedGreen.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/08/09.
//

import Foundation

var n = Int(readLine()!)!
var direction = [(-1,0),(1,0),(0,1),(0,-1)]
var image = Array(repeating: [String](), count: n)
var RGImage = image
var countImg = 0
var countRGImg = 0

for y in 0..<n{
    var colors = readLine()!
    image[y] = colors.map{String($0)}
    colors = colors.replacingOccurrences(of: "G", with: "R")
    RGImage[y] = colors.map{String($0)}
}

for y in 0..<n{
    for x in 0..<n{
        if image[y][x] != "V"{
            dfs(currentX: x, currentY: y, image: &image)
            countImg += 1
        }
        if RGImage[y][x] != "V"{
            dfs(currentX: x, currentY : y, image: &RGImage)
            countRGImg += 1
        }
    }
}
print("\(countImg) \(countRGImg)")

func dfs(currentX x : Int, currentY y : Int, image : inout[[String]]){
    var stack = [(Int,Int)]()
    let char = image[y][x]
    
    stack.append((x,y))

    while(stack.count != 0){
        let coord = stack.popLast()!
        for (dx,dy) in direction{
            let nx = dx + coord.0
            let ny = dy + coord.1
            if nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1 {
                continue
            }
            if image[ny][nx] == char {
                stack.append((nx,ny))
                //방문한 노드는 V로
                image[ny][nx] = "V"
            }
        }

    }
}
