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
    int sum = 0;
    List<Integer> ls = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        sumFind(root, "");
        for(int i = 0; i<ls.size(); i++)
        {
            sum+= ls.get(i);
        }
        return sum;
    }

    public void sumFind(TreeNode root, String s)
    {
         if (root == null) {
            return;
        }
        if(root.left == null && root.right==null)
        {
            s+=root.val;
            ls.add(Integer.valueOf(s));
            return;
        }

        sumFind(root.left, s+root.val);
        sumFind(root.right, s+root.val);
    }
}