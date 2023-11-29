//  Algorithm - 700_Search in a Binary Search Tree.swift
//  Created by zhilly on 2023/06/07

import Foundation

class Solution {
    func searchBST(_ root: TreeNode?, _ val: Int) -> TreeNode? {
        guard let root = root else { return nil }
        
        if root.val == val {
            return root
        }
        
        if root.val > val {
            return searchBST(root.left, val)
        }
        
        if root.val < val {
            return searchBST(root.right, val)
        }
        
        return nil
    }
}
