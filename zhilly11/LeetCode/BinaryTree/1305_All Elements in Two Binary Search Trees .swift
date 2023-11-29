//  Algorithm - 1305_All Elements in Two Binary Search Trees .swift
//  Created by zhilly on 2023/06/09

import Foundation

class Solution {
    func getAllElements(_ root1: TreeNode?, _ root2: TreeNode?) -> [Int] {
        return (inOrder(tree: root1) + inOrder(tree: root2)).sorted()
    }

    private func inOrder(tree: TreeNode?) -> [Int] {
        var result: [Int] = []
        guard let tree = tree else { return result }

        inOrderTraversal(tree: tree, result: &result)

        return result
    }

    private func inOrderTraversal(tree: TreeNode, result: inout [Int]) {
        if let left = tree.left {
            inOrderTraversal(tree: left, result: &result)
        }

        result.append(tree.val)

        if let right = tree.right {
            inOrderTraversal(tree: right, result: &result)
        }
    }
}
