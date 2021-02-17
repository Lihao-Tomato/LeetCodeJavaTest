/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return tmpList;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int i = 0;
            tmpList = new ArrayList<>();
            while(i < size){
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if(tmpNode.left != null){
                    queue.offer(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.offer(tmpNode.right);
                }
                i++;
            }
            list.add(tmpList);
        }
        List<Integer> reusltList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            tmpList = list.get(i);
            reusltList.add(tmpList.get(tmpList.size()-1));
        }
        return reusltList;
    }
}