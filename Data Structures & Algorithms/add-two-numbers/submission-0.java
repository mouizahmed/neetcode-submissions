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
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        while (cur != null) {
            int sum = cur.val;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;

            cur.val = sum % 10;
            int carry = sum / 10;
            if (carry > 0) cur.next = new ListNode(carry);
            else if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null)) cur.next = new ListNode(0);

            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyNode;
    }
}
