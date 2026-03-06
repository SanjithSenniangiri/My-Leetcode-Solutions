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
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right == null)
        {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty())
        {
            TreeNode le = q.poll();
            TreeNode ri = q.poll();



            if(le==null && ri == null)
            {
                continue;
            }

            if(le == null || ri == null)
            {
                return false;
            }

            if(le.val != ri.val)
            {
                return false;
            }

            q.offer(le.right);
            q.offer(ri.left);
            q.offer(le.left);
            q.offer(ri.right); 
        }
        return true;
    }
}