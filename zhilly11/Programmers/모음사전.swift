//  Algorithm - 모음사전.swift
//  Created by zhilly on 2023/06/30

import Foundation

func solution(_ word: String) -> Int {
    var wordList: [String] = []
    let characters = "AEIOU"

    func allWord(_ count: Int, _ w: String) {
        if count == 5 {
            return
        }
        
        for i in 0..<characters.count {
            let index = characters.index(characters.startIndex, offsetBy: i)
            let newWord = w + String(characters[index])
            wordList.append(newWord)
            allWord(count + 1, newWord)
        }
    }
    
    allWord(0, "")

    return wordList.firstIndex(of: word)! + 1
}
