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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int count = 0;
        return Math.abs(height(root.left, count) - height(root.right, count)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root, int count)
    {
        if(root==null)
        {
            return count;
        }
        
        count= Math.max(height(root.left, count+1), height(root.right, count+1));
        
        return count;

        
    }
}