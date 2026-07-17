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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0) return null;
        if(n==1) return lists[0];
        while(n!=1){
            List<ListNode> l=new ArrayList<>();
            int i=0;
            for(i=0;i<n-1;i+=2){
                ListNode temp=merge(lists[i],lists[i+1]);
                l.add(temp);
            }
            if(i==n-1) l.add(lists[i]);
            n=l.size();
            for(i=0;i<n;i++){
                lists[i]=l.get(i);
            }
        }
        return lists[0];
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                curr.next=new ListNode(l2.val);
                l2=l2.next;
            }
            curr=curr.next;
        }
        curr.next=l1==null ? l2 : l1;
        return dummy.next; 
    }

}