import java.util.*;

class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val){
        this.val = val;
    }
}

public class Main{
    public static int i = 0;
    public static Node createTreeByString(String str){
        Node root = null;
        if(str.charAt(i) != '#'){
            root = new Node(str.charAt(i));
            i++;
            root.left = createTreeByString(str);
            root.right = createTreeByString(str);
        } else {
            i++;
        }
        return root;
    }
    
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            Node root = createTreeByString(str);
            inOrderTraversal(root);
        }
    }
    
}