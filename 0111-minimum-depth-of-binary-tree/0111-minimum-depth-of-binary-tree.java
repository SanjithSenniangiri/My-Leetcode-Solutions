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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int count =1;
        return calcDepth(root, count);
    }

    public int calcDepth(TreeNode ele, int c)
    {
        if (ele.left == null && ele.right==null)
        {
            return c;
        }

        if(ele.left== null)
        {
            return calcDepth(ele.right, c+1);
        }
        if(ele.right==null)
        {
            return calcDepth(ele.left, c+1);
        }

        int l = calcDepth(ele.left, c+1);
        int r = calcDepth(ele.right, c+1);
        c = Math.min(l,r);
        return c;
    }
}