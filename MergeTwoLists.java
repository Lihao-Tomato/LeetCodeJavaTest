/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode tmpHead = new ListNode(-1);
        ListNode cur3 = tmpHead;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                cur3.next = cur1;
                cur1 = cur1.next;
            } else {
                cur3.next = cur2;
                cur2 = cur2.next;
            }
            cur3 = cur3.next;
        }
        if(cur1 != null){
            cur3.next = cur1;
            cur3 = cur3.next;
        }
        if(cur2 != null){
            cur3.next = cur2;
            cur3 = cur3.next;
        }
        return tmpHead.next;
    }
}