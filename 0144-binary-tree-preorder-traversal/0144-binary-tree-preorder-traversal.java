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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        // ls.add(root);
        traverse(root, ls);
        return ls;
    }

    public void traverse(TreeNode ele, List<Integer> ls)
    {
        if(ele == null)
        {
            return;
        }

        // List<Integer> ls = new ArrayList<>();
        ls.add(ele.val);
        traverse(ele.left, ls);
        traverse(ele.right, ls);

        // ls.addAll(left);
        // ls.addAll(right);
        // return ls;
    }
}