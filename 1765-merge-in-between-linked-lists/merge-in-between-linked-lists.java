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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        // Move to the node before the a-th node
        for (int i = 1; i < a; i++) {
            preA = preA.next;
        }
        
        ListNode postB = preA;
        // Move to the node after the b-th node
        for (int i = a; i <= b + 1; i++) {
            postB = postB.next;
        }
        
        // Connect preA to the head of list2
        preA.next = list2;
        
        // Find the tail of list2
        ListNode tailList2 = list2;
        while (tailList2.next != null) {
            tailList2 = tailList2.next;
        }
        
        // Connect the tail of list2 to postB
        tailList2.next = postB;
        
        return list1;
    }
}