## Tree

- Tree는 계층적인(부모-자식) 자료를 표현하기 위해 사용되는 비선형 자료구조이다.
- **노드(Node)** 로 이루어져 있으며, 각 노드는 데이터를 저장하고, 다른 노드들과 연결됩니다.
- 순환(Cycle)이 없는 그래프입니다.


### 1. 트리의 종류
- 이진 트리 (Binary Tree): 각 노드가 최대 두 개의 자식 노드를 가질 수 있는 트리.
- 이진 탐색 트리 (Binary Search Tree, BST): 이진 트리의 한 종류로, 왼쪽 자식 노드는 부모 노드보다 작고, 오른쪽 자식 노드는 부모 노드보다 크다.

</br></br>

### 2. Binary Search Tree Example code

```java
import jdk.incubator.vector.VectorOperators;

// 이진 탐색 트리 예제 소스코드
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private TreeNode<Integer> root;

    public BinarySearchTree() {
        this.root = null;
    }
    
    // 삽입
    public void insert(int data) {
        root = insertRecursive(root, data);
    }
    
    private TreeNode<Integer> insertRecursive(TreeNode<Integer> node, int data) {
        if(node == null){
            return new TreeNode<>(data); // 새로운 노드를 생성하여 반환
        }
        if(value < node.data){
            node.left = insertRecursive(node.left, data); // 왼쪽 서브트리에 삽입
        } else if(value > root.data){
            node.right = insertRecursive(node.right, data); // 오른쪽 서브트리에 삽입
        }
        return node;
    }
    
    // 탐색
    public boolean search(int data) {
        return searchRecursive(root, data);
    }
    
    private boolean searchRecursive(TreeNode<Integer> node, int data) {
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }
        return data < node.data ? searchRecursive(node.left, data) : searchRecursive(node.right, data);
    }
    
    // 순회
    // left -> parent -> right
    public void inorder() {
        inorderRecursive(root);
    }
    
    private void inorderRecursive(TreeNode<Integer> node) {
        if(node != null){
            inorderRecursive(node.left);
            System.out.print(node.data + " ");
            inorderRecursive(node.right);
        }
    }
    
    // parent -> left -> right
    public void preorder() {
        preorderRecursive(root);
    }
    
    private void preorderRecursive(TreeNode<Integer> node) {
        if(node != null){
            System.out.print(node.data + " ");
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }
    
    // left -> right -> parent
    public void postorder() {
        postorderRecursive(root);
    }
    
    private void postorderRecursive(TreeNode<Integer> node) {
        if(node != null){
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    } 
}

```
</br></br>

### 2. 문제점

- 편향 트리 문제
: 편향 트리는 트리의 한쪽으로만 노드가 계속 추가되어 트리의 높이가 증가하는 현상입니다.
: 이진 탐색 트리의 시간 복잡도가 최악의 경우 O(n)으로 증가하여, 배열이나 연결 리스트와 같은 선형 자료구조와 다를 바 없게 됩니다.
: 해결 방법 
: - AVL 트리
: - Red-Black 트리


