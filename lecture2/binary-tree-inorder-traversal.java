//https://leetcode.com/problems/binary-tree-inorder-traversal/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<Integer>();
        Stack<TreeNode> nStack = new Stack<TreeNode>();
        while(root!=null || !nStack.isEmpty()) {
            if(root == null) {
                    root = nStack.pop();
                    retList.add(root.val);
                    root = root.right;
            }
            else {
                nStack.push(root);
                root = root.left;
            }
        }
        return retList;
    }
}