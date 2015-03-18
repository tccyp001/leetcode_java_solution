//https://leetcode.com/problems/binary-tree-preorder-traversal/
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null)return ret;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = null;
        stack.push(root);
        while(cur!=null || !stack.isEmpty())
        {
            if(cur==null)cur = stack.pop();
            ret.add(cur.val);
            if(cur.right!=null)stack.push(cur.right);
            cur = cur.left;
        }
        return ret;
        
    }
}