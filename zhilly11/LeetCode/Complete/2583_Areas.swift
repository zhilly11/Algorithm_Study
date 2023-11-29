//
//  2583_Areas.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/08/09.
//

import Foundation

let info = readLine()!.split(separator: " ").map({Int(String($0))!})
let m = info[0]
let n = info[1]
let k = info[2]
var paper = Array(repeating: Array(repeating: 0, count: n), count: m)
// 정답 담을 배열
var area = [Int]()
var area_tmp = 0

// 직사각형들 그려주기
for _ in 0..<k {
    let draw = readLine()!.split(separator: " ").map({Int(String($0))!}) // 직사각형 좌표
    
    for i in draw[0]..<draw[2] {
        for j in draw[1]..<draw[3] {
            paper[j][i] += 1
        }
    }
}

// dfs 재귀함수
func dfs(_ x: Int, _ y: Int) {
    if x < 0 || x >= m || y < 0 || y >= n || paper[x][y] != 0 { return }
    
    paper[x][y] = 1 // 이미 체크한 자리는 1로 바꿔주기
    area_tmp += 1 // area_tmp 1 증가시켜주기
    
    // 재귀 호출 (현재 자리와 붙어있는 주변 모든 자리 확인)
    dfs(x+1, y) // 세로로 다음 자리
    dfs(x-1, y) // 세로로 전 자리
    dfs(x, y+1) // 가로로 다음 자리
    dfs(x, y-1) // 가로로 전 자리
}

// 메인 실행문
for i in 0..<n {
    for j in 0..<m {
        if paper[j][i] == 0 {
            area_tmp = 0
            dfs(j, i)
            area.append(area_tmp)
        }
    }
}

print(area.count)
print(area.sorted().map({String($0)}).joined(separator: " "))
