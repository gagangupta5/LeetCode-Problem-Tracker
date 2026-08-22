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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        int count=0;
        while(head!=null && head.next!=null){
            if(head.val==head.next.val){
                count++;
                head.next=head.next.next;
            }
            else{
                if(count>0){
                    count=0;
                }
                else{
                    prev.next=head;
                    prev=prev.next;
                }
                head=head.next;
            }
            if(count==0) prev.next=head;
            else prev.next=null;
        }
        return dummy.next;
    }
}
