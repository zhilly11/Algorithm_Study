//
//  17286_Umee.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/20.
//

import Foundation

func pow(_ x: Int, _ y: Int) -> Double {
  var result = 1
  for _ in 0..<y {
    result *= x
  }
  return Double(result)
}

func dist(x: Int, y: Int, i: Int, j: Int) -> Double{
    let a = x - i
    let b = y - j
    let d = sqrt(Double(a*a) + Double(b*b))
    
    return d
}

let input = readLine()!.split(separator: " ").map{ Int($0)! }
var (x, y) = (input[0],input[1])
var array = [(Int,Int)]()
var min : Double = 100
var result : Double = 0
var index = 0


for _ in 0..<3 {
    let location = readLine()!.split(separator: " ").map{ Int($0)! }
    let (i,j) = (location[0],location[1])
    array.append((i,j))
}

for _ in 0..<3 {
    for q in 0..<array.count {
        let d = dist(x: x, y: y, i: array[q].0, j:array[q].1)
        if min > d {
            min = d
            index = q
        }
    }
    (x,y) = (array[index].0,array[index].1)
    array.remove(at: index)
    result += min
    min = 100
}

print(Int(result))

