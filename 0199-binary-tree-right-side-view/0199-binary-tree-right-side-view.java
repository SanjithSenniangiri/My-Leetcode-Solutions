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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerFirst(root);

        while(!q.isEmpty())
        {
            int listSize = q.size();
            TreeNode n = q.peekLast();
            ans.add(n.val);
            for(int i=0; i<listSize; i++)
            {
                TreeNode current = q.pollLast();
                // ans.add(current.val);
                if(current.right!=null)
                {
                    q.offerFirst(current.right);
                }
                if(current.left!=null)
                {
                    q.offerFirst(current.left);
                }
            }
        }
        return ans;
    }
}