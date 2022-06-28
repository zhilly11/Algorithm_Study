//
//  1597_Tournament.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/06/28.
//

import Foundation

var array = readLine()!.split(separator: " ").map{ Int(String($0))! }
var number = array.first
var (x,y) = (array[1],array[2])
var count = 0

while x != y {
    x = x/2 + x%2
    y = y/2 + y%2
    count += 1
}

print(count)

//https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FoVJN3%2FbtqCIFkeONh%2F5KMsN0Ru6PwlLbAzumfJf0%2Fimg.png
