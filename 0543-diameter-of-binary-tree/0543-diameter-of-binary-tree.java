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
    int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root.left ==null && root.right==null) return 0;
        maxGet(root);
        return max;
    }

    public int maxGet(TreeNode ele)
    {
        if(ele == null)
        {
            return 0;
        }

        int left = maxGet(ele.left);
        int right = maxGet(ele.right);

        max = Math.max(max, left+right);
        return Math.max(left, right) + 1 ;
    }
}










//Solution only if passes through root:

// public int diameterOfBinaryTree(TreeNode root) {
//         // if(root.left ==null && root.right==null) return 0;
//         int maxRight =0;
//         int maxLeft =0;
//         if(root.left != null)
//         {
//             maxLeft = maxGet(root.left, maxLeft+1);
//         }
//         if(root.right != null)
//         {
//             maxRight = maxGet(root.right, maxRight+1);
//         }

//         return maxLeft+maxRight;
//     }

//     public int maxGet(TreeNode ele, int max)
//     {
//         if(ele == null)
//         {
//             return max-1;
//         }

//         max = Math.max(maxGet(ele.left, max+1), maxGet(ele.right, max+1));

//         return max;
//     }