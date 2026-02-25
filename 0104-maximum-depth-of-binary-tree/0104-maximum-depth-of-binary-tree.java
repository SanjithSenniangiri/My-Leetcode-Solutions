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
    public int maxDepth(TreeNode root) {
        int count = 0;
        return max(root, count);
    }

    public int max(TreeNode root, int c)
    {
        if(root == null)
        {
            return c;
        }

        c = Math.max(max(root.left, c+1), max(root.right, c+1));
        return c;
    }
}