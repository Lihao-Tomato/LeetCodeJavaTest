package binaryTreeTest;

import java.util.*;


class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val){
        this.val = val;
    }
}

public class BinaryTree {

    public Node createTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    // 前序遍历
    void preOrderTraversal(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(Node root){
        if (root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }

    // 后序遍历
    void postOrderTraversal(Node root){
        if (root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root){
        if (root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    int getSize2(Node root){
        if (root == null){
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;  //记得加1,1表示每个树的根节点
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if (root == null){
            return;
        }
        if (root.left==null && root.right==null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
        if (root == null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k){
        if (root == null){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    // 获取二叉树的高度
    int getHeight(Node root){
        if (root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val){
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        Node nodeLeft = find(root.left,val);
        if (nodeLeft != null){
            return nodeLeft;
        }
        Node nodeRight = find(root.right,val);
        if (nodeRight != null){
            return nodeRight;
        }
        return null;
    }

    // 层序遍历
    void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        if (root == null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.val+" ");
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root){
        Queue<Node> queue = new LinkedList<>();
        if (root == null){
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()){
            Node cur = queue.peek();
            if (cur != null){
                return false;
            } else {
                queue.poll();
            }
        }
        return true;
    }

    // 非递归前序遍历（使用栈）
    void preOrderTraversal1(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (cur!=null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    // 非递归中序遍历（使用栈）
    void inOrderTraversal1(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (cur!=null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    // 非递归后序遍历（使用栈）
    void postOrderTraversal1(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;

        while (cur!=null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right==null || cur.right==prev){
                prev = stack.pop();
                System.out.print(cur.val + " ");
                cur = null; //必须置为空
            } else {
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createTree();

        System.out.println("=============前序遍历=============");
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.println("=============中序遍历=============");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.println("=============后序遍历=============");
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("=============求结点个数=============");
        System.out.println(binaryTree.getSize2(root));
        binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);
        System.out.println("=============求叶子结点个数=============");
        System.out.println(binaryTree.getLeafSize2(root));
        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println("=============求第 k 层结点个数=============");
        System.out.println(binaryTree.getKLevelSize(root, 3));
        System.out.println("=============获取二叉树的高度=============");
        System.out.println(binaryTree.getHeight(root));
        System.out.println("=============查找 val 所在结点，没有找到返回 null=============");
        System.out.println(binaryTree.find(root, 'B').val);
        System.out.println("=============层序遍历=============");
        binaryTree.levelOrderTraversal(root);
        System.out.println();

        System.out.println("=============判断一棵树是不是完全二叉树=============");
        System.out.println(binaryTree.isCompleteTree(root));
        System.out.println("******************************************************************");
        System.out.println(widthOfBinaryTree(root));

        System.out.println("=============非递归前序遍历（使用栈）=============");
        binaryTree.preOrderTraversal1(root);
        System.out.println();
        System.out.println("=============非递归中序遍历（使用栈）=============");
        binaryTree.inOrderTraversal1(root);
        System.out.println();
        System.out.println("=============非递归后序遍历（使用栈）=============");
        binaryTree.postOrderTraversal1(root);
    }

    //求二叉树的宽度
    public static int widthOfBinaryTree(Node root) {
        LinkedList<Integer> treeNodeIndex = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return -1;
        }
        treeNodeIndex.add(1);
        int maxWidth = 1; //只有根节点是宽度为1
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int i=0;
            while(i<size){
                Node cur = queue.poll();
                Integer curIndex = treeNodeIndex.removeFirst();
                if(cur.left != null){
                    queue.offer(cur.left);
                    treeNodeIndex.add(curIndex*2); //当前层最左端的结点索引
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    treeNodeIndex.add(curIndex*2+1); //当前层最右端的结点索引
                }
                i++;
            }
            if(treeNodeIndex.size() != 0){
                maxWidth = Math.max(maxWidth, treeNodeIndex.getLast() - treeNodeIndex.getFirst() + 1);
            }
        }
        return maxWidth;
    }
}

