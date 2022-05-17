import Foundation

var N = Int(readLine()!)!
var minus = [Int]()
var plus = [Int]()
var result = 0

for _ in 0..<N {
    let input = Int(readLine()!)!
    
    if (input == 1) {
        result += input
    }
    else if(input > 1){
        plus.append(input)
    }
    else {
        minus.append(input)
    }
}

minus.sort(by: <)
plus.sort(by: >)

if (minus.count % 2 == 1) {
    result += minus.removeLast()
}
if (plus.count % 2 == 1) {
    result += plus.removeLast()
}

while(minus.count > 0 || plus.count > 0){
    if(minus.count > 0){
        result += minus.removeLast()*minus.removeLast()
    }
    if(plus.count > 0){
        result += plus.removeLast()*plus.removeLast()
    }
}

print(result)
