/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public TreeNode prev = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Convert(pRootOfTree.left);
        pRootOfTree.left = prev;
        if(prev != null){
            prev.right = pRootOfTree;
        }
        prev = pRootOfTree;
        Convert(pRootOfTree.right);
        
        while(pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
}