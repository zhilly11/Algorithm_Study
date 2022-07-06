//
//  9663_Nqueen.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/07/05.
//

import Foundation

var count = 0
let N = Int(readLine()!)!
var board = [Int](repeating: 0, count: N)

func promising(cdx: Int) -> Int {
    for i in 0..<cdx {
        if (board[cdx] == board[i] || cdx - i == abs(board[cdx] - board[i])) {
            return 0
        }
    }
    return 1
}

func nqueen(cdx: Int) {
    if (cdx == N) {
        count += 1
        return
    }
    
    for i in 0..<N {
        board[cdx] = i
        if (promising(cdx: cdx) != 0) {
            nqueen(cdx: cdx + 1)
        }
    }
}

nqueen(cdx: 0)
print(count)


/*
 let N = Int(readLine()!)!

 var col = Array(repeating: false, count: N)
 var downRightCol = Array(repeating: false, count: (2 * N) - 1)
 var downLeftCol = Array(repeating: false, count: (2 * N) - 1)

 var count = 0

 func dfs(depth: Int) {
     
     if depth == N {
         count += 1
         return
     }
     
     for i in 0..<N {
         
         if !(col[i] || downRightCol[depth + i] || downLeftCol[depth - i + N - 1]) {
             
             col[i] = true
             downRightCol[depth + i] = true
             downLeftCol[depth - i + N - 1] = true
             
             dfs(depth: depth + 1)
             
             col[i] = false
             downRightCol[depth + i] = false
             downLeftCol[depth - i + N - 1] = false
             
         }
     }
 }

 dfs(depth: 0)
 print(count)
 */
