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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        traverse(root, ls);
        return ls;
    }

    public void traverse (TreeNode ele, List<Integer> ls)
    {
        if(ele == null)
        {
            return;
        }

        traverse(ele.left, ls);
        ls.add(ele.val);
        traverse(ele.right, ls);
    }
}