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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode curr=head;
        ListNode fwd=null;
        ListNode prev=null;
        head=head.next;
        while(curr!=null && curr.next!=null){
            fwd=curr.next;
            if(prev!=null) prev.next=fwd;
            curr.next=fwd.next;
            fwd.next=curr;
            prev=curr;
            curr=curr.next;
        }
        return head;
    }
}