package mergeksortedlists;

public class MergeKSortedListsDriver {
    public static void main(String[] args) {
        // Test Case 1: Example from instructions
        // Input: lists = [[1,4,5],[1,3,4],[2,6]]
        // Output: [1,1,2,3,4,4,5,6]
        ListNode[] test1 = new ListNode[3];
        test1[0] = createList(new int[]{1, 4, 5});
        test1[1] = createList(new int[]{1, 3, 4});
        test1[2] = createList(new int[]{2, 6});
        System.out.println("Test Case 1:");
        System.out.println("Input:");
        printLists(test1);
        ListNode result1 = Solution.mergeKListsDivideAndConquer(test1);
        System.out.println("Output:");
        printList(result1);
        System.out.println("Expected: [1,1,2,3,4,4,5,6]\n");

        // Test Case 2: Empty array
        // Input: lists = []
        ListNode[] test2 = new ListNode[0];
        System.out.println("Test Case 2:");
        System.out.println("Input: []");
        ListNode result2 = Solution.mergeKListsDivideAndConquer(test2);
        System.out.println("Output:");
        printList(result2);
        System.out.println("Expected: []\n");

        // Test Case 3: Array containing empty list
        // Input: lists = [[]]
        ListNode[] test3 = new ListNode[1];
        test3[0] = null;
        System.out.println("Test Case 3:");
        System.out.println("Input: [[]]");
        ListNode result3 = Solution.mergeKListsDivideAndConquer(test3);
        System.out.println("Output:");
        printList(result3);
        System.out.println("Expected: []\n");

        // Additional test cases
        // Test Case 4: Lists with single elements
        ListNode[] test4 = new ListNode[3];
        test4[0] = createList(new int[]{1});
        test4[1] = createList(new int[]{2});
        test4[2] = createList(new int[]{3});
        System.out.println("Test Case 4:");
        System.out.println("Input:");
        printLists(test4);
        ListNode result4 = Solution.mergeKListsDivideAndConquer(test4);
        System.out.println("Output:");
        printList(result4);
        System.out.println("Expected: [1,2,3]\n");

        // Test Case 5: Lists with negative numbers
        ListNode[] test5 = new ListNode[2];
        test5[0] = createList(new int[]{-2, 1, 4});
        test5[1] = createList(new int[]{-1, 0, 3});
        System.out.println("Test Case 5:");
        System.out.println("Input:");
        printLists(test5);
        ListNode result5 = Solution.mergeKListsDivideAndConquer(test5);
        System.out.println("Output:");
        printList(result5);
        System.out.println("Expected: [-2,-1,0,1,3,4]\n");
    }

    // Helper method to create a linked list from an array
    private static ListNode createList(int[] values) {
        if (values == null || values.length == 0) return null;
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a single linked list
    private static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(",");
            }
            head = head.next;
        }
        System.out.println("]");
    }

    // Helper method to print an array of linked lists
    private static void printLists(ListNode[] lists) {
        System.out.print("[");
        for (int i = 0; i < lists.length; i++) {
            printList(lists[i]);
            if (i < lists.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
