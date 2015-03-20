/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
public class Solution {
    public class ListNodeWrapper {
        ListNode listNode;
        ListNodeWrapper(ListNode lnode) { listNode = lnode; }
    }
    public TreeNode sortedListToBST(ListNode head) {
         if(head == null)return null;
         ListNode cur = head;
         ListNodeWrapper lnWrapper = new ListNodeWrapper(cur);
         int len = getListLen(cur);
         return listToBST(lnWrapper, len);
    }
    public TreeNode listToBST(ListNodeWrapper lnWrapper, int len)
    {
        if(len==0)return null;
        if(len==1) {
            TreeNode root = new TreeNode(lnWrapper.listNode.val);
            lnWrapper.listNode = lnWrapper.listNode.next;
            return root;
        }
        TreeNode leftNode = listToBST(lnWrapper,len/2);
        TreeNode root = new TreeNode(lnWrapper.listNode.val);
        lnWrapper.listNode = lnWrapper.listNode.next;
        TreeNode rightNode = listToBST(lnWrapper,len - 1- len/2);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
    public int getListLen(ListNode cur) {
        int len = 0;
        while(cur!=null) {
         len ++;
         cur = cur.next;
        }
        return len;
    }
}