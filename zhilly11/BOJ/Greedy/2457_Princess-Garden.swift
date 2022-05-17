import Foundation

let N = Int(readLine()!)!
var array : [[Int]] = Array(repeating: Array(repeating: 0, count: 4), count: N)
var flowers = [(Int,Int)]()

for i in 0..<N {
    array[i] = readLine()!.split(separator: " ").map{ Int(String($0))! }
    let (s,e) = (array[i][0]*100+array[i][1],array[i][2]*100+array[i][3])
    flowers.append((s,e))
    
}


flowers.sort{
    //앞에 값이 같으면
    if $0.0 == $1.0 {
        //뒤에 값이 큰 순으로
        return $0.1 > $1.1
    }
    
    //오름차순으로
    return $0.0 < $1.0
}


var startDay = 301
var endDay = 1201
var index = 0
var max = 0
var count = 0

while(startDay<endDay){
    var flag = false
    
    for i in index...N {
        if(flowers[i].0 > startDay){
            //print(flowers[i])
            break
        }
        
        if(max < flowers[i].1){
            flag = true
            max = flowers[i].1
            index = i+1
        }
        
    }
    
    if(flag){
        startDay = max
        count+=1
    }
    else {
        break
    }
}

if(max < endDay) {
    print(0)
}
else {
    print(count)
}

