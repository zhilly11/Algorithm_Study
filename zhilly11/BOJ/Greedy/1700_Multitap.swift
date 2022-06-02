import Foundation

let info = readLine()!.split(separator: " ").map({Int(String($0))!})
var use = readLine()!.split(separator: " ").map({Int(String($0))!}) // 사용 순서 대기열
var multitap = Array(repeating: 0, count: info[0]) // 구 개수만큼 0으로 채운 멀티탭 배열
var answer = 0

use.reverse()

while use.count > 0 {
    print("use: ",use)
    print("multitap: ",multitap)
    print("")
    //멀티탭에 빈 공간이 있을 경우
    //0을 포함하는 경우로 체크
    if multitap.contains(0) {
        //멀티탭이 순서의 마지막을 가지고 있으면
        if multitap.contains(use.last!) {
            //순서 마지막 제거
            use.removeLast()
        }
        //멀티탭에 순서의 마지막을 안가지고 있으면
        else {
            //순서 마지막을 멀티탭에 0을 가진 첫번째 자리에 할당
            multitap[multitap.firstIndex(of: 0)!] = use.removeLast()
        }
    }
    
    // 멀티탭에 빈 공간 없을 경우
    else {
        // 멀티탭이 순서의 마지막을 가지고 있으면
        if multitap.contains(use.last!) {
            // 순서의 마지막 제거
            use.removeLast()
        }
        // 멀티탭이 순서의 마지막을 포함하고 있지 않으면
        else {
            var min = use.count
            var check = 0
            //멀티탭 배열 검사
            for j in multitap {
                // 사용순서 배열에 존재하지 않는 물건을 발견했다면 해당 물건을 멀티탭에서 제거하면 된다.
                if !use.contains(j) {
                    check = j;
                    break
                }
                //순서가 제일 늦는 물건의 위치를 min에 저장
                else if use.lastIndex(of: j)! < min {
                    min = use.lastIndex(of: j)!
                    
                }
            }
            // min이 처음 그대로라면 멀티탭에 꽂힌 물건들 모두가 use배열에 존재하지 않는다.
            if min == use.count
            {
                multitap[0] = use.removeLast()
                
            }
            // check가 0이아니라면 어떠한 물건이 use에 존재하지 않는다.
            else if check != 0
            {
                multitap[multitap.firstIndex(of: check)!] = use.removeLast()
                
            }
            // 위 두 조건에 걸리지 않는다면 멀티탭의 모든 물건이 use에 존재한다.
            else {
                //가장 순서가 늦는 물건의 멀티탭에서의 위치를 찾아 빼고 순서가 다가온 물건을 넣어주었다
                multitap[multitap.firstIndex(of: use[min])!] = use.removeLast()
                
            }
            answer += 1
        }
    }
}

print(answer)


/*
 contains 는 문자열이나 배열에 특정 문자의 포함 여부를 Boolean값으로 리턴해주는 함수
 */
