//  Algorithm - 7662_이중우선순위큐.swift
//  Created by zhilly on 2023/06/05

import Foundation

let T: Int = Int(readLine()!)!
var result: String = ""

for _ in 0..<T {
    let k: Int = Int(readLine()!)!
    let tree = BinaryTree<Int>()
    
    for _ in 0..<k {
        let command: [String] = readLine()!.split(separator: " ").map { String($0) }
        
        switch command[0] {
        case "D":
            if command[1] == "1" {
                tree.deleteMax()
            } else if command[1] == "-1" {
                tree.deleteMin()
            }
        case "I":
            tree.insert(value: Int(command[1])!)
        default:
            continue
        }
    }
    
    if tree.isEmpty() {
        result += "EMPTY\n"
    } else {
        result += "\(tree.maxValue()!) \(tree.minValue()!)\n"
    }
}

print(result)

class Node<T: Comparable> {
    var value: T
    var leftChild: Node?
    var rightChild: Node?
    
    init(value: T) {
        self.value = value
    }
}

class BinaryTree<T: Comparable> {
    var root: Node<T>?
    
    // 이진 트리에 값을 삽입하는 메서드
    func insert(value: T) {
        if let root = root {
            insert(value: value, node: root)
        } else {
            root = Node(value: value)
        }
    }
    
    private func insert(value: T, node: Node<T>) {
        if value < node.value {
            if let leftChild = node.leftChild {
                insert(value: value, node: leftChild)
            } else {
                node.leftChild = Node(value: value)
            }
        } else {
            if let rightChild = node.rightChild {
                insert(value: value, node: rightChild)
            } else {
                node.rightChild = Node(value: value)
            }
        }
    }
    
    // 최소값을 삭제하는 메서드
    func deleteMin() {
        guard let root = root else { return }
        
        if root.leftChild == nil {
            self.root = root.rightChild
        } else {
            deleteMin(node: root)
        }
    }
    
    private func deleteMin(node: Node<T>) {
        if let leftChild = node.leftChild {
            if leftChild.leftChild == nil {
                node.leftChild = leftChild.rightChild
            } else {
                deleteMin(node: leftChild)
            }
        } else {
            node.rightChild = nil
        }
    }
    
    // 최대값을 삭제하는 메서드
    func deleteMax() {
        guard let root = root else { return }
        
        if root.rightChild == nil {
            self.root = root.leftChild
        } else {
            deleteMax(node: root)
        }
    }
    
    private func deleteMax(node: Node<T>) {
        if let rightChild = node.rightChild {
            if rightChild.rightChild == nil {
                node.rightChild = rightChild.leftChild
            } else {
                deleteMax(node: rightChild)
            }
        } else {
            node.leftChild = nil
        }
    }
    
    // 최소값을 반환하는 메서드
    func minValue() -> T? {
        return findMin(node: root)?.value
    }
    
    private func findMin(node: Node<T>?) -> Node<T>? {
        guard let node = node else { return nil }
        
        if let leftChild = node.leftChild {
            return findMin(node: leftChild)
        } else {
            return node
        }
    }
    
    // 최대값을 반환하는 메서드
    func maxValue() -> T? {
        return findMax(node: root)?.value
    }
    
    private func findMax(node: Node<T>?) -> Node<T>? {
        guard let node = node else { return nil }
        
        if let rightChild = node.rightChild {
            return findMax(node: rightChild)
        } else {
            return node
        }
    }
    
    // 트리가 비어 있는지 검사하는 메서드
    func isEmpty() -> Bool {
        return root == nil
    }
    
    // 이진 트리를 중위 순회하여 값 출력
    func inOrderTraversal() {
        inOrderTraversal(node: root)
    }
    
    private func inOrderTraversal(node: Node<T>?) {
        guard let node = node else { return }
        
        inOrderTraversal(node: node.leftChild)
        print(node.value)
        inOrderTraversal(node: node.rightChild)
    }
}
