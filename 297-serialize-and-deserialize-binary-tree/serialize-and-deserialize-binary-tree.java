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
        StringBuilder str = new StringBuilder();


        if(root==null){
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node =q.poll();

            if(node==null){
                str.append("# ");
                continue;
            }else{
                str.append(node.val+" ");
            }
            q.add(node.left);
            q.add(node.right);

        }

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data==""){
            return null;
        }

        String strs[] = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1;i<strs.length;i++){
        TreeNode parent = q.poll();

            if(!strs[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                parent.left =left;
                q.add(left);

            }

            if(!strs[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
                parent.right =right;
                q.add(right);

            }

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));