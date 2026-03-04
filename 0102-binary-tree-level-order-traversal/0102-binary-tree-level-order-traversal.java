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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
        {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // return ans;

        while(!q.isEmpty())
        {
            int listSize = q.size();
            List<Integer> ls = new ArrayList<>(listSize);
            for(int i=0; i<listSize; i++)
            {
                TreeNode current = q.poll();
                ls.add(current.val);
                if(current.left!=null)
                {
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }
            }
            ans.add(ls);
        }
        return ans;
    }
}