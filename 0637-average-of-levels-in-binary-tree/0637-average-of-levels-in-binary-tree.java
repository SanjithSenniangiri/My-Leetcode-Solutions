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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Double> ls = new ArrayList<>();

        while(!q.isEmpty())
        {
            int levelSize = q.size();
            double avg = 0;
            for(int i=0; i<levelSize; i++)
            {
                TreeNode currentNode = q.poll();
                avg+=currentNode.val;

                if(currentNode.left !=null)
                {
                    q.offer(currentNode.left);
                }
                if(currentNode.right !=null)
                {
                    q.offer(currentNode.right);
                }
            }
            avg/=levelSize;
            ls.add(avg);
        }

        return ls;
    }
}