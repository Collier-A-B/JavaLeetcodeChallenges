package solutions.merge_two_sorted_linked_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import linked_list_lib.ListNode;



public class MergeTwoSortedLinkedListsDriver {
    
    // holds the integer values of failed tests
    private static Set<Integer> FAILED_TESTS = new HashSet<>();
    
    public static void main(String[] args) {
        // holds arrays representing list1 for each testcase
        List<int[]> list1Instances = new ArrayList<>();

        // holds arrays representing list2 for each testcase
        List<int[]> list2Instances = new ArrayList<>();

        // holds arrays representing expected output for each testcase
        List<int[]> expectedOutputs = new ArrayList<>();

        // Test Case 1
        int[] l1Test1 = {1,2,4};
        int[] l2Test1 = {1,3,4};
        int[] expectedTest1 = {1,1,2,3,4,4};

        list1Instances.add(l1Test1);
        list2Instances.add(l2Test1);
        expectedOutputs.add(expectedTest1);

        // Test Case 2
        int[] l1Test2 = {};
        int[] l2Test2 = {};
        int[] expectedTest2 = {};

        list1Instances.add(l1Test2);
        list2Instances.add(l2Test2);
        expectedOutputs.add(expectedTest2);

        // Test Case 3
        int[] l1Test3 = {};
        int[] l2Test3 = {0};
        int[] expectedTest3 = {0};

        list1Instances.add(l1Test3);
        list2Instances.add(l2Test3);
        expectedOutputs.add(expectedTest3);

        // Run Test cases
        int testNum;
        for(testNum = 0; testNum < list1Instances.size(); testNum++) {
            runTestCase(list1Instances.get(testNum), list2Instances.get(testNum), expectedOutputs.get(testNum), testNum+1);
        }
        
        // print results of all tests
        System.out.println("\n****************************************************************");
        System.out.println("\n\t\tALL TESTS RUN. YOUR RESULTS ARE...");
        System.out.println("\n\tTESTS PASSED: " + (testNum - FAILED_TESTS.size()));
        System.out.println("\tTESTS FAILED: " + FAILED_TESTS.size());

        if(FAILED_TESTS.isEmpty()) {
            System.out.println("\n\tALL TESTS PASSED. SOLUTION ACCEPTED");
        } else {
            System.out.println("\n\tAT LEAST ONE TEST FAILED. SOLUTION REJECTED");
        }

        System.out.println("\n****************************************************************");
    }

    private static void runTestCase(int[] l1, int[] l2, int[] expectedOutput, int testNum) {
        System.out.println("\n****************************************************************");
        System.out.println("\n\t\tTEST CASE " + testNum);

        System.out.println("\n\tList1: " + Arrays.toString(l1));
        System.out.println("\tList2: " + Arrays.toString(l2));
        System.out.println("\tExpected Result: " + Arrays.toString(expectedOutput));

        int[] methodReturn = linkedListToArray(
                                Solution.mergeTwoLists(arrayToLinkedList(l1), arrayToLinkedList(l2))
                            );
        System.out.println("\tMethod Returned: " + Arrays.toString(methodReturn));

        if (Arrays.equals(methodReturn, expectedOutput)){
            System.out.println("\n\tTEST PASSED");
        } else {
            System.out.println("\n\tTEST FAILED");
            FAILED_TESTS.add(testNum);
        }

        System.out.println("\n****************************************************************");
    }

    private static ListNode arrayToLinkedList(int[] array) {
        if (array.length == 0)
            return null;

        ListNode listHead = null;
        ListNode lastNode = null;
        for (int elem : array) {
            ListNode listElem = new ListNode(elem);

            if (listHead == null) {
                listHead = listElem;
            } else {
                lastNode.next = listElem;
            }

            lastNode = listElem;

        }

        return listHead;
    }

    private static int[] linkedListToArray(ListNode listHead) {
        List<Integer> retList = new ArrayList<>();
        ListNode current = listHead;
        while (current != null) {
            retList.add(current.val);
            current = current.next;
        }
        // Convert List<Integer> to int[]
        return retList.stream().mapToInt(Integer::intValue).toArray();
    }
}
