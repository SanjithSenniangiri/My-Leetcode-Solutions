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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
        {
            return ans;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerFirst(root);
        int level = 0;
        while(!q.isEmpty())
        {
            int listSize = q.size();
            List<Integer> ls = new ArrayList<>(listSize);
            if(level%2 ==0)
            {
                for(int i=0; i<listSize; i++)
                {
                    TreeNode current = q.pollFirst();
                    ls.add(current.val);
                    
                    if(current.left!=null)
                    {
                        q.offerLast(current.left);
                    }
                    if(current.right!=null)
                    {
                        q.offerLast(current.right);
                    }
                }
                level++;

            }
            else{
                 for(int i=0; i<listSize; i++)
                    {
                        TreeNode current = q.pollLast();
                        ls.add(current.val);
                        if(current.right!=null)
                        {
                            q.offerFirst(current.right);
                        }
                        if(current.left!=null)
                        {
                            q.offerFirst(current.left);
                        }
                    }
                    level++;
            }
            ans.add(ls);
        }
        return ans;
    }
}