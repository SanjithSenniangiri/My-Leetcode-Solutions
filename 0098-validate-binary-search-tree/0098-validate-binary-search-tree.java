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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, long min, long max)
    {
        if(node==null)
        {
            return true;
        }

        if(node.val<=min || node.val>=max) return false;
        return isValid(node.left,min, node.val) && isValid(node.right, node.val, max);
    }
}


        

        // boolean a = true;       
        // boolean b = true;

        // // if((root.left!= null && root.left.val < root.val)&& root.right != null && root.right.val>root.val)
        // // {
        // //      a = isValidBST(root.left);
        // //      b = isValidBST(root.right);
        // // }
        // // else if((root.left!= null && root.left.val > root.val) || root.right != null && root.right.val<root.val)
        // // {
        // //     a = false;
        // // }


        // // else{
        //     return a && b;
        // // }