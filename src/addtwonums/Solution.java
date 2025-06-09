package addtwonums;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        boolean carryover = false;

        ListNode listRoot = null;
        ListNode newNode = null;
        ListNode lastNode = null;

        // iterate through both list until reached end of one or both
        while (l1 != null && l2 != null){
            newNode = new ListNode(l1.val + l2.val);

            if (carryover) {
                newNode.val += 1;
                carryover = false;
            }
            
            if(newNode.val > 9){
                carryover = true;
                newNode.val = newNode.val % 10;
            }

            if (listRoot == null)
                listRoot = newNode;
            else
                lastNode.next = newNode;
            lastNode = newNode;

            l1 = l1.next;
            l2 = l2.next;
        }

        // iterate through rest of l1 if there are more nodes
        while(l1 != null){
            newNode = new ListNode(l1.val);
            if (carryover)
            {
                newNode.val += 1;
                carryover = false;
            }
            if (newNode.val > 9){
                carryover = true;
                newNode.val = newNode.val % 10;
            }
            lastNode.next = newNode;
            lastNode = newNode;

            l1 = l1.next;
        }

        // iterate through rest of l2 if there are more nodes
        while(l2 != null){
            newNode = new ListNode(l2.val);
            if (carryover)
            {
                newNode.val += 1;
                carryover = false;
            }
            if (newNode.val > 9){
                carryover = true;
                newNode.val = newNode.val % 10;
            }
            lastNode.next = newNode;
            lastNode = newNode;

            l2 = l2.next;
        }

        return listRoot;
    }
}
