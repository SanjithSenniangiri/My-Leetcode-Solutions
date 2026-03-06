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
    int cur = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        return findk(root, k).val;
        // return ans;        
    }

    public TreeNode findk(TreeNode ele, int k)
    {   
        if(ele == null)
        {
            return null;
        }

        TreeNode left = findk(ele.left, k);

        if(left != null)
        {
            return left;
        }
        cur++;

        if(cur == k)
        {
            return ele;
        }
        return findk(ele.right,k);

    }
}