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
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBSTSub(num, 0, num.length-1);
    }
    public TreeNode sortedArrayToBSTSub(int[] num, int start, int end) {
        if(start>end) return null;
        if(end==start) {
            return new TreeNode(num[start]);
        }
        int mid = (start + end)/2;
        TreeNode tn = new TreeNode(num[mid]);
        TreeNode tleft = sortedArrayToBSTSub(num, start, mid -1);
        TreeNode tright = sortedArrayToBSTSub(num, mid+1, end);
        tn.left = tleft;
        tn.right = tright;
        return tn;
        
    }
}