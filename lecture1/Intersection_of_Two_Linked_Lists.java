/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /* Solution1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listA_set = new HashSet<ListNode>();
        HashSet<ListNode> listB_set = new HashSet<ListNode>();
        while(headA!=null) {
            if(listA_set.contains(headA))break; // there is a circle
            listA_set.add(headA);
            headA = headA.next;
        }
        while(headB!=null) {
            if(listA_set.contains(headB)) return headB;
            if(listB_set.contains(headB))return null; // there is a circle
            listB_set.add(headB);
            headB = headB.next;
        }
        return null;
    }
}
*/
/* Solution2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLinkedListLen(headA);
        int lenB = getLinkedListLen(headB);
        if(lenA>lenB) return findIntersectionNode(headA, headB, lenA - lenB);
        else return findIntersectionNode(headB, headA, lenB - lenA);
            
    }
    private ListNode findIntersectionNode(ListNode headA, ListNode headB, int lenDiff) {
        for(int i=0;i<lenDiff;i++) headA = headA.next;
        while(headA!=null && headB!=null) {
            if(headA==headB)return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private int getLinkedListLen(ListNode head) {
        int len = 0;
        while(head!=null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
*/
//Solution3
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB ==null)return null;//need this otherwise...
        boolean isFirstTimeA = true;
        boolean isFirstTimeB = true;
        boolean continue1 = true;
        ListNode pA = headA;
        ListNode pB = headB;
        while(continue1) {
            if(pA == null) {
                if(isFirstTimeA) {
                    isFirstTimeA = false;
                    pA = headB;
                }
                else continue1 = false;
                
            }
            if(pB == null) {
                if(isFirstTimeB) {
                    isFirstTimeB = false;
                    pB = headA;
                }
                else continue1 = false;
            }
            if(pA == pB)return pA;
            pA = pA.next;
            pB = pB.next;
        }
        return null;    
    }
}