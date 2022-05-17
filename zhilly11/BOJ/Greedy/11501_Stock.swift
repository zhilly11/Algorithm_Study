import Foundation

var T = Int(readLine()!)!
var N = [Int]()
var array = [[Int]]()
var total = [Int]()

for i in 0..<T {
    let input_N = Int(readLine()!)!
    let input_array = readLine()!.split(separator: " ").map{ Int(String($0))! }
    N.append(input_N)
    array.append(input_array)
    
    
    var maxValue = 0
    var temp = 0
    
    for value in array[i].reversed() {
        if value >= maxValue {
            maxValue = value
        }
        else {
            temp += maxValue - value
        }
    }
    total.append(temp)
}

for i in 0..<total.count {
    print(total[i])
}
