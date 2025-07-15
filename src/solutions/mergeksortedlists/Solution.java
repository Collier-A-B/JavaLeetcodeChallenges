package solutions.mergeksortedlists;

import linked_list_lib.ListNode;

class Solution {
    // working but non-optimal solution
    // The time complexity is O(n*k) where n is the number of nodes in the merged list
    // and k is the number of linked lists.
    public static ListNode mergeKLists(ListNode[] lists) {
        // head of the returned list
        ListNode returnList = null;

        ListNode currentNode = null;
        int lowestValIndx = -1;
        while (true) { 
            int lowestVal = Integer.MAX_VALUE;
            
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null && lists[i].val < lowestVal)
                {
                    lowestVal = lists[i].val;
                    lowestValIndx = i;
                }
            }
            if (lowestVal == Integer.MAX_VALUE)
                break;

            ListNode newNode = new ListNode(lowestVal);
            lists[lowestValIndx] = lists[lowestValIndx].next;

            if (returnList == null) {
                returnList = newNode;
                currentNode = returnList;
            }
            else {
                currentNode.next = newNode;
                currentNode = newNode;
            }
        } 

        return returnList;
    }

    // Divide and conquer approach
    // The time complexity is O(n log k) where n is the number of nodes in the merged list
    // and k is the number of linked lists.
    // This is more optimal than the previous solution.
    public static ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    private static ListNode mergeKListsHelper(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeKListsHelper(lists, left, mid);
        ListNode l2 = mergeKListsHelper(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }
}
