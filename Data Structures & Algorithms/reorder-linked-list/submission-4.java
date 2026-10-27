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
    public void reorderList(ListNode head) {
       if (head == null || head.next == null) return;

       // find the middle
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
       }

       // split and reverse the second half
       ListNode second = reverse(slow.next);
       slow.next = null;

       // merge the two halves
       ListNode first = head;
       while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
       }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

/*
Pattern: Reverse + Merge

Time: O(n)
Space: O(1)

*/

