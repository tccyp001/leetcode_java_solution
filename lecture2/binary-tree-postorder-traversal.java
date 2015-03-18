//https://leetcode.com/problems/binary-tree-postorder-traversal/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*Solution1  modified version of preorder */
/*
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> retList = new ArrayList<Integer>();
        if(root==null)return retList;
        Stack<TreeNode> nStack = new Stack<TreeNode>();
        nStack.push(root);
        TreeNode cur = null;
        while(cur!=null || !nStack.isEmpty()) {
            if(cur==null) cur = nStack.pop();
            else {
                  retList.add(cur.val);
                  if(cur.left!=null) nStack.push(cur.left);
                  cur = cur.right;
            }
        }
        Collections.reverse(retList);
        return retList;
    }
}
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* Solution2: use the previous point */
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null)return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        stack.push(root);
        TreeNode cur = null; 
        while(!stack.isEmpty()) {
            cur = stack.pop();
            if((cur.left==null && cur.right ==null) || (cur.right !=null && cur.right == pre)
                 || (cur.right == null && cur.left == pre)) {
                ret.add(cur.val);
                pre = cur;
            }
            else if(cur.left==null || (cur.left==pre && cur.right!=null)) {
                stack.push(cur);
                stack.push(cur.right);
            }
            else {
                stack.push(cur);
                stack.push(cur.left);
            }
        }
        return ret;
    }
}