//https://leetcode.com/problems/balanced-binary-tree/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution 1 using RetInfo
/*
public class Solution {
    public class RetInfo
    {
        public boolean isValid;
        public int height;
        public RetInfo(int height, boolean isValid)
        {
            this.isValid = isValid;
            this.height  =height;
        }
    }
    public boolean isBalanced(TreeNode root) {
        RetInfo retInfo =isBalancedHelper(root); 
        return retInfo.isValid;
    }
     public RetInfo isBalancedHelper(TreeNode root) {
        if(root == null) return new RetInfo(0,true);
        if(root.left == null && root.right ==null)return new RetInfo(1,true);
        
        RetInfo leftRet = isBalancedHelper(root.left);
        RetInfo rightRet = isBalancedHelper(root.right);
        
        boolean isBalanced = leftRet.isValid && rightRet.isValid && Math.abs(leftRet.height - rightRet.height) <=1;
        return new RetInfo(Math.max(leftRet.height, rightRet.height)+1,isBalanced);
    }
}
*/
// use -1 to indicate 
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(balancedHeight(root)>=0)return true;
        return false;
    }
    public int balancedHeight(TreeNode root)
    {
        if(root == null)return 0;
        if(root.left==null && root.right==null)return 1;
        
        int leftHeight = balancedHeight(root.left);
        int rightHeight = balancedHeight(root.right);
        
        if(leftHeight!=-1 && rightHeight !=-1  && Math.abs(leftHeight - rightHeight)<=1)
            return Math.max(leftHeight, rightHeight) +1;
            
        return -1;
    }
}