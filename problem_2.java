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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=null;
        ListNode newHead=res;
        int c=0;
        while(l1!=null && l2!=null){
            int sum=l1.val+l2.val+c;
            int x=sum%10;
            c=sum/10;
            ListNode temp=new ListNode(x);
            if(res==null){
                newHead=res=temp;
            }
            else{
                res.next=temp;
                res=res.next;
            }
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=l1.val+c;
            int x=sum%10;
            c=sum/10;
            ListNode temp=new ListNode(x);
            if(res==null){
                newHead=res=temp;
            }
            else{
                res.next=temp;
                res=res.next;
            }
            l1=l1.next;
        }
        while(l2!=null){
            int sum=l2.val+c;
            int x=sum%10;
            c=sum/10;
            ListNode temp=new ListNode(x);
            if(res==null){
                newHead=res=temp;
            }
            else{
                res.next=temp;
                res=res.next;
            }
            l2=l2.next;
        }
        if(c==1){
            ListNode temp=new ListNode(c);
            res.next=temp;
        }
        return newHead;
    }
}