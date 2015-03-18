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
    public void flatten(TreeNode root) {
        flattenHelper(root,null);
    }
    public TreeNode flattenHelper(TreeNode root, TreeNode tail)
    {
        if(root ==null)return tail;
        root.right = flattenHelper(root.left, flattenHelper(root.right,tail));
        root.left = null;
        return root;
    }
}