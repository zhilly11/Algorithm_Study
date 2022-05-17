import Foundation

let minusSplit = readLine()!.split(separator:"-").map{String($0)}

var result = 0

for i in 0..<minusSplit.count {
    let temp = minusSplit[i].split(separator: "+").map{Int(String($0))!}\
    
    if(i==0){
        result += temp.reduce(0){ $0 + $1 }
    }
    else{
        result -= temp.reduce(0){ $0 + $1 }
    }
}

print(result)
