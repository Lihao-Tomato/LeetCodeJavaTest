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
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        ListNode cur = tmpHead;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            } else { //加else，考虑有连续要删除的
                cur = cur.next;
            }
        }
        return tmpHead.next;
    }
}