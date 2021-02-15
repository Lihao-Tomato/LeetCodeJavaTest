/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int curQueueSize = queue.size();
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while(i < curQueueSize){
                TreeNode tmpNode = queue.poll();
                list.add(tmpNode.val);
                if(tmpNode.left != null){
                    queue.offer(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.offer(tmpNode.right);
                }
                i++;
            }
            resultList.add(list);
        }
        return resultList;
    }
}