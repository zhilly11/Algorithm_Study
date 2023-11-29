//  Algorithm - 영어 끝말잇기.swift
//  Created by zhilly on 2023/06/25

import Foundation

func solution(_ n:Int, _ words:[String]) -> [Int] {
    var answers: [String: Int] = [:]
    
    answers.updateValue(1, forKey: words[0])
    
    for i in 1..<words.count {
        // 종료조건
        // 기존에 있던 단어인가
        // 앞 단어의 끝 글자와 현재 단어의 첫 글자가 다른가
        
        if answers[words[i]] == 1 || (words[i-1].last! != words[i].first!) {
            return [i % n + 1, i / n + 1]
        }
        
        answers.updateValue(1, forKey: words[i])
    }
    
    return [0, 0]
}
