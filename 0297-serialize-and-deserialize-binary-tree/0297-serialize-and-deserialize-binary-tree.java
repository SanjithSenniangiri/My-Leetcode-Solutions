/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root==null)
        {
            sb.append("null");
            return sb.toString();
        } 
        // sb.append(root.val)
        return helper(root, sb).toString();
    }

    public StringBuffer helper(TreeNode root, StringBuffer ans)
    {
        if(root==null)
        {
            ans.append(" null");
            return ans;
        }

        if(ans.isEmpty())
        {
            ans.append(root.val);
        }
        else{
            ans.append(" "+root.val);
        }
        
        ans = helper(root.left, ans);
        ans = helper(root.right, ans);


        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("\\s++");
        List<String> l = new ArrayList<>();
        for(int i=arr.length-1; i>=0; i--)
        {
            if(arr[i].trim().length() == 0)
            {
                continue;
            }
            l.add(arr[i]);
        }

        TreeNode r = construct(l);
        return r;
    }

    public TreeNode construct (List<String> ls)
    {
        if(ls.isEmpty())
        {
            return null;
        }

        if(ls.get(ls.size()-1).equals("null"))
        {
            ls.remove(ls.size()-1);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(ls.get(ls.size() - 1)));
        ls.remove(ls.size()-1);
        root.left = construct(ls);
        root.right = construct(ls);

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));