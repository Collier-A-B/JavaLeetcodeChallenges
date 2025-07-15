package solutions.merge_two_sorted_linked_lists;

import linked_list_lib.ListNode;

public class Solution {
    protected static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newListHead = null;
        ListNode lastNode = null;
        while(list1 != null || list2 != null) {
            // new node being created and added to returned list
            ListNode newNode;

            // bool flag that is true if l1 < l2, else false
            boolean addL1Elem;

            // if l1 is null, add element from l2
            // if l2 is null, add element from l1
            // else, add smallest element from l1 or l2
            if (list1 == null) {
                newNode = new ListNode(list2.val);
                addL1Elem = false;
            } else if(list2 == null) {
                newNode = new ListNode(list1.val);
                addL1Elem = true;
            } else {
                if(list1.val < list2.val) {
                    newNode = new ListNode(list1.val);
                    addL1Elem = true;
                } else {
                    newNode = new ListNode(list2.val);
                    addL1Elem = false;
                }
            }

            // if newNode is head of new list, set newListHead
            // otherwise, set the next ptr of node created in prev iteration
            if(newListHead == null) {
                newListHead = newNode;
            } else {
                lastNode.next = newNode;
            }
            lastNode = newNode;

            // use bool flag to iterate through only one of input lists
            if(addL1Elem) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }

        return newListHead;
    }
}
