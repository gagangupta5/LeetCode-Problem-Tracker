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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next==null || head.next.next==null) return new int[]{-1, -1};
        ListNode curr=head.next;
        ListNode prev=head;
        ListNode fwd=head.next.next;
        ArrayList<Integer> cp=new ArrayList<>();
        int c=2;
        while(fwd!=null){
            if(curr.val>prev.val && curr.val>fwd.val) cp.add(c);
            else if(curr.val<prev.val && curr.val<fwd.val) cp.add(c);
            prev=curr;
            curr=fwd;
            fwd=fwd.next;
            c++;
        }
        if(cp.size()<2) return new int[]{-1, -1};
        int[] res=new int[2];
        res[1]=cp.get(cp.size()-1)-cp.get(0);
        res[0]=cp.get(1)-cp.get(0);
        for(int i=2;i<cp.size();i++){
            res[0]=Math.min(res[0], cp.get(i)-cp.get(i-1));
        }
        return res;
    }
}
