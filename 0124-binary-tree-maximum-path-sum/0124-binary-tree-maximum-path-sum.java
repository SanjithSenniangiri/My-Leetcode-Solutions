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
    int  maxGlobal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathEachNode(root, 0);
        return maxGlobal;
    }

    public int maxPathEachNode(TreeNode root, int sum){
        if(root == null)
        {
            return 0;
        }

        // if(root.left == null && root.right == null){
        //     sum+=
        // }

        int left = maxPathEachNode(root.left, sum);
        int right = maxPathEachNode(root.right, sum);

        left = Math.max(0, left);
        right = Math.max(0, right);
        int localMax = left + right+ root.val;
        maxGlobal = Math.max(maxGlobal, localMax);
        return root.val + Math.max(left, right);
    }
}