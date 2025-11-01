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

 //Approach 1 (Brute Force(shows TLE))
class Solution1 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            // Remove matching nodes from the head
            while (head != null && head.val == x) {
                head = head.next;
            }

            // If list becomes empty
            if (head == null) return null;

            // Traverse and remove matching nodes in the rest of the list
            ListNode temp = head;
            while (temp != null && temp.next != null) {
                if (temp.next.val == x) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
        }

        return head;
    }
}


//Approach 2 (Optimised)
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Store all values to delete in a HashSet for O(1) lookup
        Set<Integer> removeSet = new HashSet<>();
        for (int num : nums) removeSet.add(num);

        // Dummy node to simplify deletion at head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null) {
            if (removeSet.contains(curr.next.val)) {
                curr.next = curr.next.next; // delete node
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}