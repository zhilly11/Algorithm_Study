//
//  DNA.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/28.
//

import Foundation

func solution(array: [String]) -> Character {
    var countArray = [Int](repeating: 0, count: 4)
    
    countArray[0] = array.filter { ($0) == "A" }.count
    countArray[1] = array.filter { ($0) == "C" }.count
    countArray[2] = array.filter { ($0) == "G" }.count
    countArray[3] = array.filter { ($0) == "T" }.count
    
    let maxValue = countArray.max() ?? 0
    
    if countArray[0] == maxValue {
        return "A"
    } else if countArray[1] == maxValue {
        return "C"
    } else if countArray[2] == maxValue {
        return "G"
    } else if countArray[3] == maxValue {
        return "T"
    }
    
}

func counting(str: [String],result: String,index: Int) -> Int {
    var cnt = 0
    let index = result.index(result.startIndex, offsetBy: index)
    let value = result[index]
    
    for i in 0..<N {
        if str[i] != String(value) {
            cnt += 1
        }
    }
    
    return cnt
}

var input = readLine()!.split(separator: " ").map{ Int(String($0))! }
var (N,M) = (input[0],input[1])

var array = [String]()
var temp : [[String]] = Array(repeating: Array(repeating: "", count: N), count: M)
var reslut : String = ""
var count = 0

for _ in 0..<N {
    let inputDNA = readLine()!
    array.append(inputDNA)
}

for i in 0..<M {
    for j in 0..<N {
        let index = array[j].index(array[j].startIndex, offsetBy: i)
        let value = array[j][index]
        //print(value)
        temp[i][j] = String(value)
    }
    reslut.append(solution(array: temp[i]))
}

for i in 0..<M {
    count += counting(str: temp[i],result: reslut, index: i)
}

print(reslut)
print(count)
