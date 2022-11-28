//
//  TriangleGraph.swift

import Foundation

var testNumber: Int = 1

while true {
    let n: Int = Int(readLine()!)!
    
    if n == 0 {
        break
    } else {
        var graph: [[Int]] = Array(repeating: Array(repeating: 0, count: 3), count: 100001)
        
        for i in 0..<n {
            let input = readLine()!.split(separator: " ").map{ Int(String($0))! }
            for j in 0..<input.count {
                graph[i][j] = input[j]
            }
        }
        
        graph[1][0] += graph[0][1]
        graph[1][1] = min(graph[1][1] + graph[1][0], graph[0][1] + graph[1][1], graph[0][1] + graph[0][2] + graph[1][1])
        graph[1][2] = min(graph[1][1] + graph[1][2], graph[0][1] + graph[1][2], graph[0][1] + graph[0][2] + graph[1][2])
        
        for i in 2..<n {
            graph[i][0] += min(graph[i-1][0], graph[i-1][1])
            graph[i][1] += min(graph[i][0], graph[i-1][0], graph[i-1][1], graph[i-1][2])
            graph[i][2] += min(graph[i][1], graph[i-1][1] , graph[i-1][2])
        }
        
        print("\(testNumber). \(graph[n-1][1])")
        
        testNumber += 1
    }
}
