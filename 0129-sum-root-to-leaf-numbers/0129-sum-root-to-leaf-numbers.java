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
    public int sumNumbers(TreeNode root) {
        return sumFind(root, 0);
    }

    public int sumFind(TreeNode root, int curr) {
        if (root == null) return 0;

        curr = curr * 10 + root.val;

        if (root.left == null && root.right == null) {
            return curr;
        }

        return sumFind(root.left, curr) + sumFind(root.right, curr);
    }

}







// Using list of strings:
    // int sum = 0;
    // List<Integer> ls = new ArrayList<>();
    // public int sumNumbers(TreeNode root) {
    //     sumFind(root, "");
    //     for(int i = 0; i<ls.size(); i++)
    //     {
    //         sum+= ls.get(i);
    //     }
    //     return sum;
    // }

    // public void sumFind(TreeNode root, String s)
    // {
    //      if (root == null) {
    //         return;
    //     }
    //     if(root.left == null && root.right==null)
    //     {
    //         s+=root.val;
    //         ls.add(Integer.valueOf(s));
    //         return;
    //     }

    //     sumFind(root.left, s+root.val);
    //     sumFind(root.right, s+root.val);
    // }