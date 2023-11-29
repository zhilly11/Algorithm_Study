//  Algorithm - 653_Two Sum IV - Input is a BST .swift
//  Created by zhilly on 2023/06/07

import Foundation

class Solution {
    var result: Set<Int> = []
    
    func findTarget(_ root: TreeNode?, _ k: Int) -> Bool {
        guard let val = root?.val else { return false }
        
        if result.contains(k - val) {
            return true
        }
        
        result.insert(val)
        
        return findTarget(root?.left, k) || findTarget(root?.right, k)
    }
}
