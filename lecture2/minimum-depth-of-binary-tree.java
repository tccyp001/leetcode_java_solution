//https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
       // if(root.left==null && root.right ==null) return 1; //it would be more clear, but the truth is we don't need it
        if(root.left==null) return 1 + minDepth(root.right);
        if(root.right==null) return 1 + minDepth(root.left);
        return 1+ Math.min(minDepth(root.left), minDepth(root.right));
    }
}
