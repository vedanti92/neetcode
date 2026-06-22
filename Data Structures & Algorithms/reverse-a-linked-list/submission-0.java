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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode present = head;
        ListNode prev = null;

        while (present != null) {
            ListNode temp = present.next;
            present.next = prev;
            prev = present;
            present = temp;
        }

        return prev;
    }
}
