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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
        {
            TreeNode n = new TreeNode(val);
            return n;
        }
        TreeNode r = root;
        if(r.val>val)
        {
            r.left = insertIntoBST(r.left, val);
        }
        else{
            r.right = insertIntoBST(r.right, val);
        }

        return r;
    }
}