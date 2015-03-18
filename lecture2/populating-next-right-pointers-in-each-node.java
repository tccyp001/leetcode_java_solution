/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode parentStart = root;
        TreeLinkNode childStart = null;
        while(parentStart!=null)
        {
            TreeLinkNode parentCur = parentStart;
            TreeLinkNode pre = null;
            while(parentCur!=null) {
                if(parentCur.left!=null) {
                      if(pre!=null)pre.next = parentCur.left;
                      else childStart = parentCur.left;
                      pre = parentCur.left;
                }
                if(parentCur.right!=null) {
                      if(pre!=null)pre.next = parentCur.right;
                      else childStart = parentCur.right;
                      pre = parentCur.right;
                }
                parentCur = parentCur.next;
            }
            parentStart= childStart;
            childStart = null;
        }
    }
}

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//Solution 2
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode curLevel = root;
        TreeLinkNode nextLevel = getNextLevelFirst(root);
        TreeLinkNode cur = null;
        while(nextLevel!=null)
        {
            cur = curLevel;
            while(cur!=null)
            {
                if(cur.left!=null && cur.right!=null) {
                    cur.left.next = cur.right;
                    cur.right.next = getNextLevelFirst(cur.next);
                }
                else if(cur.left !=null) {
                    cur.left.next = getNextLevelFirst(cur.next);
                }
                else if(cur.right !=null) {
                    cur.right.next = getNextLevelFirst(cur.next);
                }
                cur = cur.next;
            }
            curLevel = nextLevel;
            nextLevel = getNextLevelFirst(curLevel);
        }
    }
    public TreeLinkNode getNextLevelFirst(TreeLinkNode node1)
    {
        while(node1!=null)
        {
            if(node1.left !=null)return node1.left;
            if(node1.right!=null)return node1.right;
            node1 = node1.next;
        }
        return null;
    }
}