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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xLoc = findNode(root, x);
        TreeNode yLoc = findNode(root, y);

        return (level(root, xLoc, 0) == level(root, yLoc, 0)) && (!isSibling(root, xLoc, yLoc)); 
    }

    public TreeNode findNode(TreeNode root, int val)
    {
        if(root == null)
        {
            return null;
        }

        if(root.val == val)
        {
            return root;
        }

        TreeNode n = findNode(root.left, val);
        if(n == null)
        {
            n = findNode(root.right, val);
        }

        return n;
    }


    public int level (TreeNode root, TreeNode ele, int l)
    {
        if (root == null)
        {
            return -1;
        }

        if(root == ele)
        {
            return l;
        }

        int lev = level(root.left, ele, l+1);
        if(lev == -1)
        {
            lev= level (root.right, ele, l+1);
        }

        return lev;
    }

    public boolean isSibling(TreeNode root, TreeNode x, TreeNode y)
    {
        if(root == null)
        {
            return false;
        }

        return (root.left == x && root.right == y) || (root.left==y && root.right == x) || isSibling(root.left,x,y) || isSibling(root.right, x,y);
    }
}