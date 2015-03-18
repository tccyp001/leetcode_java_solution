/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
         ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if(root == null)return ret;
        
        Queue<TreeNode> parent = new LinkedList<TreeNode>();
        Queue<TreeNode> child = new LinkedList<TreeNode>();
        parent.offer(root);
        ArrayList<Integer> curlevelList = new  ArrayList<Integer>();
        while(!parent.isEmpty())
        {
            TreeNode cur = parent.remove();
            curlevelList.add(cur.val);
            if(cur.left!=null)child.offer(cur.left);
            if(cur.right!=null)child.offer(cur.right);
            
            if(parent.isEmpty())
            {
                ret.add(new ArrayList<Integer>(curlevelList));
                curlevelList.clear();
                Queue<TreeNode> tmp = parent;
                parent = child;
                child = tmp;
            }
        }
        return ret;
    }
}