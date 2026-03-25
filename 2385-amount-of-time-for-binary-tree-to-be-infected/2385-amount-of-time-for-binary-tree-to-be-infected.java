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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> m = new HashMap<>();
        // m.add(root, null);
        TreeNode begin = helper(root, m, start);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> s = new HashSet<>();
        int minute = -1;
        q.offer(begin);
        s.add(begin);
        while(!q.isEmpty())
        {
            minute++;
            int size = q.size();
            
            for(int i=0; i<size; i++)
            {
                TreeNode cur = q.poll();
                if(cur.left!=null && !s.contains(cur.left)) 
                {
                    q.offer(cur.left);
                    s.add(cur.left);
                }
                if(cur.right!=null && !s.contains(cur.right))
                {
                    q.offer(cur.right);
                    s.add(cur.right);
                } 
                if(m.containsKey(cur) && !s.contains(m.get(cur))){
                    q.offer(m.get(cur));
                    s.add(m.get(cur));
                }
            }
            
        }
        return minute;

    }

    public TreeNode helper(TreeNode root, Map<TreeNode, TreeNode> m,int start)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode begin = null;
        if(root.val == start)
        {
            begin = root;
        }
        
        if(root.left!=null) {
            m.put(root.left, root);
        }

        if(root.right!=null)
        {
            m.put(root.right, root);
        }
        TreeNode left = helper(root.left, m, start);
        TreeNode right = helper(root.right, m, start);

        if (begin != null) return begin;
        if (left != null) return left;
        return right;
    }
}